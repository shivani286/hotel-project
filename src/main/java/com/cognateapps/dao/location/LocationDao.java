package com.cognateapps.dao.location;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognateapps.entity.location.Location;


@Repository
public interface LocationDao extends JpaRepository<Location, Integer> {

	Location findLocationByLocationId(Integer locationId);

}
