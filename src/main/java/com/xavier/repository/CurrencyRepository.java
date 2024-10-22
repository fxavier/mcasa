package com.xavier.repository;


import com.xavier.entity.Currency;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CurrencyRepository implements PanacheRepository<Currency> {

    public Currency findByName(String name) {
        return find("name", name).firstResult();
    }
    
}
