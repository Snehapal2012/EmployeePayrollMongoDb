package com.example.employeepayrollwithmongodb.repository;

import com.example.employeepayrollwithmongodb.model.Payroll;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PayrollRepo extends MongoRepository<Payroll,String> {
    List<Payroll> findByDepartment(String department);
}
