package com.capstone.kakaoJWT.controller;

import com.capstone.kakaoJWT.dto.KakaoTokenResponse;
import com.capstone.kakaoJWT.dto.KakaoUserInfoResponse;
import com.capstone.kakaoJWT.service.UserService;
import com.capstone.kakaoJWT.utills.KakaoTokenJsonData;
import com.capstone.kakaoJWT.utills.KakaoUserInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Description;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class KakaoController {
    private final KakaoTokenJsonData kakaoTokenJsonData;
    private final KakaoUserInfo kakaoUserInfo;

    private final UserService userService;

    @GetMapping("/index")
    public String index() {
        return "loginForm";
    }

    @Description("회원이 소셜 로그인을 마치면 자동으로 실행되는 API입니다. 인가 코드를 이용해 토큰을 받고, 해당 토큰으로 사용자 정보를 조회합니다." +
            "사용자 정보를 이용하여 서비스에 회원가입합니다.")
    @GetMapping("/oauth")
    @ResponseBody
    public String kakaoOauth(@RequestParam("code") String code) {
        log.info("인가 코드를 이용하여 토큰을 받습니다.");
        KakaoTokenResponse kakaoTokenResponse = kakaoTokenJsonData.getToken(code);
        log.info("토큰에 대한 정보입니다.{}", kakaoTokenResponse);
        KakaoUserInfoResponse userInfo = kakaoUserInfo.getUserInfo(kakaoTokenResponse.getAccess_token());
        log.info("회원 정보 입니다.{}", userInfo);

        userService.createUser(userInfo.getKakao_account().getEmail());

        return "okay";
    }
}