package com.example.board.controller.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data // Getter, Setter, RequiredArgsConstructor
@NoArgsConstructor // 기본 생성자
@AllArgsConstructor // 필드 전체를 가지고 있는 생성자
public class BoardVO {

  private LocalDate createTime;
  private LocalDate updateTime;
  private String subject;
  private String content;

}
