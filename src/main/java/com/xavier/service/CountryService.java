package com.xavier.service;

import java.util.List;

import com.xavier.dto.CountryDTO;

public interface CountryService {

    CountryDTO save(CountryDTO countryDTO);
    List<CountryDTO> findAll();
    CountryDTO findById(Long id);
    CountryDTO findByName(String name);
    CountryDTO update(CountryDTO countryDTO);
    void delete(Long id);
}
