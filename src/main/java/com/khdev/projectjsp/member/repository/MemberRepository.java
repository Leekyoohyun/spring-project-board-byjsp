package com.khdev.projectjsp.member.repository;

import com.khdev.projectjsp.member.dto.MemberDTO;
import org.springframework.stereotype.Repository;

@Repository
public class MemberRepository {
    public int save(MemberDTO memberDTO) {
        /*
        jsp에서 입력한 것들이 여기까지 잘와서 찍히나 보려고.
        */
        System.out.println("memberDTO = " + memberDTO);
        return 0;
    }
}
