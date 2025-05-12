package com.eapp.service;

import com.eapp.entity.Hotel;
import com.eapp.exceptions.ResourceNotFoundException;
import com.eapp.repository.HotelRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    HotelRepository hotelRepository;

    @Override
    public Hotel createHotel(Hotel hotel) {
        String uuid=UUID.randomUUID().toString();
        hotel.setId(uuid);
        return hotelRepository.save(hotel);
    }

    @Override
    public Hotel getHotelById(String id) {
        return hotelRepository.findById(id).orElseThrow(()->new ResourceNotFoundException());
    }

    @Override
    public List<Hotel> getAllHotel() {
        return hotelRepository.findAll();
    }
}
