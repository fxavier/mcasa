package com.xavier.service;

import com.xavier.dto.PropertyTypeDTO;

import jakarta.validation.Valid;

import java.util.List;

public interface PropertyTypeService {
    PropertyTypeDTO create(@Valid PropertyTypeDTO propertyTypeDTO);
    List<PropertyTypeDTO> findAll();
    PropertyTypeDTO findById(Long id);
    PropertyTypeDTO findByDescription(String description);
    PropertyTypeDTO update(Long id, @Valid PropertyTypeDTO propertyTypeDTO);
    void delete(Long id);
}
