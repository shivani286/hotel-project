package com.cognateapps.service.hotel.impl;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognateapps.dao.hotel.HotelDao;
import com.cognateapps.dao.location.LocationDao;
import com.cognateapps.entity.hotel.Hotel;
import com.cognateapps.entity.location.Location;
import com.cognateapps.request.hotel.HotelCreateRequest;
import com.cognateapps.request.hotel.HotelUpdateRequest;
import com.cognateapps.service.hotel.HotelService;

@Service
public class HotelServiceImpl implements HotelService{

	@Autowired
	private HotelDao hotelDao;
	
	@Autowired
	private LocationDao locationDao;
	
	@Override
	public Hotel findHotelById(Integer hotelId) {
		return hotelDao.findHotelByHotelId(hotelId);
	}

	@Override
	public Hotel saveHotel(HotelCreateRequest hotelCreateRequest) {
		Hotel hotel = new Hotel();
		hotel.setHotelName(hotelCreateRequest.getHotelName());
		
		if(Objects.isNull(hotelCreateRequest.getLocationId()))
			throw new IllegalArgumentException("Location id is null");
		
		Location location = locationDao.findLocationByLocationId(hotelCreateRequest.getLocationId());
		
		if(Objects.nonNull(location))
			hotel.setLocation(location);
		else
			throw new IllegalArgumentException("Location is not exist");
		
		return hotelDao.save(hotel);
	}

	@Override
	public Hotel updateHotel(Integer hotelId, HotelUpdateRequest hotelUpdateRequest) {

		if(Objects.isNull(hotelId))
			throw new IllegalArgumentException("Hotel id is null");
		
		Hotel hotel = hotelDao.findHotelByHotelId(hotelId);
		hotel.setHotelName(Objects.nonNull(hotelUpdateRequest.getHotelName()) ? hotelUpdateRequest.getHotelName() : hotel.getHotelName());
		
		Location location = locationDao.findLocationByLocationId(hotelUpdateRequest.getLocationId());
		
		if(Objects.nonNull(location))		
			hotel.setLocation(Objects.nonNull(location) ? location : hotel.getLocation());
		else
			throw new IllegalArgumentException("Location is not exist");
		
		return hotel;
	}

	@Override
	public void deleteHotel(Integer hotelId) {
		if(Objects.isNull(hotelId) || hotelId<=0)
			throw new NullPointerException("Hotel id is null or invalid");
		
		Hotel hotel = hotelDao.findHotelByHotelId(hotelId);
		hotelDao.delete(hotel);
	}

	@Override
	public List<Hotel> findHotelByLocationId(Integer locationId) {
		if(Objects.isNull(locationId))
			throw new NullPointerException("Location id is null");
		
		List<Hotel> hotel = hotelDao.findHotelByLocation(locationDao.findLocationByLocationId(locationId));
		return hotel;
	}

}
