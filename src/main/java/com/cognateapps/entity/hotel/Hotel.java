package com.cognateapps.entity.hotel;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.cognateapps.entity.location.Location;

import java.io.Serializable;
import javax.persistence.JoinColumn;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString; 

@Entity
@Table(name = "hotel")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Hotel implements Serializable {

	private static final long serialVersionUID = 3443328912867463209L;

	@Id
	@Column(name = "hotel_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer hotelId;
	
	@Column(name = "hotel_number")
	private String hotelName;
	
	@ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "location_id_fk")
    private Location location;
	
	
}
