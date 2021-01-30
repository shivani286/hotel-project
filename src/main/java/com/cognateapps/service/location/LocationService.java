package com.cognateapps.service.location;

import com.cognateapps.entity.location.Location;
import com.cognateapps.request.location.LocationCreateRequest;
import com.cognateapps.request.location.LocationUpdateRequest;

public interface LocationService {

	Location findLocationById(Integer locationId);

	Location saveLocation(LocationCreateRequest locationCreateRequest);

	Location updateLocation(Integer locationId, LocationUpdateRequest locationUpdateRequest);

	void deleteLocation(Integer locationId);

}
