package com.xavier.service;

import java.util.List;

import com.xavier.dto.BusinessTypeDTO;

import jakarta.enterprise.context.ApplicationScoped;



@ApplicationScoped
public interface BusinessTypeService {

    public BusinessTypeDTO createBusinessType(BusinessTypeDTO businessTypeDTO) throws Exception;

    public void updateBusinessType(Long id, BusinessTypeDTO businessTypeDTO);

    public void deleteBusinessType(Long id);

    public BusinessTypeDTO getBusinessTypeById(Long id);

    public List<BusinessTypeDTO> getAllBusinessTypes();

    public List<BusinessTypeDTO> findByDescription(String description);

  
    
}
