package com.khdev.projectjsp.member.controller;

import com.khdev.projectjsp.member.dto.BoardDTO;
import com.khdev.projectjsp.member.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
}
