package com.example.employeepayrollwithmongodb.service;

import com.example.employeepayrollwithmongodb.dto.EmployeeDTO;
import com.example.employeepayrollwithmongodb.model.Payroll;

import java.util.List;
import java.util.Optional;

public interface IEmployeeService {
    Optional<Payroll> findById(String id);

    List<Payroll> findEmployeesByDepartment(String department);

    Payroll upload(EmployeeDTO model);

    List<Payroll> getAll();

    Payroll edit(EmployeeDTO entity, String id);

    void delete(String id);
}
