package com.example.board.repository;

import com.example.board.controller.dto.BoardSearchDTO;
import com.example.board.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {

  List<Board> findAllSubjectContainsOrContentContainsOrModifiedAtIsLessThanEqual(
      String subject, String content, LocalDate modifiedAt);

}
