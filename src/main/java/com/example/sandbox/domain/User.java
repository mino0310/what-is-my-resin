package com.example.sandbox.domain;


import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "이름을 입력해주세요")
    @Size(min=2, max=20, message = "최소 5자 이상, 최대 20자 이하여야 합니다.")
    private String name;

    @NotBlank(message = "비밀번호를 입력해주세요")
    @Size(min=2, max=20, message = "최소 5자 이상, 최대 20자 이하여야 합니다.")
    private String password;
    @NotBlank(message = "이메일을 입력해주세요")
    @Email(message = "이메일 형식을 지켜주세요")
    private String email;

    private String address;

    private String sex;

    @Builder
    public User(String name, String password, String email, String address, String sex) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.address = address;
        this.sex = sex;
    }
}
