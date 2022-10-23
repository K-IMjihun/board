package com.example.board.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BoardSearchDTO { // DTO: Data Transfer Object
  private String searchWords;
}
