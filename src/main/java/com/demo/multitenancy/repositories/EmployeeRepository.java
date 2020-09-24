package com.demo.multitenancy.repositories;

import com.demo.multitenancy.model.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
}
