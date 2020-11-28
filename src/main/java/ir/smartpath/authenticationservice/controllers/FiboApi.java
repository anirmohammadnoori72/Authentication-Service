package ir.smartpath.authenticationservice.controllers;

import ir.smartpath.authenticationservice.fibo.FiboSequenceBuilder;
import ir.smartpath.authenticationservice.fibo.IFiboSequenceBuilder;
import ir.smartpath.authenticationservice.payload.request.GetFiboRequest;
import ir.smartpath.authenticationservice.payload.response.MessageResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class FiboApi {


    @Autowired
    IFiboSequenceBuilder FiboSequenceBuilder ;

    @PostMapping("/getFibo")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<?> getFiboTerm(@Valid @RequestBody GetFiboRequest getFiboRequest){
        try {
            return  ResponseEntity.ok(new MessageResponse(FiboSequenceBuilder.get(getFiboRequest.getTerm()).toString()));
        } catch (Exception e) {
            return  ResponseEntity.ok(new MessageResponse("error"));
        }
    }
}
