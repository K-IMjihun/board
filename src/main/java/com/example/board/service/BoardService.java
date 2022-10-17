package com.example.board.service;

import com.example.board.controller.dto.BoardUpdateDTO;
import com.example.board.controller.vo.BoardVO;
import com.example.board.domain.Board;
import com.example.board.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService {

  @Autowired
  private BoardRepository boardRepository;

  public BoardVO insertBoard(BoardUpdateDTO dto) {
    Board board = Board.builder()
        .subject(dto.getSubject())
        .content(dto.getContent())
        .build();

    boardRepository.save(board);

    return new BoardVO(board);
  }

  public BoardVO updateBoard(Long boardId, BoardUpdateDTO dto) {

    Board board = boardRepository.findById(boardId)
        .orElseThrow(() -> new RuntimeException("board not found"));

    board.setSubject(dto.getSubject());
    board.setContent(dto.getContent());

    return new BoardVO(board);
  }

  public void deleteBoard(Long boardId) {
    if (boardRepository.findById(boardId).isEmpty()) {
      throw new RuntimeException("borad not found");
    }

    boardRepository.deleteById(boardId);
  }

}
