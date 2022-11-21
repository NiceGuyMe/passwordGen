package com.project.password.service;

import com.project.password.model.Password;
import com.project.password.repository.PasswordRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor

public class PasswordService {
    private PasswordRepository passwordRepository;

    public List<Password> getAllPassword(int page, int pageSize){
        Pageable pageable = PageRequest.of(page-1, pageSize);
        return passwordRepository.findAll(pageable).toList();
    }

    public Password insertPassword(Password newPassword){
        return passwordRepository.save(newPassword);
    }

    public Optional<Password> getById(int password) {
        return passwordRepository.findById(password);
    }

    public String deletePassword(int id){
        passwordRepository.deleteById(id);
        return "password is delete successfully";
    }
}
