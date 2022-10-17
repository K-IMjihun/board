package com.example.board.domain;

import com.example.board.domain.common.BaseTimeEntity;
import lombok.*;

import javax.persistence.Entity;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class Board extends BaseTimeEntity {

  private String subject;
  private String content;

}
