package com.myspring.board.service;

import com.myspring.TestEnv;
import com.myspring.board.domain.Board;
import com.myspring.board.domain.BoardType;
import com.myspring.board.domain.Comment;
import com.myspring.board.domain.CommentRequestDto;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@Transactional
public class CommentServiceTest extends TestEnv {

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    BoardService boardService;

    @Test
    @DisplayName("Comment를 저장, 조회 할 수 있다.")
    public void CommentServiceTest() {
        Board board = Board.builder()
                .boardName("tsetBoard")
                .boardType(BoardType.MARINA_BAY_SANDS)
                .build();

        boardService.save(board);

        // given
        Comment comment = Comment.builder()
                .nickname("nickname")
                .content("content")
                .star(5)
                .regDateTime(LocalDateTime.now())
                .board(board)
                .build();

        // when
        commentRepository.save(comment);
        Comment findComment = commentRepository.findByBoardAndNickname(board, "nickname");

        // then
        assertThat(findComment.getId()).isEqualTo(comment.getId());
        assertThat(findComment.getContent()).isEqualTo(comment.getContent());
        assertThat(findComment.getStar()).isEqualTo(comment.getStar());
        assertThat(findComment.getRegDateTime()).isEqualTo(comment.getRegDateTime());
        assertThat(findComment.getBoard().getId()).isEqualTo(comment.getBoard().getId());
    }

    @Test
    @DisplayName("Comment를 수정할 수 있다.")
    public void update() {
        // given
        Board board = Board.builder()
                .boardName("tsetBoard")
                .boardType(BoardType.MARINA_BAY_SANDS)
                .build();

        boardService.save(board);

        // given
        LocalDateTime insertDateTime = LocalDateTime.now();
        Comment comment = Comment.builder()
                .nickname("nickname")
                .content("content")
                .star(5)
                .regDateTime(insertDateTime)
                .board(board)
                .build();

        CommentRequestDto updateParam = new CommentRequestDto();

        try{
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        LocalDateTime updateDateTime = LocalDateTime.now();

        updateParam.setContent("content!");
        updateParam.setStar(1);
        updateParam.setRegDateTime(updateDateTime);
        updateParam.setNickname("NICKNAME");

        // when
        commentRepository.save(comment);
        comment.update(updateParam);

        // then
        assertThat(comment.getContent()).isNotEqualTo("content");
        assertThat(comment.getContent()).isEqualTo("content!");
        assertThat(comment.getStar()).isNotEqualTo(5);
        assertThat(comment.getStar()).isEqualTo(1);
        assertThat(comment.getRegDateTime().isAfter(insertDateTime)).isTrue();
    }

}