/**
 * 
 */
package net.brilliant.lingual.repository;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import net.brilliant.entity.general.City;
import net.brilliant.framework.repository.BaseRepository;

/**
 * @author bqduc
 *
 */
@Repository
public interface CityRepository extends BaseRepository<City, Long> {
	Optional<City> findByName(String name);
}
