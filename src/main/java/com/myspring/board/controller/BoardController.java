package com.myspring.board.controller;

import com.myspring.board.domain.Board;
import com.myspring.board.domain.BoardType;
import com.myspring.board.domain.Comment;
import com.myspring.board.domain.CommentRequestDto;
import com.myspring.board.service.BoardService;
import com.myspring.board.service.CommentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;

import static com.myspring.board.domain.BoardType.*;

@Controller
@RequiredArgsConstructor
@Slf4j
public class BoardController {

    private final BoardService boardService;
    private final CommentService commentService;

    @GetMapping("/board/{boardId:[0-9]+}")
    public String read(@PathVariable Long boardId, Model model) {
        Board board = boardService.findById(boardId);
        String viewName = mappingView(board.getBoardType());

        model.addAttribute("board", board);
        model.addAttribute("commentList", board.getCommentList());
        model.addAttribute("boardList", boardService.findAll());
        model.addAttribute("starAVG", boardService.getStarAvg(boardId));

        return "board/" + viewName;
    }

    private String mappingView(BoardType boardType) {
        String viewName = "";

        if (MARINA_BAY_SANDS.equals(boardType)) {
            viewName = "marinabaysands";
        } else if (GARDENS_BY_THE_BAY.equals(boardType)){
            viewName = "gardensbythebay";
        } else if (CHINA_TOWN.equals(boardType)){
            viewName = "chinatown";
        } else if (SENTOSA_ISLAND.equals(boardType)){
            viewName = "sentosa";
        }

        return viewName;
    }

    @PostMapping("/board/{boardId:[0-9]+}/comment")
    public String insert(@PathVariable Long boardId, CommentRequestDto commentReqeustDto, HttpSession session) {

        String nickname = (String) session.getAttribute("user_nickname");

        Board board = boardService.findById(boardId);

        Comment findComment = commentService.findByBoardAndNickname(board, nickname);

        if (findComment == null) {
            Comment comment = Comment.builder()
                    .board(board)
                    .nickname(session.getAttribute("user_nickname").toString())
                    .content(commentReqeustDto.getContent())
                    .star(commentReqeustDto.getStar())
                    .regDateTime(LocalDateTime.now())
                    .build();

            commentService.save(comment);
        } else {
            commentService.update(findComment.getId(), commentReqeustDto);
        }

        return "redirect:/board/" + boardId + "#commentList";
    }




}
