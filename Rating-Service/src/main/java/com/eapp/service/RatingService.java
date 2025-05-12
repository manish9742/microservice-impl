package com.eapp.service;

import com.eapp.entity.Rating;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface RatingService {

    Rating addRating(Rating rating);
    List<Rating> getRatingByHotelId(String hotelId);
    List<Rating> getHotelRatingId(String ratingId);
    List<Rating> fetchAllRecords();
}
