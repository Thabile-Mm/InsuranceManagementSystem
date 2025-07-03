package com.qda.InsuranceManagementAPI.service;

import com.qda.InsuranceManagementAPI.dto.request.CreateUserRequest;
import com.qda.InsuranceManagementAPI.dto.response.UserResponse;
import com.qda.InsuranceManagementAPI.exceptions.FailedToCreateUserException;

public interface UserService {
    UserResponse createUser(CreateUserRequest request) throws FailedToCreateUserException;

}
