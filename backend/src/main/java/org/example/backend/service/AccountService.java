package org.example.backend.service;

import lombok.RequiredArgsConstructor;
import org.example.backend.db.Account;
import org.example.backend.dto.request.UserInfoDto;
import org.example.backend.repository.AccountRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountService {
    private final AccountRepository accountRepository;

    public UserInfoDto getAccountById(Long accountId) {
        Account account = accountRepository.findById(accountId).get();
        return new UserInfoDto(account.getYourInfo(), account.getFollowersInfo());
    }
    public UserInfoDto saveUserInfo(Long accountId,UserInfoDto userInfoDto) {
        Account account = accountRepository.findById(accountId).get();
        account.setYourInfo(userInfoDto.yourInfo());
        account.setFollowersInfo(userInfoDto.followersInfo());
        accountRepository.save(account);

        return new UserInfoDto(account.getYourInfo(), account.getFollowersInfo());
    }

}
