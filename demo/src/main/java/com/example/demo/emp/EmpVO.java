package com.example.demo.emp;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

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
	@DateTimeFormat(pattern = "yyyy-MM-dd")	// 입력 String => Date
	@JsonFormat(pattern = "yyyy-MM-dd")		// 출력 Date => String
	Date hireDate;
	Integer salary;
	String jobId;
	Integer commissionPct;
	@JsonProperty(value = "deptId")String departmentId;
	@JsonIgnore String managerId;
	@JsonIgnore String phone;
}
