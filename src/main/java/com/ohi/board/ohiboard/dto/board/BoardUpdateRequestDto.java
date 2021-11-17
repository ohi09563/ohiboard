package com.ohi.board.ohiboard.dto.board;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BoardUpdateRequestDto {

    private String getTitle;
    private String getContent;

    public String getTitle() {
        return getTitle;
    }

    public String getContent() {
        return getContent;
    }
}
