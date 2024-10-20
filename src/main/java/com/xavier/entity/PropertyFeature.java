package com.xavier.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "property_features")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PropertyFeature {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @Column(unique = true)
    private String description;

    private int bedrooms;
    private int bathrooms;
    private int diningrooms;
    private Integer kitchens;
    private Integer sittingrooms;
    private Integer wifi;
    private Integer parking;
    @Column(name = "swimming_pool")
    private Integer swimmingPool;
    private Integer gym;
    private Integer balcony;
    private BigDecimal area;

    @ManyToOne
    @JoinColumn(name = "property_id")
    private Property property;
}
