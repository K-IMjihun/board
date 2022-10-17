package com.example.board.repository;

import com.example.board.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository // 빈 객체, 어노테이션
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByName(String name);
    List<User> findAllByNameContains(String name);
}
