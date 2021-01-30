package com.cognateapps.request.hotel;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class HotelUpdateRequest {

	private String hotelName;
	private Integer locationId;
}
