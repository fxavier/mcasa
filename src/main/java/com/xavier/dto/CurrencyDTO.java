package com.xavier.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CurrencyDTO {
    private Long id;
    @NotEmpty(message = "{Object.required}")
    private String name;
    @NotEmpty(message = "{Object.required}")
    private String code;

}
