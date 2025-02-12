package com.khdev.projectjsp.member.repository;

import com.khdev.projectjsp.member.dto.BoardDTO;
import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@RequiredArgsConstructor
public class BoardRepository {

    private final SqlSessionTemplate sql;

    public int save(BoardDTO boardDTO) {
        System.out.println(boardDTO);
        return sql.insert("Board.saveBoard", boardDTO);
    }

    public List<BoardDTO> findAll() {
        return sql.selectList("Board.findAll");
    }

    public void deleteBoard(Long id) {
        sql.delete("deleteBoard", id);
    }

    public BoardDTO findBoardById(Long id) {
        return sql.selectOne("Board.findBoardById", id);
    }

    public void updateHits(Long id) {
        sql.update("Board.updateHits", id);
    }

    public void delete(Long id) {
        sql.delete("Board.delete", id);
    }
}
