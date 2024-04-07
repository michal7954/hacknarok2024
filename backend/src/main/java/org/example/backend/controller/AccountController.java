package org.example.backend.controller;

import lombok.RequiredArgsConstructor;
import org.example.backend.dto.request.UserInfoDto;
import org.example.backend.service.AccountService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AccountController {
    private final AccountService accountService;
    @GetMapping("/userInfo")
    public UserInfoDto getUserInfo() {
        UserInfoDto userInfo = accountService.getAccountById(1L);
        return userInfo;
    }
    @PostMapping("/userInfo")
    public UserInfoDto postUserInfo(@RequestBody UserInfoDto userInfo) {
        accountService.saveUserInfo(1L, userInfo);
        return userInfo;
    }

}
