package com.example.demo.emp.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.example.demo.emp.EmpVO;
import com.example.demo.emp.SearchVO;

@Mapper
public interface EmpMapper {
	List<EmpVO> getEmpList(@Param("vo") EmpVO vo, SearchVO svo);
	EmpVO getEmpInfo(int employeeId);
	int insertEmp(EmpVO vo);
	int deleteEmp(int employeeId);
	List<Map<String, Object>> getStat();
	// @Select("SELECT COUNT(*) FROM employees")	// mapper.xml 없이 바로 쿼리 가져옴ㄱ
	public long getCount(EmpVO vo, SearchVO svo);
}
