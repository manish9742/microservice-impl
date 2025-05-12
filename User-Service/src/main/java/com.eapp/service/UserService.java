package com.eapp.service;

import com.eapp.entity.Users;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    Users saveUsers(Users users);

    List<Users> getAllUser();

    Users getUserById(String id);


}
