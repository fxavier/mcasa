package com.xavier.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.mindrot.jbcrypt.BCrypt;

import com.xavier.dto.UserDTO;
import com.xavier.entity.User;
import com.xavier.exceptions.ServiceException;
import com.xavier.repository.UserRepository;
import com.xavier.service.UserService;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@ApplicationScoped
public class UserServiceImpl implements UserService {

    @Inject
    private UserRepository userRepository;

    @Override
    @Transactional
    public UserDTO create(@Valid UserDTO userDTO) {
        if (isEmailAlreadyInUse(userDTO.getEmail())) {
            throw new ServiceException("Email already in use");
        }

         // Encrypt the password using BCrypt
        String hashedPassword = BCrypt.hashpw(userDTO.getPassword(), BCrypt.gensalt());
        userDTO.setPassword(hashedPassword);

        User user = toEntity(userDTO);
        userRepository.persist(user);
        return toDTO(user);
    }

    @Override
    public UserDTO findByEmail(String email) {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new ServiceException("User not found");
        }
        return toDTO(user);
    }

    @Override
    public List<UserDTO> findAll() {
       return userRepository
              .findAll()
              .stream()
              .map(this::toDTO)
              .toList();
    }

    @Override
    public UserDTO findById(Long id) {
        return userRepository
              .findByIdOptional(id)
              .map(this::toDTO)
              .orElseThrow(() -> new ServiceException("User not found"));
    }

    @Override
    @Transactional
    public UserDTO update(Long id, @Valid UserDTO userDTO) {
        User user = userRepository.findById(id);
        if (user == null) {
            throw new ServiceException("User not found");
        }
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setEmail(userDTO.getEmail());
        userRepository.persist(user);
        return toDTO(user);
    }

    @Override
    @Transactional
    public void delete(Long id) {
       User user = userRepository.findById(id);
       if (user == null) {
        throw new ServiceException("User not found");
       }
       userRepository.delete(user);
    }

    private UserDTO toDTO(User user) {
        UserDTO userDTO = new UserDTO();
        try {
            BeanUtils.copyProperties(userDTO, user);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new ServiceException("Error copying properties", e);
        }
        return userDTO;
    }

    private User toEntity(UserDTO userDTO) {
        User user = new User();
        try {
            BeanUtils.copyProperties(user, userDTO);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new ServiceException("Error copying properties", e);
        }
        return user;
    }

    private boolean isEmailAlreadyInUse(String email) {
        return userRepository.findByEmail(email) != null;
    }
}
