package com.yedam.app;

import java.util.Date;
import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class EmpVO {
	private Integer employeeId;
	final private String firstName;
	final private String lastName;
	private String email;
	private String phoneNumber;
	private Date hireDate;
	private Integer salary;
	private String jobId;
	private Integer commissionPct;
	private String departmentId;
	private String managerId;
	private String phone;
	private String photo;
	
	
	
	public EmpVO(String firstName, String lastName, int salary) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.salary = salary;
	}
	
	public String getFirstName() {
		return this.firstName;
	}
	
//	public void setFirstName(String firstName) {
//		this.firstName = firstName;
//	}
	
	public String getLastName() {
		return this.lastName;
	}
	
//	public void setLastName(String lastName) {
//		this.lastName = lastName;
//	}
	
	public int getSalary() {
		return this.salary;
	}

	@Override
	public boolean equals(Object obj) {
		EmpVO vo = (EmpVO) obj;
		return this.firstName.equals(vo.getFirstName()) &&
			   this.lastName.equals(vo.getLastName());
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.firstName, this.lastName);
	}
}
