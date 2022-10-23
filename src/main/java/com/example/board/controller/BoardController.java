package com.example.board.controller;

import com.example.board.controller.dto.BoardSearchDTO;
import com.example.board.controller.dto.BoardUpdateDTO;
import com.example.board.controller.vo.BoardVO;
import com.example.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
/* 요청 API주소를 /api/v1/users 로 받겠다
 * 생성 -> PostMapping -> RequestBody
 * 조회 -> GetMapping -> Parameter
 * 수정 -> PutMapping -> RequestBody
 * 삭제 -> DeleteMapping -> pathVariable
 * */
//컨트롤러 : 요청을 받으면 dto를 통해 서비스에게 요청 전송
@RequestMapping("/api/v1/boards")
public class BoardController {

  @Autowired
  //의존객체의 타입에 해당하는 빈을 찾아 주입
  private BoardService boardService;

  //생성
  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
  //consumes : 입력받는 데이터의 타입을 정의
  //MediaType.APPLICATION_JSON_VALUE : JSON의 데이터만 담고있는 요청만 처리하겠다
  public ResponseEntity<BoardVO> insertBoard(@RequestBody BoardUpdateDTO dto) {
    BoardVO vo = boardService.insertBoard(dto);
    return new ResponseEntity<>(vo, HttpStatus.CREATED);
  }
  
  //id로 조회
  @GetMapping("/{board-id}")
  public ResponseEntity<BoardVO> getBoard(@PathVariable(name = "board-id") Long boardId) {
    BoardVO vo = boardService.getBoard(boardId);
    return new ResponseEntity<>(vo, HttpStatus.ACCEPTED);
  }

  // 미완성
  @GetMapping("list")
  public ResponseEntity<List<BoardVO>> searchBoard(BoardSearchDTO dto) {
    List<BoardVO> vo = boardService.searchBoard(dto);
    return new ResponseEntity<>(vo, HttpStatus.ACCEPTED);
  }

  //수정
  @PutMapping("/{board-id}")
  public ResponseEntity<BoardVO> updateBoard(@PathVariable(name = "board-id") Long boardId,
                                             @RequestBody BoardUpdateDTO dto) {
    BoardVO vo = boardService.updateBoard(boardId, dto);
    return new ResponseEntity<>(vo, HttpStatus.ACCEPTED);
  }

  //삭제
  @DeleteMapping("/{board-id}")
  public ResponseEntity<Void> deleteBoard(@PathVariable(name = "board-id") Long boardId) {
    boardService.deleteBoard(boardId);
    return new ResponseEntity<>(HttpStatus.ACCEPTED);
  }



}
