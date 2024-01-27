package com.myspring.board.service;

import com.myspring.board.domain.Board;
import com.myspring.board.domain.Comment;
import com.myspring.board.domain.CommentRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;

    public Comment save(Comment comment) {
        return commentRepository.save(comment);
    }

    public Comment findByBoardAndNickname(Board board, String nickname) {
        return commentRepository.findByBoardAndNickname(board, nickname);
    }

    public void update(Long commentId, CommentRequestDto reqeustDto) {
        Comment comment = commentRepository.findById(commentId).get();
        comment.update(reqeustDto);
        commentRepository.save(comment);
    }
}
