package com.aenggyu.orderSystem.domain;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Member {

    private Long id;

    @NotEmpty
    private String loginId;

    @NotEmpty
    private String password;

    @NotEmpty
    private String name;
    private Grade grade;

    public Member(String loginId, String password, String name, Grade grade) {
        this.loginId = loginId;
        this.password = password;
        this.name = name;
        this.grade = grade;
    }
}
