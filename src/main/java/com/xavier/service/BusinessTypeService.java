package com.xavier.service;

import java.util.List;

import com.xavier.dto.BusinessTypeDTO;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.core.Response;


@ApplicationScoped
public interface BusinessTypeService {

    public void createBusinessType(BusinessTypeDTO businessTypeDTO) throws Exception;

    public void updateBusinessType(Long id, BusinessTypeDTO businessTypeDTO);

    public void deleteBusinessType(Long id);

    public Response getBusinessTypeById(Long id);

    public List<BusinessTypeDTO> getAllBusinessTypes();

    public List<BusinessTypeDTO> findByDescription(String description);

  
    
}
