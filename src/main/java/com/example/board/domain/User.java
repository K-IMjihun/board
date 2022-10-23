package com.example.board.domain;

import com.example.board.controller.dto.UserInsertDTO;
import com.example.board.domain.common.BaseTimeEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = {"name"})},
    indexes = {@Index(columnList = "name")}
)
@Getter
@NoArgsConstructor
public class User extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(name = "name", nullable = false, length = 191)
    private String name;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Board> boardList = new ArrayList<>();

    public User (UserInsertDTO dto) {
        this.name = dto.getName();
    }
}