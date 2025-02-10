package com.khdev.projectjsp.member.repository;

import com.khdev.projectjsp.member.dto.MemberDTO;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepository {
    private final SqlSessionTemplate sql;

    public int save(MemberDTO memberDTO) {
        /*
        jsp에서 입력한 것들이 여기까지 잘와서 찍히나 보려고.
        */
        System.out.println("memberDTO = " + memberDTO);
        return sql.insert("Member.save", memberDTO);
        //memberMapper.xml에 insert id = "save"

    }

    public MemberDTO login(MemberDTO memberDTO) {
        return sql.selectOne("Member.login", memberDTO);
    }

    public List<MemberDTO> findAll() {
        return sql.selectList("Member.findAll");
    }

    public MemberDTO findById(Long id) {
        return sql.selectOne("Member.findById", id);
    }

    public void delete(Long id) {
        sql.delete("Member.delete", id);
    }

    public MemberDTO findByMemberEmail(String loginEmail) {
        //Mapper에 이메일 값을 넘겨줌
        return sql.selectOne("Member.findByMemberEmail", loginEmail);
    }

    public int update(MemberDTO memberDTO) {
        return sql.update("Member.update", memberDTO);
    }
}
