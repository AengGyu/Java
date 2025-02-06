package com.aenggyu.orderSystem.domain.member;

import com.aenggyu.orderSystem.domain.Grade;
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
    private String loginId;
    private String password;
    private String name;
    private Grade grade;

    public Member(String loginId, String password, String name) {
        this.loginId = loginId;
        this.password = password;
        this.name = name;
        this.grade = Grade.BRONZE;
    }
}
