package com.myspring.board.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class CommentRequestDto {

    private String nickname;
    private LocalDateTime regDateTime;
    private String content;
    private int star;
}
