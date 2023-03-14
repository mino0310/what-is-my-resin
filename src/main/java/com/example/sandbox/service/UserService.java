package com.example.sandbox.service;


import com.example.sandbox.domain.User;
import com.example.sandbox.repository.UserRepository;
import com.example.sandbox.request.Signup;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public Long singup(Signup signup) {

        User signupUser = User.builder()
                .name(signup.getName())
                .email(signup.getEmail())
                .password(signup.getPassword())
                .build();

        User savedUser = userRepository.save(signupUser);

        return savedUser.getId();

    }


}
