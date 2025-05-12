package com.eapp.externalapis;

import com.eapp.entity.Ratings;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("RATING-SERVICE")
public interface RatingService {

    @PostMapping(value = "/v1/addrating")
    Ratings addRating(Ratings rating);
}
