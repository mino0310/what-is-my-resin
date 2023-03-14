package com.example.sandbox.controller;

import com.example.sandbox.domain.User;
import com.example.sandbox.request.Signup;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.restdocs.mockmvc.MockMvcRestDocumentation;
import org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders;
import org.springframework.restdocs.payload.PayloadDocumentation;
import org.springframework.restdocs.snippet.Attributes;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;


@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureRestDocs
@ExtendWith(RestDocumentationExtension.class)
class UserControllerTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("회원가입 성공")
    void SignupSuccess() throws Exception {

        // given
        Signup signup = Signup.builder()
                .name("minos")
                .email("mino@naver.com")
                .password("12341234")
                .build();


        String jsonSignup = objectMapper.writeValueAsString(signup);

        // expected

        this.mockMvc.perform(RestDocumentationRequestBuilders.post("/signup")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonSignup))
                .andDo(MockMvcResultHandlers.print())
                .andDo(MockMvcRestDocumentation.document("index",
                        PayloadDocumentation.requestFields(
                                PayloadDocumentation.fieldWithPath("name").description("이름").attributes(Attributes.key("머임").value(true)),
                                PayloadDocumentation.fieldWithPath("password").description("비밀번호"),
                                PayloadDocumentation.fieldWithPath("email").description("이메일").attributes(Attributes.key("optional").value(true)))));



    }

}