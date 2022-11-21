package com.project.password.controller;

import com.project.password.model.Password;
import com.project.password.service.PasswordService;
import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PasswordController {
    private PasswordService passwordService;

    @GetMapping("/password")
    public List<Password> getAllPassword(
            @RequestParam(name = "page")int page,
            @RequestParam(name = "page_size")int pageSize
    ){
        return passwordService.getAllPassword(page, pageSize);
    }

    @GetMapping("/password/{id_password}")
    public Optional<Password> getPasswordByID(@PathVariable("passwordId") int passwordId) {
        return passwordService.getById(passwordId);
    }


    @PutMapping("/password")
    public Password createOrUpdatePassword(@RequestBody Password password) {
        return passwordService.insertPassword(password);
    }

    @DeleteMapping("/password/{id_password}")
    public void deletePassword(@PathVariable(name = "id_password")int idPassword){
         passwordService.deletePassword(idPassword);
    }
}
