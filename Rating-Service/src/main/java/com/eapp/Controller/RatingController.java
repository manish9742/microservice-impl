package com.eapp.Controller;

import com.eapp.entity.Rating;
import com.eapp.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/")
public class RatingController {

    @Autowired
    RatingService service;

    @PostMapping(value = "addrating")
    public ResponseEntity<Rating> addRating(@RequestBody Rating rating) {
        Rating rating1 = service.addRating(rating);
        return ResponseEntity.status(HttpStatus.CREATED).body(rating1);
    }
    @GetMapping(value = "getratingbyhotelId/{hotelId}")
    public ResponseEntity<List<Rating>> getRatingByid(@PathVariable String hotelId) {
        List<Rating> rating1 = service.getRatingByHotelId(hotelId);
        return ResponseEntity.status(HttpStatus.OK).body(rating1);
    }
    @GetMapping(value = "getratingbyuserid/{userId}")
    public ResponseEntity<List<Rating>> getRatingByUserId(@PathVariable String userId) {
        List<Rating>  ratings = service.getHotelRatingId(userId);
        return ResponseEntity.status(HttpStatus.OK).body(ratings);
    }

    @GetMapping(value = "getallrating")
    public ResponseEntity<List<Rating>> getAllRating() {
        return ResponseEntity.ok(service.fetchAllRecords());
    }

}
