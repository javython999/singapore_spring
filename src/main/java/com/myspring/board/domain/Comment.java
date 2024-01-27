package com.myspring.board.domain;


import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COMMENT_ID")
    private Long id;

    private String nickname;
    private LocalDateTime regDateTime;
    private String content;
    private int star;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BOARD_ID")
    @ToString.Exclude
    private Board board;

    @Builder
    public Comment(String nickname, LocalDateTime regDateTime, String content, int star, Board board) {
        this.nickname = nickname;
        this.regDateTime = regDateTime;
        this.content = content;
        this.star = star;
        this.board = board;
    }

    public void update(CommentRequestDto comment) {
        this.content = comment.getContent();
        this.star = comment.getStar();
    }
}
