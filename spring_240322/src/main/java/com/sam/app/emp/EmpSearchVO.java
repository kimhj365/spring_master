package com.sam.app.emp;

import lombok.Data;

@Data
public class EmpSearchVO {
	
	int start = 1;
	int end = 10;
	
	int[] employeeIds;
}
