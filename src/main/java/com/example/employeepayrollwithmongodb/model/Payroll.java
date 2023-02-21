package com.example.employeepayrollwithmongodb.model;

import com.example.employeepayrollwithmongodb.dto.EmployeeDTO;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
@Data
@NoArgsConstructor
public class Payroll {
    @Id
    private String id;
    private String name;
    private String profilePic;
    private String gender;
    private String salary;
    private String notes;
    private String startDate;
    private List<String> department;

    public Payroll(EmployeeDTO employeeDTO){
        this.name= employeeDTO.getName();
        this.profilePic=employeeDTO.getProfilePic();
        this.gender=employeeDTO.getGender();
        this.salary=employeeDTO.getSalary();
        this.notes=employeeDTO.getNotes();
        this.startDate=employeeDTO.getStartDate();
        this.department=employeeDTO.getDepartment();
    }
}
