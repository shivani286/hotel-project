package com.cognateapps.controller.hotel;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognateapps.entity.hotel.Hotel;
import com.cognateapps.request.hotel.HotelCreateRequest;
import com.cognateapps.request.hotel.HotelUpdateRequest;
import com.cognateapps.service.hotel.HotelService;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("hotel")
@Slf4j
@Api(tags = "Hotel Service")
public class HotelController {

	@Autowired
	private HotelService hotelService;
	
	
	@GetMapping("/{hotelId}")
	@ApiOperation(value = "${HotelController.gethotel}")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Conversion"),
            @ApiResponse(code = 401, message = "You are not authorized to send message"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
	
    public Hotel getHotelById(@PathVariable Integer hotelId) {
        return hotelService.findHotelById(hotelId);
    }
	
	@GetMapping("/location/{locationId}")
    public List<Hotel> getHotelByLocationId(@PathVariable Integer locationId) {
        return hotelService.findHotelByLocationId(locationId);
    }
	
	@PostMapping("/create")
	public Hotel createhotel(@RequestBody HotelCreateRequest hotelCreateRequest) {
		return hotelService.saveHotel(hotelCreateRequest);
	}

	/**
	 * update existing Hotel
	 * @param id
	 * @param Hotel
	 * @return
	 */
	@PutMapping("update/{hotelId}")
	public Hotel updatehotel(@PathVariable("hotelId")Integer hotelId, @RequestBody HotelUpdateRequest hotelUpdateRequest) {
		System.out.println("hotelID"+hotelId+"uadet Hotel requset==>"+hotelUpdateRequest);
		return hotelService.updateHotel(hotelId,hotelUpdateRequest);
	}
	
	/**
	 * delete Hotel(update Hotel (permanent delete))
	 * @param id
	 */
	@DeleteMapping("delete/{hotelId}")
	public void deletehotel(@PathVariable("hotelId") Integer hotelId) {
		hotelService.deleteHotel(hotelId);
	}
	
}
