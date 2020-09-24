package com.demo.multitenancy.web.controllers;

import com.demo.multitenancy.model.Employee;
import com.demo.multitenancy.repositories.EmployeeRepository;
import com.demo.multitenancy.web.converter.Converters;
import com.demo.multitenancy.web.model.EmployeeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    private EmployeeRepository repository;

    @Autowired
    public EmployeeController(EmployeeRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/employees")
    public List<EmployeeDto> getAll() {
        Iterable<Employee> employees = repository.findAll();

        return Converters.convert(employees);
    }

    @GetMapping("/employees/{id}")
    public EmployeeDto get(@PathVariable("id") long id) {
        Employee employee = repository.findById(id).orElse(null);

        return Converters.convert(employee);
    }

    @PostMapping("/employees")
    public EmployeeDto post(@RequestBody EmployeeDto employee) {

        Employee source = Converters.convert(employee);

        Employee result = repository.save(source);

        return Converters.convert(result);
    }

    @DeleteMapping("/employees/{id}")
    public void delete(@PathVariable("id") Long id) {
        repository.deleteById(id);
    }

    @PutMapping("/employees/{id}")
    public EmployeeDto put(@PathVariable("id") Long id, @RequestBody EmployeeDto employee) {
        Employee source = repository.findById(id).orElse(null);
        Employee convertedEmployee = Converters.convert(employee);

        if (source != null) {
            convertedEmployee.setId(source.getId());
            Employee result = repository.save(convertedEmployee);
            return Converters.convert(result);
        } else {
            return null;
        }
    }
}
