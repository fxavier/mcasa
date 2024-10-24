package com.xavier.repository;

import com.xavier.entity.PropertyType;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PropertyTypeRepository implements PanacheRepository<PropertyType> {
    public PropertyType findByDescription(String description) {
        return find("description", description).firstResult();
    }
}
