package com.demo.multitenancy.web.converter;

import com.demo.multitenancy.model.Employee;
import com.demo.multitenancy.web.model.EmployeeDto;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

//Converts between the Domain Model and the Data Transfer Object
public class Converters {

    private Converters() {
    }

    //converts from Employee to EmployeeDto
    public static EmployeeDto convert(Employee source) {
        if (source == null) {
            return null;
        }

        return new EmployeeDto(source.getId(), source.getFirst_name(), source.getLast_name(), source.getEmail());
    }

    //convert from EmployeeDto to Employee
    public static Employee convert(EmployeeDto source) {
        if (source == null) {
            return null;
        }
        return new Employee(source.getId(), source.getFirstName(), source.getLastName(), source.getEmail());
    }

    //convert from Employee iterable to EmployeeDto list
    public static List<EmployeeDto> convert(Iterable<Employee> employees) {
        return StreamSupport.stream(employees.spliterator(), false)
                .map(Converters::convert)
                .collect(Collectors.toList());
    }
}
