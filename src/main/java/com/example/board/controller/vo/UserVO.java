package com.example.board.controller.vo;

import com.example.board.domain.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // Getter, Setter, RequiredArgsConstructor
@NoArgsConstructor // 기본 생성자
@AllArgsConstructor // 필드 전체를 가지고 있는 생성자
public class UserVO { // VO: Value Object

    private Long id;
    private String name;

    public UserVO(User user) {
        this.id = user.getId();
        this.name = user.getName();
    }
}
