package com.cognateapps.dao.hotel;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognateapps.entity.hotel.Hotel;
import com.cognateapps.entity.location.Location;

@Repository
public interface HotelDao extends JpaRepository<Hotel, Integer> {

	Hotel findHotelByHotelId(Integer hotelId);

	List<Hotel> findHotelByLocation(Location findLocationByLocationId);

}
