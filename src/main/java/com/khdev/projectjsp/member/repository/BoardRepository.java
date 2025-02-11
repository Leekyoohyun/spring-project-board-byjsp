package com.khdev.projectjsp.member.repository;

import com.khdev.projectjsp.member.dto.BoardDTO;
import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;


@Repository
@RequiredArgsConstructor
public class BoardRepository {

    private final SqlSessionTemplate sql;

    public int save(BoardDTO boardDTO) {
        System.out.println(boardDTO);
        return sql.insert("Board.saveBoard", boardDTO);
    }
}
