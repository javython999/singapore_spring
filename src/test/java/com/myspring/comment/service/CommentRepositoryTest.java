package com.myspring.comment.service;


import com.myspring.TestEnv;
import com.myspring.comment.domain.Comment;
import lombok.RequiredArgsConstructor;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;

@RequiredArgsConstructor
public class CommentRepositoryTest extends TestEnv {

    @Autowired
    CommentRepository commentRepository;

    @Test
    @DisplayName("Comment를 저장 할 수 있다.")
    public void save() {
        // given
        Comment board = new Comment();

        // when
        commentRepository.save(board);
        Comment findBoard = commentRepository.findById(board.getId()).get();

        // then
        Assertions.assertThat(findBoard.getId()).isEqualTo(board.getId());
    }

}