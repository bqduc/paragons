package net.brilliant.lingual.service;

import java.util.Optional;

import net.brilliant.entity.general.City;
import net.brilliant.exceptions.ObjectNotFoundException;
import net.brilliant.framework.service.GenericService;

public interface CityService extends GenericService<City, Long> {
	/**
	 * Get one City with the provided name.
	 * 
	 * @param name
	 *            The City name
	 * @return The City
	 * @throws ObjectNotFoundException
	 *             If no such City exists.
	 */
	Optional<City> getByName(String name) throws ObjectNotFoundException;
}
