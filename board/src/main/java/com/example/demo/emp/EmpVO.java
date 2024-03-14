package com.example.demo.emp;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmpVO {
	Integer employeeId;
	String firstName;
	String lastName;
	String email;
	String phoneNumber;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	Date hireDate;
	Integer salary;
	String jobId;
	Integer commissionPct;
	String departmentId;
	String managerId;
	String phone;
	
	String photo;
}
