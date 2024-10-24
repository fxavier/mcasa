package com.xavier.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import com.xavier.dto.PropertyTypeDTO;
import com.xavier.entity.PropertyType;
import com.xavier.exceptions.ServiceException;
import com.xavier.repository.PropertyTypeRepository;
import com.xavier.service.PropertyTypeService;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@ApplicationScoped
public class PropertyTypeServiceImpl implements PropertyTypeService {

    @Inject
    private PropertyTypeRepository propertyTypeRepository;

    @Override
    @Transactional
    public PropertyTypeDTO create(@Valid PropertyTypeDTO propertyTypeDTO) {
        if (isPropertyTypeExists(propertyTypeDTO.getDescription())) {
            throw new ServiceException("Property type already exists");
        }
        PropertyType propertyType = toEntity(propertyTypeDTO);
        propertyTypeRepository.persist(propertyType);
        return toDTO(propertyType);
    }

    @Override
    public List<PropertyTypeDTO> findAll() {
        return propertyTypeRepository
            .listAll()
            .stream()
            .map(this::toDTO)
            .toList();
    }

    @Override
    public PropertyTypeDTO findById(Long id) {
        return propertyTypeRepository.findByIdOptional(id)
            .map(this::toDTO)
            .orElseThrow(() -> new ServiceException("Property type not found"));
    }

    @Override
    public PropertyTypeDTO findByDescription(String description) {
       PropertyType propertyType = propertyTypeRepository.findByDescription(description);
       if (propertyType == null) {
        throw new ServiceException("Property type not found");
       }
       return toDTO(propertyType);
    }

    @Override
    @Transactional
    public PropertyTypeDTO update(Long id, @Valid PropertyTypeDTO propertyTypeDTO) {
        PropertyType propertyType = propertyTypeRepository.findByIdOptional(id)
            .orElseThrow(() -> new ServiceException("Property type not found"));
        propertyType.setDescription(propertyTypeDTO.getDescription());
        propertyTypeRepository.persist(propertyType);
        return toDTO(propertyType);
    }

    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    private PropertyTypeDTO toDTO(PropertyType propertyType) {
        PropertyTypeDTO propertyTypeDTO = new PropertyTypeDTO();
        try {
            BeanUtils.copyProperties(propertyTypeDTO, propertyType);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new ServiceException("Error copying Property");
        }
        return propertyTypeDTO;
    }

    private PropertyType toEntity(PropertyTypeDTO propertyTypeDTO) {
        PropertyType propertyType = new PropertyType();
        try {
            BeanUtils.copyProperties(propertyType, propertyTypeDTO);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new ServiceException("Error copying Property");
        }
        return propertyType;    
    }

    private boolean isPropertyTypeExists(String description) {
        return propertyTypeRepository.findByDescription(description) != null;
    }
    
}
