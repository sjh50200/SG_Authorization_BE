package com.authorization.backend.entity;

import com.authorization.backend.Enum.AccountRole;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
//@Setter //Setter 지향
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(of = "id")
public class Account {
    @Id @GeneratedValue
    private Long id;
    private String username;
    private String password;
    @Enumerated(EnumType.STRING)
    private AccountRole role;
}
