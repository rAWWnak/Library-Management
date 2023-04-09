package com.xfactor.openlibrary.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xfactor.openlibrary.domain.Admin;
import com.xfactor.openlibrary.repositories.AdminRepository;

import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("admins")
public class AdminController{
    private AdminRepository adminRepository;
    public AdminController(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @PostMapping("/saveAdmins")
    public Admin saveAdmin(@RequestBody Admin Admin){
        if(Admin.getId()==null){
            Admin admin2 = adminRepository.save(Admin);
            return admin2;
        }
        return null;
    }

    @PutMapping("/updateAdmin")
    public Admin updateAdmin(@RequestBody Admin admin) {
        if (admin.getId() != null) {
            Admin admin2 = adminRepository.save(admin);
            return admin2;
        }
        return null;
    }

    @GetMapping("/getAllAdmins")
    public List<Admin> getAllAdmins(){
        return adminRepository.findAll();
    }

    @GetMapping("/findTotalAdmins")
    public Long findTotalAdmins(){
        return adminRepository.count();
    }
    
    @GetMapping("findByAdminId/{id}")
    public Admin findById(@PathVariable Long id) {
        Optional<Admin> optionalOfAdmin = adminRepository.findById(id);
        if (optionalOfAdmin.isPresent()) {
            return optionalOfAdmin.get();
        }
        return null;
    }

    @DeleteMapping("deleteAdmins/{id}")
    public void deleteAdmins(@PathVariable Long id){
        adminRepository.deleteById(id);
    }

    @GetMapping("findByname/{name}")
    public List<Admin> findByname(@PathVariable String name) {
        List<Admin> admins = adminRepository.findByName(name);
        return admins;
    }
}

