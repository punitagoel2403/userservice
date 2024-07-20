package com.punita.userservice.service;

import com.punita.userservice.dto.UserProfileResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.punita.userservice.dto.UserProfileRequest;
import com.punita.userservice.model.UserProfile;
import com.punita.userservice.repository.UserProfileRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UserProfileService {

    @Autowired
    private UserProfileRepository userProfileRepository;

    //Todo: check if should use inject by property or constructor
    //todo: implement aop for logging

    public void createUser(UserProfileRequest userProfileRequest) {
        UserProfile userProfile = UserProfile.builder()
                .userName(userProfileRequest.getUserName())
                .location(userProfileRequest.getLocation())
                .emailId(userProfileRequest.getEmailId())
                .createdOn((new Date())).build();

        userProfileRepository.save(userProfile);

    }

    public UserProfileResponse getUserById(String userId) {
        Optional<UserProfile> userProfile = userProfileRepository.findById(userId);
        System.out.println(userProfile);
        return userProfile.map(this::mapToUserProfileResponse).orElse(null);
    }

    public List<UserProfileResponse> getAllUsers() {
        List<UserProfile> userProfile = userProfileRepository.findAll();
        return userProfile.stream().map(this::mapToUserProfileResponse).toList();
    }

    private UserProfileResponse mapToUserProfileResponse(UserProfile user) {
        return UserProfileResponse.builder()
                .userId(user.getUserId())
                .userName(user.getUserName())
                .location(user.getLocation())
                .emailId(user.getEmailId())
                .build();
    }
}
