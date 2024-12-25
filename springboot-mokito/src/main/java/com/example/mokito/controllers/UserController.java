package com.example.mokito.controllers;

import com.example.mokito.entities.Employee;
import com.example.mokito.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;

@RestController
@RequestMapping("/api/v1/employees")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/save")
    public Employee saveUser(@RequestBody Employee user){
        return userService.createUser(user);
    }

    @GetMapping("/all")
    public List<Employee> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public Employee getUserById(@PathVariable  Long id){
       return userService.getUserById(id);
    }
}
