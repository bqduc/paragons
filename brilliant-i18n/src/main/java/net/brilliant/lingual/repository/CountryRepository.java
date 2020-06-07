/**
 * 
 */
package net.brilliant.lingual.repository;

import org.springframework.stereotype.Repository;

import net.brilliant.entity.general.Country;
import net.brilliant.framework.repository.CodeNameRepository;

/**
 * @author bqduc
 *
 */
@Repository
public interface CountryRepository extends CodeNameRepository<Country, Long> {
}
