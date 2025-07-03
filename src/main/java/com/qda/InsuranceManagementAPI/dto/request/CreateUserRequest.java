package com.qda.InsuranceManagementAPI.dto.request;

public record CreateUserRequest(
        String firstName,
        String lastName,
        String email
) {
}
