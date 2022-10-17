package com.example.board.domain;

import com.example.board.domain.common.BaseTimeEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@Getter
@NoArgsConstructor
public class Board extends BaseTimeEntity {

  private String subject;
  private String content;

}
