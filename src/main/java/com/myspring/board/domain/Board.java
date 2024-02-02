package com.myspring.board.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BOARD_ID")
    private Long id;

    @Enumerated(EnumType.STRING)
    private BoardType boardType;

    private String boardName;
    private String viewName;

    @OneToMany(mappedBy = "board", fetch = FetchType.LAZY)
    private List<Comment> commentList;

    @Builder
    public Board(BoardType boardType, String boardName, String viewName) {
        this.boardType = boardType;
        this.boardName = boardName;
        this.viewName = viewName;
    }
}
