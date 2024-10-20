package com.xavier.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


@Entity
@Table(name = "subscription_plans")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubscriptionPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    private String name;

    @Column(nullable = false, precision = 38, scale = 2)
    private BigDecimal price;

    @Column(name = "property_limit")
    private Integer propertyLimit;

    @Column(name = "image_per_property_limit")
    private Integer imagePerPropertyLimit;

    private String features;
}
