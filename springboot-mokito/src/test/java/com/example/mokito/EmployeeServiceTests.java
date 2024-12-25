package com.example.mokito;

import com.example.mokito.entities.Employee;
import com.example.mokito.repo.UserRepository;
import com.example.mokito.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;



@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTests {


    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;


    @Test
    public void verifyGetAllEmployees() {
        Mockito.when(userRepository.findAll())
                .thenReturn(Stream.of(new Employee(1, "Test"), new Employee(2, "afddf"))
                        .collect(Collectors.toList()));
        Assertions.assertEquals(2, userService.getAllUsers().size());
    }

    @Test
    public void verifySaveEmployee(){
        Employee employee = new Employee(3, "Babu");
        Mockito.when(userRepository.save(employee))
                .thenReturn(employee);
       Assertions.assertEquals(employee ,userService.createUser(employee));
    }

    @Test
    public void verifyEmployeeById(){
        Employee employee = new Employee(3, "Babu");
        Mockito.when(userRepository.findById(3L))
                .thenReturn(Optional.of(employee));
        Assertions.assertEquals(employee,userService.getUserById(3L));
    }
}

