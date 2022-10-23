package com.example.board.controller;

import com.example.board.controller.dto.UserInsertDTO;
import com.example.board.controller.dto.UserSearchByNameDTO;
import com.example.board.controller.vo.UserVO;
import com.example.board.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class  UserController {

    @Autowired
    private UserService userService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserVO> insertUser(@RequestBody UserInsertDTO dto) {
        UserVO vo = userService.insertUser(dto);
        return new ResponseEntity<>(vo, HttpStatus.ACCEPTED);
    }

    @GetMapping("/by-id/{user-id}")
    public ResponseEntity<UserVO> getUserById(@PathVariable(name = "user-id") Long userId){
        UserVO vo = userService.getUserById(userId);
        return new ResponseEntity<>(vo, HttpStatus.ACCEPTED);
    }

    @GetMapping("/by-name")
    public ResponseEntity<UserVO> getUserByName(UserSearchByNameDTO dto) {
        UserVO vo = userService.getUserByName(dto);
        return new ResponseEntity<>(vo, HttpStatus.ACCEPTED);
    }

    @GetMapping("/list")
    public ResponseEntity<List<UserVO>> searchAllUser() {
        List<UserVO> vo = userService.searchAllUser();
        return new ResponseEntity<>(vo, HttpStatus.ACCEPTED);
    }

    @GetMapping("/search-name")
    public ResponseEntity<List<UserVO>> searchUserByName(UserSearchByNameDTO dto) {
        List<UserVO> vo = userService.searchUserByName(dto);
        return new ResponseEntity<>(vo, HttpStatus.ACCEPTED);
    }


}

