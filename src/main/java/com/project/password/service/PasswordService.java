package com.project.password.service;

import com.project.password.model.Password;
import com.project.password.repository.PasswordRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor

public class PasswordService {
    private PasswordRepository passwordRepository;

    public List<Password> getAllPassword(int page, int pageSize){
        Pageable pageable = PageRequest.of(page-1, pageSize);
        return passwordRepository.findAll(pageable).toList();
    }

//    public List<Password> getAllPasswordByName(int page, int pageSize){
//        Pageable pageable = PageRequest.of(page-1, pageSize);
//        return passwordRepository.findAll(Sort.sort())
//    }

    public Password insertPassword(Password newPassword){
        return passwordRepository.save(newPassword);
    }

    public Optional<Password> getById(int password) {
        return passwordRepository.findById(password);
    }

    public void deletePassword(int id){
        passwordRepository.deleteById(id);
    }

    public int getPasswordCount(){
        return passwordRepository.findAll().size();
    }


    public String Generate(int len){
        String up ="AZERTYUIOPQSDFGHJKLMWXCVBN";
        String low="azertyuiopqsdfghjklmwxcvbn";
        String num="0123456789";
        String special ="<>&#$%@!?+-=";
        String combination = up+low+special+num;
        char [] password=new char[len];
        Random r= new Random();
        for (int i = 0; i <len ; i++) {
            password[i]=combination.charAt(r.nextInt(combination.length()));
        }
        return new String(password);
    }

}
