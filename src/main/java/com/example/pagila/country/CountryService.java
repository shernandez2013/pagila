package com.example.pagila.country;

import com.example.pagila.exceptions.SakilaException;

import java.util.List;

public interface CountryService {

    List<CountryResponse> getCountries() throws SakilaException;

    CountryResponse getCountryById(Integer countryId) throws SakilaException;

    void saveCountry(CountryRequest request) throws SakilaException;

    void deleteCountry(Integer id) throws SakilaException;

    void updateCountry(CountryRequest request);
}
