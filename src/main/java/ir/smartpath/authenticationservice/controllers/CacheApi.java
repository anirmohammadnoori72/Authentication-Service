package ir.smartpath.authenticationservice.controllers;

import ir.smartpath.authenticationservice.configuration.Config;
import ir.smartpath.authenticationservice.fibo.IFiboSequenceBuilder;
import ir.smartpath.authenticationservice.payload.request.UpdateFiboCacheRequest;
import ir.smartpath.authenticationservice.payload.response.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class CacheApi {
    @Autowired
    IFiboSequenceBuilder FiboSequenceBuilder;

    @PostMapping("/updateFiboCache")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> updateFiboCache(@Valid @RequestBody UpdateFiboCacheRequest updateFiboCacheRequest) {
        Config.getInstance().setEnableFiboCache(updateFiboCacheRequest.isCacheStatus());
        return ResponseEntity.ok(new MessageResponse("cache update successfully"));

    }

}
