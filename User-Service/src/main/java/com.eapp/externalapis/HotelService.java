package com.eapp.externalapis;

import com.eapp.entity.Hotel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("HOTEL-SERVICE")
public interface HotelService {

    @GetMapping(value = "/v1/gethotelbyid/{hotelId}")
    Hotel getHotelById(@PathVariable("hotelId") String hotelId);

}
