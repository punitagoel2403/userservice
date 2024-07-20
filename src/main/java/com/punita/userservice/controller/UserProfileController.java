package com.punita.userservice.controller;

import com.punita.userservice.dto.UserProfileResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.punita.userservice.dto.UserProfileRequest;
import com.punita.userservice.service.UserProfileService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserProfileController {

    @Autowired
    private UserProfileService userProfileService;

    @PostMapping
    public ResponseEntity createUser(@RequestBody UserProfileRequest userProfileRequest) {

        userProfileService.createUser(userProfileRequest);
        return ResponseEntity.ok("Success");

    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserProfileResponse> getUserById(@PathVariable String userId) {

        return Optional.ofNullable(userProfileService.getUserById(userId))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.noContent().build());

    }

    @GetMapping
    public ResponseEntity<List<UserProfileResponse>> getAllUsers() {

        return Optional.ofNullable(userProfileService.getAllUsers())
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.noContent().build());

    }

}
