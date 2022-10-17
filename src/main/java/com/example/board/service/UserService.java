package com.example.board.service;

import com.example.board.controller.dto.UserInsertDTO;
import com.example.board.controller.dto.UserSearchByNameDTO;
import com.example.board.controller.vo.UserVO;
import com.example.board.domain.User;
import com.example.board.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
  @Autowired
  private UserRepository userRepository;

  public UserVO insertUser(UserInsertDTO dto) {
    // name 중복확인
    if (userRepository.findByName(dto.getName()).isPresent()) {
      throw new RuntimeException("already exists user");
    }

    // User 객체 생성
    User user = new User(dto);

    // User Save
    userRepository.save(user);

    return new UserVO(user);
  }

  public UserVO getUserById(Long id) {
    User user = userRepository.findById(id).orElseThrow(
        () -> new RuntimeException("user not found"));
    return new UserVO(user);
  }

  public UserVO getUserByName(UserSearchByNameDTO dto) {
    User user = userRepository.findByName(dto.getName())
        .orElseThrow(() -> new RuntimeException("user not found"));
    return new UserVO(user);
  }

  public List<UserVO> searchAllUser() {
    List<User> users = userRepository.findAll();

//    List<UserVO> vos = new ArrayList<>();
//    users.forEach(user -> vos.add(new UserVO(user)));

    return users.stream().map(UserVO::new)
        .collect(Collectors.toList());
  }

  public List<UserVO> searchUserByName(UserSearchByNameDTO dto) {
    List<User> users = userRepository.findAllByNameContains(dto.getName());
    return users.stream().map(UserVO::new)
        .collect(Collectors.toList());
  }

}
