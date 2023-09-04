package com.example.demo.Repo;

import com.example.demo.JavaClasses.Lawyer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LawyerRepo extends JpaRepository<Lawyer,Integer> {
}
