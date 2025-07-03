package com.qda.InsuranceManagementAPI.mapper;

import com.qda.InsuranceManagementAPI.dto.request.CreateUserRequest;
import com.qda.InsuranceManagementAPI.dto.response.UserResponse;
import com.qda.InsuranceManagementAPI.entity.User;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UserMapper {

    public static User toUser(CreateUserRequest request){
        return User
                .builder()
                .email(request.email())
                .firstName(request.firstName())
                .lastName(request.lastName())
                .build();
    }

    public static UserResponse toDto(User user){
        return new UserResponse(
                user.getFirstName(),
                user.getLastName(),
                user.getEmail()
        );
    }
}
