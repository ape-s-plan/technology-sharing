package com.jfxb.uframe.controller;

import com.jfxb.uframe.entity.User;
import com.jfxb.uframe.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class TestController {

    @Autowired
    private UserService userService;

    @PostMapping("/addUser")
    public ResponseEntity<?> addUser(@RequestBody User user) throws Exception {
        try {
            userService.addUser(user);
            return new ResponseEntity(HttpStatus.OK);
        }catch (Exception e){
            throw e;
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAll() throws Exception {
        return new ResponseEntity(userService.getAll(), HttpStatus.OK);
    }
}
