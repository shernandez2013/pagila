package com.example.pagila.country;

import com.example.pagila.exceptions.SakilaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class CountryServiceImpl implements CountryService {
    private CountryRepository countryRepository;

    @Autowired
    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public List<CountryResponse> getCountries() throws SakilaException {
        return countryRepository.findAll().stream().map(CountryResponse::new).collect(Collectors.toList());
    }

    @Override
    public CountryResponse getCountryById(Integer countryId) throws SakilaException {
        return new CountryResponse(countryRepository.getReferenceById(countryId));
    }

    @Override
    @Transactional
    public void saveCountry(CountryRequest request) throws SakilaException {
        Country country = new Country();
        country.setCountryId(0);
        country.setCountry(request.getCountry());
        country.setLastUpdate(request.getLastUpdate());
        countryRepository.save(country);
    }

    @Override
    @Transactional
    public void deleteCountry(Integer id) throws SakilaException {
        Country country = countryRepository.getReferenceById(id);
        if (Objects.nonNull(country.getCountry())) {
            countryRepository.delete(country);
        } else {
            throw new EntityNotFoundException("Country not found");
        }
    }

    @Override
    public void updateCountry(CountryRequest request) {
        Country country = countryRepository.getReferenceById(request.getId());
        if (Objects.nonNull(country.getCountry())) {
            country.setCountry(request.getCountry());
            country.setLastUpdate(request.getLastUpdate());
            countryRepository.save(country);
        } else {
            throw new EntityNotFoundException("Country not found");
        }
    }
}
