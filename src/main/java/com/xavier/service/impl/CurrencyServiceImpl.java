package com.xavier.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Optional;

import org.apache.commons.beanutils.BeanUtils;

import com.xavier.dto.CurrencyDTO;
import com.xavier.entity.Currency;
import com.xavier.exceptions.ServiceException;
import com.xavier.repository.CurrencyRepository;
import com.xavier.service.CurrencyService;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@ApplicationScoped
public class CurrencyServiceImpl implements CurrencyService {

    @Inject
    private CurrencyRepository currencyRepository;

    @Override
    @Transactional
    public CurrencyDTO create(@Valid CurrencyDTO currencyDTO) {
        if (existsByName(currencyDTO.getName())) {
            throw new ServiceException("Currency already exists");
        }
        Currency currency = toEntity(currencyDTO);
        currencyRepository.persist(currency);
        return toDTO(currency);
    }

    @Override
    @Transactional
    public CurrencyDTO findByName(String name) {
        Currency currency = currencyRepository.findByName(name);
        if (currency == null) {
            throw new ServiceException("Currency not found");
        }
        return toDTO(currency);
    }

    @Override
    public CurrencyDTO findById(Long id) {
        return currencyRepository
            .findByIdOptional(id)
            .map(this::toDTO)
            .orElseThrow(() -> new ServiceException("Currency with that id not Found!")); 
    }

    @Override
    public List<CurrencyDTO> findAll() {
        return currencyRepository
                .findAll()
                .stream()
                .map(this::toDTO)
                .toList();
    }

    @Override
    @Transactional
    public CurrencyDTO update(Long id, @Valid CurrencyDTO currencyDTO) {
        Currency currency = currencyRepository.findByIdOptional(id)
            .orElseThrow(() -> new ServiceException("Currency not found"));
        currency.setName(currencyDTO.getName());
        currencyRepository.persist(currency);
        return toDTO(currency);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Optional<Currency> currency = currencyRepository.findByIdOptional(id);
        if (currency.isEmpty()) {
            throw new ServiceException("Currency not found");
        }
        currencyRepository.delete(currency.get());
    }

    private Currency toEntity(CurrencyDTO currencyDTO) {
        Currency currency = new Currency();
        try {
            BeanUtils.copyProperties(currency, currencyDTO);
        } catch (IllegalAccessException | InvocationTargetException e) {
            // Handle the exception, e.g., log it or throw a custom exception
            throw new ServiceException("Error copying properties", e);
        }
        return currency;
    }

   private CurrencyDTO toDTO(Currency currency) {
       return CurrencyDTO.builder()
               .id(currency.getId())
               .name(currency.getName())
               .code(currency.getCode())
               .build();

   }

   private boolean existsByName(String name) {
    return currencyRepository.findByName(name) != null;
   }
    
    
}
