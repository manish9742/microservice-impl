package com.eapp.service;

import com.eapp.entity.Hotel;
import com.eapp.entity.Ratings;
import com.eapp.entity.Users;
import com.eapp.externalapis.HotelService;
import com.eapp.externalapis.RatingService;
import com.eapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;

@Service
class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    HotelService hotelService;

    @Autowired
    RatingService ratingService;

    @Override
    public Users saveUsers(Users users) {

        String randomUUID = UUID.randomUUID().toString();
        users.setUserId(randomUUID);
        return userRepository.save(users);
    }

    @Override
    public List<Users> getAllUser() {
        List<Users> usersList = userRepository.findAll();
        return usersList;
    }

    @Override
    public Users getUserById(String id) {
        Optional<Users> users = userRepository.findById(id);

        Ratings[] ratings = restTemplate.getForObject("http://RATING-SERVICE/v1/getratingbyuserid/" + id, Ratings[].class);

        List<Ratings> listOfRating = Arrays.stream(ratings).toList();

        List<Ratings> ratingsList = listOfRating.stream().map(x -> {
           // ResponseEntity<Hotel> hotel = restTemplate.getForEntity("http://HOTEL-SERVICE/v1/gethotelbyid/" + x.getHotelId(), Hotel.class);
           // Second approch by using open feign client
           Hotel hotel= hotelService.getHotelById(x.getHotelId());
            //x.setHotels(hotel.getBody());
            x.setHotels(hotel);
            //create rating using feign client
           // ratingService.addRating(x);
            return x;
        }).toList();

        users.get().setRatings(ratingsList);

        return users.get();
    }
}
