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

    public BoardDTO findBoardById(Long id) {
        return boardRepository.findBoardById(id);
    }

    public void updateHits(Long id) {
        boardRepository.updateHits(id);
    }

    public void delete(Long id) {
        boardRepository.delete(id);
    }

    public void update(BoardDTO boardDTO) {
        boardRepository.update(boardDTO);
    }
}
