package com.xavier.repository;

import com.xavier.entity.Country;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CountryRepository implements PanacheRepository<Country>{

    public Country findByName(String name) {
        return find("name", name).firstResult();
    }
    
}
