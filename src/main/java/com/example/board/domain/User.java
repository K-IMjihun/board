package com.example.board.domain;

import com.example.board.controller.dto.UserInsertDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "user",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = {"name"})},
    indexes = {@Index(columnList = "name")}
)
@Getter
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, length = 191)
    private String name;

    public User (UserInsertDTO dto) {
        this.name = dto.getName();
    }
}