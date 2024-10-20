package com.xavier.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PropertyDTO {
    private Long id;
    private String title;
    private String description;
    private Double price;
    private PropertyTypeDTO propertyType; // Referencing DTO
    private Integer bedrooms;
    private Integer bathrooms;
    private Integer diningrooms;
    private Integer kitchens;
    private Integer sittingrooms;
    private Integer wifi;
    private Integer parking;
    private Integer swimmingPool;
    private Integer gym;
    private Integer balcony;
    private CountryDTO country; // Referencing DTO
    private String city;
    private String zipCode;
    private String address;
    private Double latitude;
    private Double longitude;
    private BusinessTypeDTO businessType; // Referencing DTO
    private Boolean isFeatured;
    private Boolean isPrioritized;
    private Integer createdBy;
    private Boolean isActive;
}
