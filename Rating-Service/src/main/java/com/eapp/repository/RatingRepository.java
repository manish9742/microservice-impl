package com.eapp.repository;

import com.eapp.entity.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingRepository extends JpaRepository<Rating,String> {


    @Query(nativeQuery = true,value = " SELECT * FROM rating WHERE userid=? ")
    List<Rating> getRatingByUserId(String userid);

    @Query(" select u  from Rating u where u.hotelId = :hotelId")
    List<Rating> getRatingByHotelId(@Param("hotelId") String hotelId);

}
