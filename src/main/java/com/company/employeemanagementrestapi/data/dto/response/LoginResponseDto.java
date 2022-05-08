package com.company.employeemanagementrestapi.data.dto.response;

import lombok.Data;

@Data
public class LoginResponseDto {
    private String token;
    private String tokeType="Bearer";

    public LoginResponseDto(String token) {
        this.token = token;
    }
}
