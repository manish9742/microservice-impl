package com.eapp.controller;

import com.eapp.entity.Hotel;
import com.eapp.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotel")
public class HotelController {


    @Autowired
    private HotelService hotelService;

  @PostMapping
  public ResponseEntity<Hotel>  createHotel(@RequestBody Hotel hotel){
      Hotel hotel1= hotelService.createHotel(hotel);
      return ResponseEntity.status(HttpStatus.CREATED).body(hotel1);
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<Hotel> getHotelById(@PathVariable String id){
      Hotel hotel=hotelService.getHotelById(id);
      return ResponseEntity.status(HttpStatus.OK).body(hotel);
  }

  @GetMapping
  public ResponseEntity<List<Hotel>> getAllHotel(){
      return ResponseEntity.ok(hotelService.getAllHotel());

  }

}
