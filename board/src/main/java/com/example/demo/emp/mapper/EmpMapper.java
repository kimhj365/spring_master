package com.example.demo.emp.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.emp.EmpVO;
import com.example.demo.emp.EmpSearchVO;

@Mapper
public interface EmpMapper {
	List<EmpVO> getEmpList(@Param("vo") EmpVO vo, EmpSearchVO svo);
	EmpVO getEmpInfo(int employeeId);
	int insertEmp(EmpVO vo);
	int deleteEmp(int employeeId);
	List<Map<String, Object>> getStat();
}
