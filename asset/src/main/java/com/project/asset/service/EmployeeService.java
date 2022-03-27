package com.project.asset.service;
import com.project.asset.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.asset.repository.EmployeeRepository;
import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployee()
    {
        List<Employee> employee = new ArrayList<Employee>();
        employeeRepository.findAll().forEach(employee1 -> employee.add(employee1));
        return employee;
    }

    public void saveOrUpdate(Employee employee)
    {
        employeeRepository.save(employee);
    }

    public Employee getEmployeeById(int id)
    {
        return employeeRepository.findById(id).get();
    }

}
