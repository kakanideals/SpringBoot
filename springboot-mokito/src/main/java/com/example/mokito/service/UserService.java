package com.example.mokito.service;

import com.example.mokito.entities.Employee;
import com.example.mokito.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    public Employee createUser(Employee user){
        return userRepository.save(user);
    }

    public List<Employee> getAllUsers(){
        return  userRepository.findAll();
    }

    public Employee getUserById(Long Id) {
        Optional<Employee> userById = userRepository.findById(Id);
        if (userById.isPresent()){
            return userById.get();
        }

        return null;
    }


}
