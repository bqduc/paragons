package net.brilliant.lingual.service;

import java.util.Optional;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import net.brilliant.entity.general.Country;
import net.brilliant.exceptions.ObjectNotFoundException;
import net.brilliant.framework.repository.BaseRepository;
import net.brilliant.framework.service.GenericServiceImpl;
import net.brilliant.lingual.repository.CountryRepository;


@Service
public class CountryServiceImpl extends GenericServiceImpl<Country, Long> implements CountryService {
	private static final long serialVersionUID = 1567818094326905142L;
	
	@Inject 
	private CountryRepository repository;
	
	protected BaseRepository<Country, Long> getRepository() {
		return this.repository;
	}

	@Override
	public Optional<Country> getByName(String name) throws ObjectNotFoundException {
		return this.repository.findByName(name);
	}

	@Override
	public Optional<Country> getByCode(String code) throws ObjectNotFoundException {
		return this.repository.findByCode(code);
	}
}
