package com.xavier.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.jackson.Jacksonized;



@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Jacksonized
public class CountryDTO {
    
    private Long id;
    @NotEmpty(message = "{Object.required}")
    private String name;
}
