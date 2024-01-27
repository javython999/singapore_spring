package com.myspring.board.service;

import com.myspring.board.domain.Board;
import com.myspring.board.domain.BoardType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {
    Board findByBoardType(BoardType boardType);
}
