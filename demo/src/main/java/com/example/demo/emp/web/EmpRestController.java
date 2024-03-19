package com.example.demo.emp.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.common.Paging;
import com.example.demo.emp.EmpVO;
import com.example.demo.emp.SearchVO;
import com.example.demo.emp.service.EmpService;

@RestController
public class EmpRestController {
	
	@Autowired EmpService empService;
	
	// 리스트 페이지 이동
	@RequestMapping("/empMng")
	public ModelAndView empMng() {
		ModelAndView mv = new ModelAndView("empMng");
		return mv;
	}
	
	// 사원리스트 데이터
	@GetMapping("/ajax/empList") 
	// @ResponseBody // vo => json String 
	public Map<String, Object> empList(EmpVO vo, SearchVO svo, Paging pvo){
		svo.setStart(pvo.getFirst());
		svo.setEnd(pvo.getLast());
		Map<String, Object> map = empService.getEmpList(vo, svo);
		pvo.setTotalRecord((Long)map.get("count"));
		map.put("paging", pvo);
		
		return map;
	}
	
	// 등록 요청
	// 1. QueryString
	// 2. FormData
	@PostMapping("/ajax/emp")
	public EmpVO saveReq(@RequestBody EmpVO vo) {
		System.out.println(vo);
		empService.insertEmp(vo);
		return vo;
	}
	
	// 3. JsonString(payload)
//	@PostMapping("/ajax/emp")
//	public EmpVO saveReq(@RequestBody EmpVO vo) {
//		mapper.insertEmp(vo);
//		return vo;
//	}
	
	// 단건 조회
	@GetMapping("/ajax/emp/{empId}")
	public EmpVO infoReq(@PathVariable int empId) {
		return empService.getEmpInfo(empId);
	}
	
	// 차트 데이터(부서별 인원수)
	@GetMapping("/ajax/empStat")
	public List<Map<String, Object>> Stat(){
		return empService.getStat();
	}
	
}
