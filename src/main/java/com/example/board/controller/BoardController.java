package com.example.board.controller;

import com.example.board.controller.dto.BoardInsertDTO;
import com.example.board.controller.dto.BoardSearchDTO;
import com.example.board.controller.vo.BoardVO;
import com.example.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/boards")
public class BoardController {

  @Autowired
  private BoardService boardService;

  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<BoardVO> insertBoard(@RequestBody BoardInsertDTO dto) {

    return new ResponseEntity<>(null, HttpStatus.CREATED);
  }

  @GetMapping("list")
  public ResponseEntity<List<BoardVO>> searchBoard(BoardSearchDTO dto) {
    return new ResponseEntity<>(null, HttpStatus.ACCEPTED);
  }



}