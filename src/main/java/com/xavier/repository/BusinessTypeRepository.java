package com.xavier.repository;

import java.util.List;


import com.xavier.entity.BusinessType;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public  class BusinessTypeRepository implements PanacheRepository<BusinessType>{

    public List<BusinessType> findByDescription(String description) {
        return list("description", description);
    }
    
}
