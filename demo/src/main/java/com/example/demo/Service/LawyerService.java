package com.example.demo.Service;

import com.example.demo.JavaClasses.Lawyer;
import com.example.demo.Repo.LawyerRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LawyerService {
    private final LawyerRepo lawyerRepo;
    public LawyerService(LawyerRepo ur){
        lawyerRepo=ur;
    }

    public Lawyer createLawyer(Lawyer lawyer) {
        return lawyerRepo.save(lawyer);
    }
    public List<Lawyer> getAllLawyers() {
        return lawyerRepo.findAll();
    }

    public Lawyer getLawyerById(int id) {
        return lawyerRepo.findById(id).orElse(null);
    }

    public void deleteLawyer(int id) {
        lawyerRepo.deleteById(id);
    }
}
