package com.khdev.projectjsp.member.controller;

import com.khdev.projectjsp.member.dto.MemberDTO;
import com.khdev.projectjsp.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


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
}
