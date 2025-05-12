package com.eapp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/staff")
public class StaffController {

    @GetMapping("/getall")
    public ResponseEntity<List<String>> getStaff(){
        return new ResponseEntity<>(Arrays.asList("Ram","shyam","sita"), HttpStatus.OK);

    }
}
