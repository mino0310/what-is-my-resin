package com.example.sandbox.controller;


import com.example.sandbox.domain.User;
import com.example.sandbox.request.Signup;
import com.example.sandbox.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/signup")
    public Object signup(@RequestBody @Validated Signup signup, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            System.out.println("=====================");
            return bindingResult.getAllErrors();
        }

        Long userId = userService.singup(signup);
        return userId;
    }
}
