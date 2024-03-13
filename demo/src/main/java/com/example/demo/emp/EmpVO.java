package com.example.demo.emp;

import java.util.Date;

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
//	String phoneNumber;
	Date hireDate;
	Integer salary;
	String jobId;
	Integer commissionPct;
	String departmentId;
	String managerId;
	String phone;
}
