package com.xavier.service;

import com.xavier.dto.CurrencyDTO;

import jakarta.validation.Valid;

import java.util.List;

public interface CurrencyService {
    CurrencyDTO create(@Valid CurrencyDTO currencyDTO);
    CurrencyDTO findByName(String name);
    CurrencyDTO findById(Long id);
    List<CurrencyDTO> findAll();
    CurrencyDTO update(Long id, @Valid CurrencyDTO currencyDTO);
    void delete(Long id);
}
