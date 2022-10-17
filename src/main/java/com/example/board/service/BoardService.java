package com.example.board.service;

import com.example.board.controller.dto.BoardSearchDTO;
import com.example.board.controller.dto.BoardUpdateDTO;
import com.example.board.controller.vo.BoardVO;
import com.example.board.domain.Board;
import com.example.board.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
public class BoardService {

  @Autowired
  private BoardRepository boardRepository;

  @Transactional
  public BoardVO insertBoard(BoardUpdateDTO dto) {
    Board board = Board.builder()
        .subject(dto.getSubject())
        .content(dto.getContent())
        .build();

    boardRepository.save(board);

    return new BoardVO(board);
  }

  public List<BoardVO> searchBoard(BoardSearchDTO dto) {
    List<Board> boards = boardRepository.findAllBySubjectContainsOrContentContainsOrModifiedAtIsLessThanEqual(
        dto.getSubject(), dto.getContent(), dto.getUpdateDateTime());

    return boards.stream().map(BoardVO::new)
        .collect(Collectors.toList());
  }

  @Transactional
  public BoardVO updateBoard(Long boardId, BoardUpdateDTO dto) {

    Board board = boardRepository.findById(boardId)
        .orElseThrow(() -> new RuntimeException("board not found"));

    board.setSubject(dto.getSubject());
    board.setContent(dto.getContent());

    return new BoardVO(board);
  }

  @Transactional
  public void deleteBoard(Long boardId) {
    if (boardRepository.findById(boardId).isEmpty()) {
      throw new RuntimeException("borad not found");
    }

    boardRepository.deleteById(boardId);
  }

}
