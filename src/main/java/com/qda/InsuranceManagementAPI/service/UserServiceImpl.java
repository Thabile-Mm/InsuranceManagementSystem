package com.qda.InsuranceManagementAPI.service;

import com.qda.InsuranceManagementAPI.dto.request.CreateUserRequest;
import com.qda.InsuranceManagementAPI.dto.response.UserResponse;
import com.qda.InsuranceManagementAPI.entity.User;
import com.qda.InsuranceManagementAPI.exceptions.FailedToCreateUserException;
import com.qda.InsuranceManagementAPI.mapper.UserMapper;
import com.qda.InsuranceManagementAPI.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Override
    public UserResponse createUser(CreateUserRequest request) throws FailedToCreateUserException {

        if (request == null || request.lastName() == null || request.firstName() == null || request.email() == null){
            throw new FailedToCreateUserException("Failed to create user | request, lastname, firstname or email cannot be null");
        }

        if (confirmEmail(request.email())){
            throw new FailedToCreateUserException("Failed to create user | email address already exist");
        }

        try{

            User user = UserMapper.toUser(request);

            User createdUser = repository.save(user);

            return UserMapper.toDto(createdUser);

        }catch (Exception e){
            throw new FailedToCreateUserException("Failed to create user " + e.getMessage());
        }
    }

    // Helper methods
    private boolean confirmEmail(String email){
        return repository.getUserByEmail(email) != null;
    }
}
