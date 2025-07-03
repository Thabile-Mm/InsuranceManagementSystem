package com.qda.InsuranceManagementAPI.controller;

import com.qda.InsuranceManagementAPI.dto.request.CreateUserRequest;
import com.qda.InsuranceManagementAPI.dto.response.UserResponse;
import com.qda.InsuranceManagementAPI.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users/")
public class UserController {
    @Autowired
    private UserService service;

    @PostMapping
    public ResponseEntity<UserResponse> createUser(@RequestBody CreateUserRequest request){

        UserResponse response = service.createUser(request);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
