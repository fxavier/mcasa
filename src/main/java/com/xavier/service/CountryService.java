package com.xavier.service;

import java.util.List;

import com.xavier.dto.CountryDTO;


import jakarta.validation.Valid;


public interface CountryService {

    CountryDTO save(@Valid CountryDTO countryDTO);
    List<CountryDTO> findAll();
    CountryDTO findById(Long id);
    CountryDTO findByName(String name);
    CountryDTO update(Long id, @Valid CountryDTO countryDTO);
    void delete(Long id);
}
