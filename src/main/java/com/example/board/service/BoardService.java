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
//읽기전용모드 R만 실행, CUD예방 및 성능향상
public class BoardService {

  @Autowired
  //필요한 의존객체 타입(생성자, setter, 필드일 경우)에 해당하는 빈 값을 찾아 주입
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

  public BoardVO getBoard(Long boardId) {
    Board board = boardRepository.findById(boardId)
        .orElseThrow(() -> new RuntimeException("board not found"));
        //예외처리. ID가 없을 시 board not found 출력
    return new BoardVO(board);
  }

  // 미완성
  public List<BoardVO> searchBoard(BoardSearchDTO dto) {
    List<Board> boards = boardRepository.findAllBySubjectContainsOrContentContainsOrModifiedAtIsLessThanEqual(
        dto.getSubject(), dto.getContent(), dto.getUpdateDateTime());

    return boards.stream().map(BoardVO::new)
        .collect(Collectors.toList());
  }

  //수정
  @Transactional
  public BoardVO updateBoard(Long boardId, BoardUpdateDTO dto) {

    Board board = boardRepository.findById(boardId)
        .orElseThrow(() -> new RuntimeException("board not found"));

    board.setSubject(dto.getSubject());
    board.setContent(dto.getContent());

    return new BoardVO(board);
  }

  @Transactional
  //요청에 하나라도 잘못된 응답 발생 시 모든 작업들을 원상태로 돌림
  public void deleteBoard(Long boardId) {
    if (boardRepository.findById(boardId).isEmpty()) {
      throw new RuntimeException("borad not found");
    }
    //.isEmpty() : 문자열의 길이가 0일 경우 true를 리턴.
    boardRepository.deleteById(boardId);
  }

}
