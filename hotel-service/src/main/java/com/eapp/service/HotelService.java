package com.eapp.service;



import com.eapp.entity.Hotel;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface HotelService {

     Hotel createHotel(Hotel hotel);
     Hotel getHotelById(String id);
     List<Hotel> getAllHotel();
}
