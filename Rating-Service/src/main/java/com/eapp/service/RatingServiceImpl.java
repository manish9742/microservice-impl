package com.eapp.service;

import com.eapp.entity.Rating;
import com.eapp.exceptions.ResourceNotFoundException;
import com.eapp.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RatingServiceImpl implements RatingService {

    @Autowired
    RatingRepository repository;

    @Override
    public Rating addRating(Rating rating) {
        String uuid=UUID.randomUUID().toString();
        rating.setRatingId(uuid);
        return repository.save(rating);
    }

    @Override
    public List<Rating> getRatingByHotelId(String hotelId) {
        return repository.getRatingByHotelId(hotelId);
    }

    @Override
    public List<Rating> getHotelRatingId(String ratingId) {
        return repository.getRatingByUserId(ratingId);
    }

    @Override
    public List<Rating> fetchAllRecords() {
        return repository.findAll();
    }
}
