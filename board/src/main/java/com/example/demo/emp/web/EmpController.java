package com.example.demo.emp.web;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.emp.EmpSearchVO;
import com.example.demo.emp.EmpVO;
import com.example.demo.emp.mapper.EmpMapper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller // 컨테이너 빈 등록 + 사용자 요청 처리 커맨드 핸들러 변환
public class EmpController {
	
	final EmpMapper mapper; // 의존성 주입(DI, Dependency Injection)
	// 등록페이지 이동
	@GetMapping("/emp/insert")
	public void insert() { 
	}
	
	// 등록 처리 --> employees 테이블에 photo 컬럼 추가
	@PostMapping("/insert")
	public String insert(@ModelAttribute("emp") EmpVO vo, MultipartFile photoFile) {
		// 파일 업로드
		vo.setPhoto(photoFile.getOriginalFilename());		
		mapper.insertEmp(vo);		
		return "redirect:/emp/list";
	}

	// 수정페이지 이동
	@GetMapping("/emp/update")
	public void update() { }
	
	// 목록페이지 이동
	@RequestMapping("/emp/list")
	public String empList(Model model, EmpVO vo, EmpSearchVO svo){ 
		model.addAttribute("empList", mapper.getEmpList(vo, svo));
		return "emp/list"; 
	}
	
	// 상세보기
	@GetMapping("/emp/info/{employeeId}")
	public String empInfo(Model model, @PathVariable int employeeId) {
		model.addAttribute("empInfo",mapper.getEmpInfo(employeeId));
		return "emp/info";
	}
	
	// 삭제처리
	@GetMapping("/delete/{empId}")
	public String delete(@PathVariable int empId) {
		mapper.deleteEmp(empId);
		return "redirect:/emp/list";
	}

}
