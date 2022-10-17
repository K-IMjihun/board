package com.example.board.repository;

import com.example.board.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {

  List<Board> findAllBySubjectContainsOrContentContainsOrModifiedAtIsLessThanEqual(
      String subject, String content, LocalDate modifiedAt);

}
