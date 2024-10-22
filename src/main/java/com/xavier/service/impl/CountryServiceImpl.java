package com.xavier.service.impl;

import com.xavier.dto.CountryDTO;
import com.xavier.entity.Country;
import com.xavier.exceptions.ServiceException;
import com.xavier.repository.CountryRepository;
import com.xavier.service.CountryService;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

import java.util.List;

import org.apache.commons.beanutils.BeanUtils;


@ApplicationScoped
public class CountryServiceImpl implements CountryService {

    @Inject
    private CountryRepository countryRepository;

    @Override
    @Transactional
    public CountryDTO save(@Valid CountryDTO countryDTO) {
        Country existingCountry = countryRepository.findByName(countryDTO.getName());
        if (existingCountry != null) {
            throw new ServiceException("Country already exists");
        }   
        Country country = toEntity(countryDTO);
        countryRepository.persist(country);

        return toDTO(country);
    }

    @Override
    public List<CountryDTO> findAll() {
        
        return countryRepository
               .findAll()
               .stream()
               .map(this::toDTO)
               .toList();
    }

    @Override
    public CountryDTO findById(Long id) {
        return countryRepository
               .findByIdOptional(id)
               .map(this::toDTO)
               .orElseThrow(() -> new ServiceException("Country not found"));
    }

    @Override
    public CountryDTO findByName(String name) {
        Country country = countryRepository.findByName(name);
        return toDTO(country);
    }

    @Override
    @Transactional
    public CountryDTO update(Long id, @Valid CountryDTO countryDTO) {
        Country country = countryRepository.findByIdOptional(id)
                   .orElseThrow(() -> new ServiceException("Country not found"));
        country.setName(countryDTO.getName());
        countryRepository.persist(country);
        return toDTO(country);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Country country = countryRepository.findByIdOptional(id)
                   .orElseThrow(() -> new ServiceException("Country not found"));
        countryRepository.delete(country);
    }

    /* private CountryDTO toDTO(Country country) {
        CountryDTO countryDTO = new CountryDTO();
        try {
            BeanUtils.copyProperties(countryDTO, country);
        } catch (Exception e) {
            throw new ServiceException("Error converting Country to CountryDTO", e);
        }
        return countryDTO;
    } */

    private CountryDTO toDTO(Country country) {
        return CountryDTO.builder()
               .id(country.getId())
               .name(country.getName())
               .build();
    }

    private Country toEntity(CountryDTO countryDTO) {
        Country country = new Country();
        try {
            BeanUtils.copyProperties(country, countryDTO);
        } catch (Exception e) {
            throw new ServiceException("Error converting CountryDTO to Country", e);
        }
        return country;
    }
}
