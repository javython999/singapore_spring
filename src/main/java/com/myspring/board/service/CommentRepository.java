package com.myspring.board.service;

import com.myspring.board.domain.Board;
import com.myspring.board.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    Comment findByBoardAndNickname(Board board, String nickname);
}
