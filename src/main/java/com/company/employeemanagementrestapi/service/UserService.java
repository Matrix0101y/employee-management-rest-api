package com.company.employeemanagementrestapi.service;

import com.company.employeemanagementrestapi.data.dto.request.LoginRequestDto;
import com.company.employeemanagementrestapi.data.dto.request.RegisterRequestDto;
import com.company.employeemanagementrestapi.data.dto.request.ResetPasswordRequestDto;
import com.company.employeemanagementrestapi.data.dto.response.LoginResponseDto;
import org.springframework.http.ResponseEntity;

public interface UserService {

    LoginResponseDto login(LoginRequestDto loginRequestDto);

    ResponseEntity<String> register(RegisterRequestDto registerRequestDto);

    void registerConfirm(String activationCode);

    void resendEmail(String email);

    void forgetPassword(String email);

    void resetPassword(ResetPasswordRequestDto requestDto);
}
