package com.xavier.service.impl;

import java.util.List;

import com.xavier.dto.BusinessTypeDTO;
import com.xavier.entity.BusinessType;
import com.xavier.exceptions.ServiceException;
import com.xavier.repository.BusinessTypeRepository;
import com.xavier.service.BusinessTypeService;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class BusinessTypeServiceImpl implements BusinessTypeService{

    @Inject
    private BusinessTypeRepository businessTypeRepository;

    @Override
    @Transactional
    public BusinessTypeDTO createBusinessType(BusinessTypeDTO businessTypeDTO) {
        if(businessTypeExists(businessTypeDTO.getDescription())){
            throw new ServiceException("Business type already exists");
        }
        BusinessType businessType = toEntity(businessTypeDTO);
        businessTypeRepository.persist(businessType);
        return toBusinessTypeDTO(businessType);
    }

    @Override
    @Transactional
    public void updateBusinessType(Long id, BusinessTypeDTO businessTypeDTO) {
        BusinessType businessType = businessTypeRepository.findById(id);
        businessType.setDescription(businessTypeDTO.getDescription());
        businessTypeRepository.persist(businessType);
        
    }

    @Override
    @Transactional
    public void deleteBusinessType(Long id) {
        businessTypeRepository.deleteById(id);
    }

    @Override
    public BusinessTypeDTO getBusinessTypeById(Long id) {
       return businessTypeRepository.findByIdOptional(id)
            .map(this::toBusinessTypeDTO)
            .orElseThrow(() -> new ServiceException("Business type not found"));
    }

    @Override
    public List<BusinessTypeDTO> getAllBusinessTypes() {
       List<BusinessTypeDTO> businessTypes = businessTypeRepository
            .listAll()
            .stream()
            .map(businessType -> toBusinessTypeDTO(businessType))
            .toList();
        return businessTypes;
    }


    @Override
    public List<BusinessTypeDTO> findByDescription(String description) {
        return businessTypeRepository.findByDescription(description).stream()
            .map(businessType -> new BusinessTypeDTO(businessType.getId(), businessType.getDescription()))
            .toList();
    }

    private BusinessType toEntity(BusinessTypeDTO businessTypeDTO){
        return BusinessType.builder()
            .description(businessTypeDTO.getDescription())
            .build();
    }

    private BusinessTypeDTO toBusinessTypeDTO(BusinessType businessType){
        return BusinessTypeDTO.builder()
            .id(businessType.getId())
            .description(businessType.getDescription())
            .build();
    }

    private boolean businessTypeExists(String description){
        BusinessType businessTypeExists = businessTypeRepository
                     .findByDescription(description)
                     .stream()
                     .findFirst()
                     .orElse(null);
        if(businessTypeExists != null){
            return true;
            
        }
        return false;
    }
    
}
