package com.khdev.projectjsp.member.service;

import com.khdev.projectjsp.member.dto.BoardDTO;
import com.khdev.projectjsp.member.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    public int save(BoardDTO boardDTO) {
        return boardRepository.save(boardDTO);
    }

    public List<BoardDTO> findAll() {
        return boardRepository.findAll();
    }

    public void deleteBoard(Long id) {
        boardRepository.deleteBoard(id);
    }
}
