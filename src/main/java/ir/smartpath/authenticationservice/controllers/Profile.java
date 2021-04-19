package ir.smartpath.authenticationservice.controllers;

import ir.smartpath.authenticationservice.fibo.IFiboSequenceBuilder;
import ir.smartpath.authenticationservice.models.User;
import ir.smartpath.authenticationservice.payload.request.GetUserRequest;
import ir.smartpath.authenticationservice.payload.request.UpdateProfileRequest;
import ir.smartpath.authenticationservice.payload.response.MessageResponse;

import ir.smartpath.authenticationservice.repository.UserRepository;
import ir.smartpath.authenticationservice.security.services.TokenStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/profile")
public class Profile {


    @Autowired
    private TokenStore tokenStore;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/update")
    public ResponseEntity<?> update(@Valid @RequestBody UpdateProfileRequest updateProfileRequest) {
        if (!tokenStore.hasToken(updateProfileRequest.getToken())) {
            return ResponseEntity.badRequest().body(new MessageResponse("invalid token"));
        }

        User user = userRepository.findById(updateProfileRequest.getId())
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + updateProfileRequest.getId()));

        user.setBirthDate(updateProfileRequest.getBirthDate());

        user.setMale(updateProfileRequest.isMale());

        user.setSportFiled(updateProfileRequest.getSportFiled());

        user.setEducationFiled(updateProfileRequest.getEducationFiled());

        user.setDegree(updateProfileRequest.getDegree());

        user.setName(updateProfileRequest.getName());

        user.setFamily(updateProfileRequest.getFamily());

        user.setLevel(updateProfileRequest.getLevel());

        user.setFilledProfile(true);

        userRepository.save(user);
        return ResponseEntity.ok().body("user successfully updated");
    }

    @PostMapping("/getById")
    public ResponseEntity<?> get(@Valid @RequestBody GetUserRequest getUserRequest) {
        if (!tokenStore.hasToken(getUserRequest.getToken())) {
            return ResponseEntity.badRequest().body(new MessageResponse("invalid token"));
        }

        User user = userRepository.findById(getUserRequest.getId())
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + getUserRequest.getId()));

        if (!user.isFilledProfile()) {
            return ResponseEntity.badRequest().body(new MessageResponse("user not fully registered"));
        }


        return ResponseEntity.ok().body(user);
    }
}
