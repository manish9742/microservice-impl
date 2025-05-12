package com.eapp.Controller;

import com.eapp.entity.Users;
import com.eapp.service.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;


    @PostMapping("/")
    public ResponseEntity<Users> createUser(@RequestBody Users users){
        Users users1= userService.saveUsers(users);
        return ResponseEntity.status(HttpStatus.CREATED).body(users1);

    }

    @GetMapping("/{users}")
    public ResponseEntity<Users> createUser(@PathVariable String users){
        Users users1= userService.getUserById(users);
        return ResponseEntity.status(HttpStatus.OK).body(users1);

    }

     @GetMapping
    public ResponseEntity<List<Users>> getAllUsers(){
        List<Users> usersList= userService.getAllUser();
        return ResponseEntity.ok(usersList);

    }
}
