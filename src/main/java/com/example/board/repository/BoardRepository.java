package com.example.board.repository;

import com.example.board.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {

  /**
   *
   * select count(*)
   * from board
   * where subject like '%검색어%'
   * or content like '%검색어%';
   *
   */

  List<Board> findAllBySubjectContainsIgnoreCaseOrContentContainsIgnoreCase(String subject, String content);


}
