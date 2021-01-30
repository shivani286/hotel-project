package com.cognateapps.entity.location;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString; 

@Entity
@Table(name = "location")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Location implements Serializable {

	private static final long serialVersionUID = 3443328912867463209L;

	@Id
	@Column(name = "location_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer locationId;
	
	@Column(name = "location_number")
	private String locationName;
}
