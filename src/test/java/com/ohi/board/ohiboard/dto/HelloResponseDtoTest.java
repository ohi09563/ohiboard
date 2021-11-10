package com.ohi.board.ohiboard.dto;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class HelloResponseDtoTest {



    @Test
    public void 기능_테스트(){

            String name="abcd";
            String nickname="efgh";

            HelloResponseDto helloResponseDto = new HelloResponseDto(name,nickname);

        assertThat(helloResponseDto.getName()).isEqualTo(name); //get 메소드를 선언하지 않아도 getName()을 사용할 수 있습니다.
        assertThat(helloResponseDto.getNickname()).isEqualTo(nickname);

    }
}
