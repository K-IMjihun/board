package com.example.board.service;

import com.example.board.controller.dto.BoardInsertDTO;
import com.example.board.controller.vo.BoardVO;
import com.example.board.domain.Board;
import com.example.board.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService {

  @Autowired
  private BoardRepository boardRepository;

  public BoardVO insertBoard(BoardInsertDTO dto) {
    Board board = Board.builder()
        .subject(dto.getSubject())
        .content(dto.getContent())
        .build();

    boardRepository.save(board);

    return new BoardVO(board);
  }

}
