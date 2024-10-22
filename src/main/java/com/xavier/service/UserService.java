package com.xavier.service;

import jakarta.validation.Valid;
import com.xavier.dto.UserDTO;

import java.util.List;

public interface UserService {
    
    UserDTO create(@Valid UserDTO userDTO);

    UserDTO findByEmail(String email);

    List<UserDTO> findAll();

    UserDTO findById(Long id);

    UserDTO update(Long id, @Valid UserDTO userDTO);

    void delete(Long id);
}
