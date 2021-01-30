package com.cognateapps.service.location.impl;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognateapps.dao.location.LocationDao;
import com.cognateapps.entity.location.Location;
import com.cognateapps.request.location.LocationCreateRequest;
import com.cognateapps.request.location.LocationUpdateRequest;
import com.cognateapps.service.location.LocationService;

@Service
public class LocationServiceImpl implements LocationService{

	@Autowired
	private LocationDao locationDao;
	
	@Override
	public Location findLocationById(Integer locationId) {
		return locationDao.findLocationByLocationId(locationId);
	}

	@Override
	public Location saveLocation(LocationCreateRequest locationCreateRequest) {
		Location location = new Location();
		location.setLocationName(locationCreateRequest.getLocationName());
		return locationDao.save(location);
	}

	@Override
	public Location updateLocation(Integer locationId, LocationUpdateRequest locationUpdateRequest) {

		if(Objects.isNull(locationId))
			throw new IllegalArgumentException("Location id is null");
		
		Location location = locationDao.findLocationByLocationId(locationId);
		location.setLocationName(Objects.nonNull(locationUpdateRequest.getLocationName()) ? locationUpdateRequest.getLocationName() : location.getLocationName());
		return location;
	}

	@Override
	public void deleteLocation(Integer locationId) {
		if(Objects.isNull(locationId) || locationId<=0)
			throw new NullPointerException("Location id is null or invalid");
		
		Location location = locationDao.findLocationByLocationId(locationId);
		locationDao.delete(location);
	}

}
