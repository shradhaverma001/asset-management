package com.project.asset.controller;


import com.project.asset.service.EmployeeService;
import com.project.asset.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping("/employee")
    private List<Employee> getAllEmployee()
    {
        return employeeService.getAllEmployee();
    }

    @PostMapping("/employee")
    private void saveEmployee(@RequestBody Employee employee)
    {
        employeeService.saveOrUpdate(employee);
    }

}
