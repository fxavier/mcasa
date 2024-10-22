package com.xavier.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private Long id;

    @NotEmpty(message = "{Object.required}")
    private String firstName;

    @NotEmpty(message = "{Object.required}")
    private String lastName;

    @NotEmpty(message = "{Object.required}")
    @Email(message = "{Object.email.invalid}")
    private String email;

    @NotEmpty(message = "{Object.required}")
    private String password;
}
