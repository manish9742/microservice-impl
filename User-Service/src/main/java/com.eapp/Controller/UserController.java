package com.eapp.Controller;

import com.eapp.entity.Users;
import com.eapp.service.UserService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
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
    int retryCount=1;
    @GetMapping("/{users}")
   // @CircuitBreaker(name="ratingHotelBreaker",fallbackMethod = "ratingHotelFallBack")
    @Retry(name="ratingHotelService",fallbackMethod = "ratingHotelFallback")
    public ResponseEntity<Users> createUser(@PathVariable String users){
        Users users1= userService.getUserById(users);
        return ResponseEntity.status(HttpStatus.OK).body(users1);

    }

    //remember the parameter name should be same as pathvariable in above method

   public  ResponseEntity<Users> ratingHotelFallback(String users,Exception ex){
       System.out.println(retryCount++);
        Users  users1= Users.builder().email("abcd@gmail.com")
                .name("hare rama")
                .about("Service is down and its dummy response")
                .userId("1234")
                .build();
       return ResponseEntity.ok(users1);
    }

     @GetMapping
    public ResponseEntity<List<Users>> getAllUsers(){
        List<Users> usersList= userService.getAllUser();
        return ResponseEntity.ok(usersList);

    }
}
