package com.khdev.projectjsp.member.controller;

import com.khdev.projectjsp.member.dto.BoardDTO;
import com.khdev.projectjsp.member.dto.PageDTO;
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
        boardService.updateHits(id);
        BoardDTO boardDTO = boardService.findBoardById(id);
        model.addAttribute("board", boardDTO);
        return "boardDetail";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") Long id){
        boardService.delete(id);
        return "redirect:/board/";
    }

    @GetMapping("/boardUpdate")
    public String updateForm(@RequestParam("id") Long id, Model model){
        BoardDTO boardDTO = boardService.findBoardById(id);
        model.addAttribute("board", boardDTO);
        return "boardUpdate";
    }

    @PostMapping("/boardUpdate")
    public String update(@ModelAttribute BoardDTO boardDTO, Model model){
        boardService.update(boardDTO);

        BoardDTO dto = boardService.findBoardById(boardDTO.getId());
        model.addAttribute("board", dto);
        return "boardDetail";
    }

    @PostMapping("/boardUpdate")
    public String recommend(@ModelAttribute BoardDTO boardDTO, Model model){
        boardService.updateRecommend(boardDTO.getRecommend());
        BoardDTO dto = boardService.findBoardById(boardDTO.getId());
        model.addAttribute("board", dto);
        return "boardDetail";
    }

    // /board/paging?page=2
    @GetMapping("/paging")
    public String paging(Model model,
                         @RequestParam(value = "page", required = false, defaultValue = "1") int page){
        System.out.println("page = " + page);
        //해당 페이지에서 보여줄 글 목록
        List<BoardDTO> pagingList = boardService.pagingList(page);
        System.out.println("pagintList = " + pagingList);
        PageDTO pageDTO = boardService.pagingParam(page);
        model.addAttribute("boardList", pagingList);
        model.addAttribute("paging", pageDTO);
        return "paging";
    }
}
