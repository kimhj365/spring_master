package com.example.demo.emp.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.example.demo.emp.EmpVO;
import com.example.demo.emp.SearchVO;

public interface EmpService {
	// Service: 사용자 화면에서 요청이 발생하는 기능만
	
	Map<String, Object> getEmpList(@Param("vo") EmpVO vo, SearchVO svo);
	EmpVO getEmpInfo(int employeeId);
	int insertEmp(EmpVO vo);
	int deleteEmp(int employeeId);
	List<Map<String, Object>> getStat();
}
