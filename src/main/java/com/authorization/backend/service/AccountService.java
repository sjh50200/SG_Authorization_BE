package com.authorization.backend.service;

import com.authorization.backend.dto.AccountSaveRequestDto;
import com.authorization.backend.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class AccountService {
    private final AccountRepository accountRepository;

    @Transactional
    public Long save(AccountSaveRequestDto requestDto) {
        return accountRepository.save(requestDto.toEntity()).getId();
    }
}
