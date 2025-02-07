package com.khdev.projectjsp.member.controller;

import com.khdev.projectjsp.member.dto.MemberDTO;
import com.khdev.projectjsp.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("/member") //공통주소는 이렇게 빼놓을 수 있음
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;
    //@GetMapping("/member/save")
    @GetMapping("/save")
    public String saveForm() {
        return "save";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute MemberDTO memberDTO) {
        int saveResult = memberService.save(memberDTO);
        if(saveResult > 0){
            return "login";
        }else{
            return "save";
        }
    }

    @GetMapping("/login")
    public String loginForm(){
        return "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute MemberDTO memberDTO , HttpSession session){
        boolean loginResult = memberService.login(memberDTO);
        /*
        성공 실패에 따라 처리를 해야함.
        로그인 하면 내 정보가 계속 따라다녀야 하니까
        이걸 위해 session 활용해야함.
        */
        if(loginResult){
            //session에다가 로그인한 사용자 정보를 입력하도록
            session.setAttribute("loginEmail", memberDTO.getMemberEmail());
            return "main";
        }else{
            return "login";
        }
    }

    @GetMapping("/")
    public String findAll(Model model){
        List<MemberDTO> memberDTOList = memberService.findAll();
        model.addAttribute("memberList", memberDTOList);
        return "list";
    }

    // /member?id=1
    @GetMapping
    public String findById(@RequestParam("id") Long id, Model model){
        MemberDTO memberDTO = memberService.findById(id);
        model.addAttribute("member", memberDTO);
        return "detail";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") Long id){
        memberService.delete(id);
        //리스트 재요청하려고
        return "redirect:/member/";
    }
}
