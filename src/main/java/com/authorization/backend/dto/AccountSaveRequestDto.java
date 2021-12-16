package com.authorization.backend.dto;

import com.authorization.backend.entity.Account;
import com.authorization.backend.Enum.AccountRole;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AccountSaveRequestDto {
    private String username;
    private String password;
    private AccountRole role;

    @Builder
    public AccountSaveRequestDto(String id, String password, AccountRole role) {
        this.username = id;
        this.password = password;
        this.role = role;
    }

    public Account toEntity() {
        return Account.builder()
                .username(username)
                .password(password)
                .role(role).build();
    }
}
