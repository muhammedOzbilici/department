package com.mhmt.dao.emplyoee;

import com.mhmt.domain.employee.Location;

import java.util.List;

public interface LocationRepository {
    boolean saveLocation(Location location);

    boolean deleteLocation(Location location);

    Location updateLocation(Location location);

    Location findLocationById(Long locationId);

    List<Location> findAllLocations();
}
