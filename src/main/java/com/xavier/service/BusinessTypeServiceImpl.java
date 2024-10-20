package com.xavier.service;

import java.util.List;

import com.xavier.dto.BusinessTypeDTO;
import com.xavier.entity.BusinessType;
import com.xavier.repository.BusinessTypeRepository;
import com.xavier.service.exception.BusinessTypeExistsException;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.core.Response;

@ApplicationScoped
public class BusinessTypeServiceImpl implements BusinessTypeService{

    @Inject
    private BusinessTypeRepository businessTypeRepository;

    @Override
    @Transactional
    public void createBusinessType(BusinessTypeDTO businessTypeDTO) {
        BusinessType businessType = new BusinessType();
        businessType.setDescription(businessTypeDTO.getDescription());
        BusinessTypeExists(businessTypeDTO.getDescription());
        businessTypeRepository.persist(businessType);
       
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
    public Response getBusinessTypeById(Long id) {
       return Response.ok(businessTypeRepository.findByIdOptional(id)).build();
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

    private BusinessTypeDTO toBusinessTypeDTO(BusinessType businessType){
        return new BusinessTypeDTO(businessType.getId(), businessType.getDescription());
    }

    private void BusinessTypeExists(String description){
        BusinessType businessTypeExists = businessTypeRepository
                     .findByDescription(description)
                     .stream()
                     .findFirst()
                     .orElse(null);
        if(businessTypeExists != null){
            throw new BusinessTypeExistsException();
        }
    }
    
}
