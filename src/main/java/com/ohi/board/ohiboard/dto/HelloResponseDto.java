package com.ohi.board.ohiboard.dto;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class HelloResponseDto {

        private final String name;
        private final String nickname;

}