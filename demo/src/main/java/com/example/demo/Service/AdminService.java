package com.example.demo.Service;

import com.example.demo.JavaClasses.Admin;
import com.example.demo.Repo.AdminRepo;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    private final AdminRepo adminRepo;
    AdminService(AdminRepo ar){
        adminRepo =ar;
    }

    public Admin createAdmin(Admin admin){return adminRepo.save(admin);}
    public Admin getAdminbyID(int id){return adminRepo.findById(id).orElse(null);}

}
