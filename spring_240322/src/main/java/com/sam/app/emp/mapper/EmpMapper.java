package com.sam.app.emp.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.sam.app.emp.EmpSearchVO;
import com.sam.app.emp.EmpVO;

@Mapper
public interface EmpMapper {
	List<EmpVO> getEmpList(@Param("vo") EmpVO vo, EmpSearchVO svo);
	EmpVO getEmpInfo(int employeeId);
	int insertEmp(EmpVO vo);
	int deleteEmp(int employeeId);
	List<Map<String, Object>> getStat();
}
