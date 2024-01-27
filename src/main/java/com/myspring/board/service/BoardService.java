package com.myspring.board.service;

import com.myspring.board.domain.Board;
import com.myspring.board.domain.BoardType;
import com.myspring.board.domain.Comment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    public Board save(Board board) {
        return boardRepository.save(board);
    }

    public List<Board> findAll() {
        return boardRepository.findAll();
    }

    public Board findById(Long id) {
        Optional<Board> findBoard = boardRepository.findById(id);
        if (findBoard.isEmpty()) {
            throw new NullPointerException("Board Not Exist");
        }
        return findBoard.get();
    }
    
    public Board findByType(BoardType boardType) {
        return boardRepository.findByBoardType(boardType);
    }

    public double getStarAvg(Long id) {
        Board board = findById(id);
        return board.getCommentList().stream()
                .mapToInt(Comment::getStar).average().orElse(0);
    }

}
