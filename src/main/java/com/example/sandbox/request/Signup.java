package com.example.sandbox.request;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@Builder
public class Signup {

    private String email;
    private String password;
    private String name;
}
