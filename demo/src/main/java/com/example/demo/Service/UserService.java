package com.example.demo.Service;

import com.example.demo.JavaClasses.User;
import com.example.demo.Repo.UserRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    LawyerService lawyerService;
    private final UserRepo userRepo;

    public UserService(UserRepo ur) {
        userRepo = ur;
    }

    public User createUser(User user) {
        return userRepo.save(user);
    }

    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    public User getUserById(int id) {
        return userRepo.findById(id).orElse(null);
    }

    public void deleteuser(int id) {
        userRepo.deleteById(id);
    }

    public User updateUser(int userID, int lawyerID) {
        Optional<User> optionalUser = userRepo.findById(userID);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
                            //System.out.println("sent lawyerID to user repo:"+lawyerID);
                            //System.out.println("From User Repo: (lawyerID) "+user.getLawyer().getLawyerID());
                            // Step 4: Update the specific property
            user.setLawyer(lawyerService.getLawyerById(lawyerID));
                            //System.out.println("(post update)From User Repo: (lawyerID) "+user.getLawyer().getLawyerID());
                            // Step 5: Save the updated entity back to the repository
            return userRepo.save(user);
        } else {
            throw new EntityNotFoundException("Product not found with ID: " + userID);
        }
    }
}
