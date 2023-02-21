package com.example.employeepayrollwithmongodb.service;

import com.example.employeepayrollwithmongodb.dto.EmployeeDTO;
import com.example.employeepayrollwithmongodb.model.Payroll;
import com.example.employeepayrollwithmongodb.repository.PayrollRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService implements IEmployeeService{
    @Autowired
    PayrollRepo repo;
    @Override
    public Optional<Payroll> findById(String id){
        Optional<Payroll> payroll=repo.findById(id);
        if(payroll.isPresent()){
            return payroll;
        }else return null;
    }
    @Override
    public List<Payroll> findEmployeesByDepartment(String department){
        List<Payroll> payrolls=repo.findByDepartment(department);
        return payrolls;
    }
    @Override
    public Payroll upload(EmployeeDTO model){
        Payroll payroll=new Payroll(model);
        repo.save(payroll);
        return payroll;
    }
    @Override
    public List<Payroll> getAll(){
        List<Payroll> list=repo.findAll();
        return list;
    }
    @Override
    public Payroll edit(EmployeeDTO entity, String id){
        Payroll payroll=repo.findById(id).get();
        if (repo.findById(id).isPresent()){
            payroll=new Payroll(entity);
            repo.save(payroll);
            return payroll;
        }
        return null;
    }
    @Override
    public void delete(String id){
        repo.deleteById(id);
    }
}
