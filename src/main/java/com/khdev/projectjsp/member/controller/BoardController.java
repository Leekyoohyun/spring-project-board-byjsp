package com.khdev.projectjsp.member.controller;

import com.khdev.projectjsp.member.dto.BoardDTO;
import com.khdev.projectjsp.member.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {
    private final BoardService boardService;

    @GetMapping("/saveBoard")
    public String saveForm(){
        return "saveBoard";
    }

    @PostMapping("/saveBoard")
    public String save(@ModelAttribute BoardDTO boardDTO) {
        int saveResult = boardService.save(boardDTO);
        if(saveResult > 0){
            System.out.println(saveResult);
            return "redirect:/board/";
        }else{
            return "saveBoard";
        }
    }

    @GetMapping("/")
    public String findAll(Model model){
        List<BoardDTO> boardDTOList = boardService.findAll();
        model.addAttribute("boardList", boardDTOList);
        return "boardList";
    }

    @GetMapping("/deleteBoard")
    public String deleteBoard(@RequestParam Long id){
        boardService.deleteBoard(id);
        return "redirect:/board/";
    }

    @GetMapping
    public String findBoardById(@RequestParam Long id, Model model){
        BoardDTO boardDTO = boardService.findBoardById(id);
        model.addAttribute("board", boardDTO);
        return "boardDetail";
    }
}
