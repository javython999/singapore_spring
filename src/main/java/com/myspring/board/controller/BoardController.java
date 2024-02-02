package com.myspring.board.controller;

import com.myspring.board.domain.Board;
import com.myspring.board.domain.Comment;
import com.myspring.board.domain.CommentRequestDto;
import com.myspring.board.service.BoardService;
import com.myspring.board.service.CommentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;

@Controller
@RequiredArgsConstructor
@Slf4j
public class BoardController {

    private final String VIEW_SUFFIX = ".board";
    private final BoardService boardService;
    private final CommentRepository commentRepository;

    @GetMapping("/board/{boardId:[0-9]+}")
    public String read(@PathVariable Long boardId, Model model) {
        Board board = boardService.findById(boardId);
        String viewName = board.getViewName();

        model.addAttribute("board", board);
        model.addAttribute("commentList", board.getCommentList());
        model.addAttribute("boardList", boardService.findAll());
        model.addAttribute("starAVG", boardService.getStarAvg(boardId));

        return "board/" + viewName + VIEW_SUFFIX;
    }


    @PostMapping("/board/{boardId:[0-9]+}/comment")
    public String insert(@PathVariable Long boardId, CommentRequestDto commentReqeustDto, HttpSession session) {

        String nickname = (String) session.getAttribute("user_nickname");
        commentReqeustDto.setNickname(nickname);

        Board board = boardService.findById(boardId);

        Comment findComment = commentRepository.findByBoardAndNickname(board, nickname);

        if (findComment == null) {
            Comment comment = Comment.builder()
                    .board(board)
                    .nickname(nickname)
                    .content(commentReqeustDto.getContent())
                    .star(commentReqeustDto.getStar())
                    .regDateTime(LocalDateTime.now())
                    .build();
            commentRepository.save(comment);
        } else {
            commentReqeustDto.setRegDateTime(LocalDateTime.now());
            findComment.update(commentReqeustDto);
            commentRepository.save(findComment);
        }

        return "redirect:/board/" + boardId + "#commentList";
    }




}
