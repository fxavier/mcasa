package com.xavier.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PropertyImageDTO {
    private Long id;
    private String imageUrl;
    private boolean isCover;
}
