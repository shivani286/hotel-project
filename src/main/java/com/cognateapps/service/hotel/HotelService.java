package com.cognateapps.service.hotel;

import java.util.List;

import com.cognateapps.entity.hotel.Hotel;
import com.cognateapps.request.hotel.HotelCreateRequest;
import com.cognateapps.request.hotel.HotelUpdateRequest;

public interface HotelService {

	Hotel findHotelById(Integer hotelId);

	Hotel saveHotel(HotelCreateRequest hotelCreateRequest);

	Hotel updateHotel(Integer hotelId, HotelUpdateRequest hotelUpdateRequest);

	void deleteHotel(Integer hotelId);

	List<Hotel> findHotelByLocationId(Integer locationId);

}
