package com.example.employeepayrollwithmongodb.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class EmployeeDTO {
    private String name;
    private String profilePic;
    private String gender;
    private String salary;
    private String notes;
    private String startDate;
    private List<String> department;
}
