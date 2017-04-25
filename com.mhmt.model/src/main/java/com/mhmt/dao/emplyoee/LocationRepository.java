package com.mhmt.dao.emplyoee;

import java.util.List;
import com.mhmt.domain.employee.Location;

public interface LocationRepository {
	boolean saveLocation(Location location);
	boolean deleteLocation(Location location);
	Location updateLocation(Location location);
	Location findLocationById(Long locationId);
	List<Location> findAllLocations();
}
