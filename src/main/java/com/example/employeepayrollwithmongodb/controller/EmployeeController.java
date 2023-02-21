package com.example.employeepayrollwithmongodb.controller;

import com.example.employeepayrollwithmongodb.dto.EmployeeDTO;
import com.example.employeepayrollwithmongodb.model.Payroll;
import com.example.employeepayrollwithmongodb.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {
    @Autowired
    IEmployeeService service;
    @GetMapping("/")
    public String greetings() {
        return "Hiiiiiii !!! Everyone!!!";
    }

    @GetMapping("/findEmployee/{id}")
    public Optional<Payroll> findId(@PathVariable String id){
        Optional<Payroll> response=service.findById(id);
        return response;
    }
    @GetMapping("/getDepartment/{department}")
    public List<Payroll> getDepartment(@PathVariable String department){
        List<Payroll> list=service.findEmployeesByDepartment(department);
        return list;
    }
    //to upload or add any new employee details
    @PostMapping("/upload")
    public Payroll uploadData( @RequestBody EmployeeDTO model){
        Payroll payrollModel=service.upload(model);
        return payrollModel;
    }
    //to get all employee details
    @GetMapping("/allDetails")
    public List<Payroll> getAll(){
        List<Payroll> modelList=service.getAll();
        return modelList;
    }
    //to get any employee details using put method
    @PutMapping("/put/{id}")
    public String put( @PathVariable String id,@RequestParam(value = "name") String name,
                       @RequestParam(value = "profilePic") String profilePic, @RequestParam(value = "gender") String gender, @RequestParam(value = "department") String department,  @RequestParam(value = "notes") String notes) {
        return "<h1><font color=brown style=bold>Details:-- " +"Name: "+name +" Profile Pic: " + profilePic + "  Gender: "+gender+"  Department: "+department+"  Notes: </font></h1>"+notes;
    }
    //edit any employee details by id
    @PutMapping("/editEmployee/{id}")
    public Payroll edit( @RequestBody EmployeeDTO entity,@PathVariable String id) {
        return service.edit(entity,id);

    }
    //delete any employee details by id
    @DeleteMapping("/deleteEmployee/{id}")
    public void delete(@PathVariable String id) {
        service.delete(id);

    }

    @GetMapping("/al")
    public String getAl(){

        return "Hiiiii! All";
    }


}
