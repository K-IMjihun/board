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
/* 여기로 들어오는 API주소를 /api/v1/user로 받겠다
 * 생성 -> PostMapping -> RequestBody
 * 조회 -> GetMapping -> Parameter
 * 수정 -> PutMapping -> RequestBody
 * 삭제 -> DeleteMapping -> pathVariable
 * */
public class  UserController { // 컨트롤러 역할 : 사용자의 요청을 받거나, 사용자에게 데이터를 전달해줌

    @Autowired
    //의존객체의 타입에 해당하는 빈을 찾아 주입
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

