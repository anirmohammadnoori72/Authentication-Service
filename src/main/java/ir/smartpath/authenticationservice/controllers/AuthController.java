package ir.smartpath.authenticationservice.controllers;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import ir.smartpath.authenticationservice.models.ERole;
import ir.smartpath.authenticationservice.models.Role;
import ir.smartpath.authenticationservice.models.User;
import ir.smartpath.authenticationservice.payload.request.*;
import ir.smartpath.authenticationservice.payload.response.JwtResponse;
import ir.smartpath.authenticationservice.payload.response.MessageResponse;
import ir.smartpath.authenticationservice.payload.response.RegisterLoginResponse;
import ir.smartpath.authenticationservice.payload.response.VerifiedOtpResponse;
import ir.smartpath.authenticationservice.repository.RoleRepository;
import ir.smartpath.authenticationservice.repository.UserRepository;
import ir.smartpath.authenticationservice.security.jwt.JwtUtils;
import ir.smartpath.authenticationservice.security.services.TokenStore;
import ir.smartpath.authenticationservice.security.services.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private TokenStore tokenStore;

    @PostMapping("/logout")
    public ResponseEntity<?> logout(@Valid @RequestBody LogoutRequest logoutRequest) {
        if (tokenStore.hasToken(logoutRequest.getToken())) {
            tokenStore.expireToken(logoutRequest.getToken());
            return ResponseEntity.ok(new MessageResponse("Successfully to logout user"));
        }

        return ResponseEntity.ok(new MessageResponse("token not found"));
    }

    @PostMapping("/registerLogin")
    public ResponseEntity registerLogin(@Valid @RequestBody RegisterLoginRequest registerLoginRequest) {

        int otp = 1234; // todo generate random
        User user = userRepository.findByNumber(registerLoginRequest.getNumber());
        Set<Role> roles = new HashSet<>();
        if (user == null) {
            user = new User(registerLoginRequest.getNumber(), otp);
            Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(userRole);
            userRepository.save(user);
        } else {
            userRepository.updateOtp(user.getId(), otp);
        }
        return ResponseEntity.ok(
                new RegisterLoginResponse(user.getId(), "otp successfully sending to Device", 1));
    }

    @PostMapping("/verifiedOtp")
    public ResponseEntity verifiedOpt(@Valid @RequestBody VerifiedOtpRequest verifiedOtpRequest) {
        User user = userRepository.findById(verifiedOtpRequest.getUserId())
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + verifiedOtpRequest.getOpt()));

        JwtResponse res = null;

        if (user.getOtp() == verifiedOtpRequest.getOpt()) {

            String jwt = jwtUtils.generateJwtToken(user.getId());

            tokenStore.store(jwt);
            res = new JwtResponse(jwt,
                    user.getId(),
                   user.isFilledProfile());

        } else {
           return ResponseEntity.badRequest().body(new MessageResponse("invalid otp"));
        }
        return ResponseEntity.ok(res);
    }

}
