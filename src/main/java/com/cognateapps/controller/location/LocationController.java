package com.cognateapps.controller.location;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognateapps.entity.location.Location;
import com.cognateapps.request.location.LocationCreateRequest;
import com.cognateapps.request.location.LocationUpdateRequest;
import com.cognateapps.service.location.LocationService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("location")
@Slf4j
@Api(tags = "Location Service")
public class LocationController {

	@Autowired
	private LocationService locationService;
	
	
	@GetMapping("/{locationId}")
	@ApiOperation(value = "${LocationController.getLocation}")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Conversion"),
            @ApiResponse(code = 401, message = "You are not authorized to send message"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
	
    public Location getLocationById(@PathVariable Integer locationId) {
        return locationService.findLocationById(locationId);
    }
	
	@PostMapping("/create")
	public Location createLocation(@RequestBody LocationCreateRequest locationCreateRequest) {
		return locationService.saveLocation(locationCreateRequest);
	}

	/**
	 * update existing Location
	 * @param id
	 * @param Location
	 * @return
	 */
	@PutMapping("update/{locationId}")
	public Location updateLocation(@PathVariable("LocationId")Integer locationId, @RequestBody LocationUpdateRequest locationUpdateRequest) {
		System.out.println("LocationID"+locationId+"uadet Location requset==>"+locationUpdateRequest);
		return locationService.updateLocation(locationId,locationUpdateRequest);
	}
	
	/**
	 * delete Location(update Location (permanent delete))
	 * @param id
	 */
	@DeleteMapping("delete/{locationId}")
	public void deleteLocation(@PathVariable("LocationId") Integer locationId) {
		locationService.deleteLocation(locationId);
	}
	
}
