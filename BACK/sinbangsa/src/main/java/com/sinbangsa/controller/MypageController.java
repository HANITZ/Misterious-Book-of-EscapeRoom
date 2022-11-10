package com.sinbangsa.controller;


import com.sinbangsa.data.dto.MypageInfoDto;
import com.sinbangsa.data.dto.ThemeForThemeListDto;
import com.sinbangsa.service.MypageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.StandardCharsets;
import java.util.List;

@RestController
@RequestMapping("/api/mypage")
@RequiredArgsConstructor
@Api(value = "마이페이지 API", tags = "마이페이지 API")
public class MypageController {

    private final Logger LOGGER = LoggerFactory.getLogger(MypageController.class);

    private final MypageService mypageService;

    @GetMapping
    @ApiOperation(value = "정보 받아오기")
    public ResponseEntity<MypageInfoDto> getMypageInfo() {
        LOGGER.info("[BookController] getMyPageInfo 호출");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", StandardCharsets.UTF_8));
        MypageInfoDto result = mypageService.getMyPageInfo();
        return new ResponseEntity<MypageInfoDto>(result, headers, HttpStatus.OK);

    }
}