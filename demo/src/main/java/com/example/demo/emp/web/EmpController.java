package com.example.demo.emp.web;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.common.Paging;
import com.example.demo.emp.EmpVO;
import com.example.demo.emp.SearchVO;
import com.example.demo.emp.service.EmpService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller // 컨테이너 빈 등록 + 사용자 요청 처리 커맨드 핸들러 변환
public class EmpController {
	
	final EmpService empService; // 의존성 주입(DI, Dependency Injection)
	
	
//	@RequestMapping("/ajaxEmp")
//	@ResponseBody	 // 데이터만 넘겨줌(상태: OK)
//	public List<EmpVO>ajaxEmp() {
//		return empService.getEmpList(null, null);
//	}
//	
//	@RequestMapping("/empResult")
//	public String result() {
//		return "result";
//	}
	
	// 목록조회
	@RequestMapping("/empList")
	public String empList(Model model, EmpVO vo, SearchVO svo, Paging pvo) {
		
		// 페이징 처리
		pvo.setPageUnit(5);	// 데이터 수
		pvo.setPageSize(3);	// 페이지 번호 수
		svo.setStart(pvo.getFirst());
		svo.setEnd(pvo.getLast());
		
		Map<String, Object> map = empService.getEmpList(vo, svo);
		
		pvo.setTotalRecord((Long)map.get("count"));
		model.addAttribute("paging", pvo);
		
		// 목록 조회
		model.addAttribute("empList", map.get("data"));
		return "empList";
	}
	
	// 등록
	@GetMapping("/insert")
	public void insert() {}
	
	@PostMapping("/insert")
	public ModelAndView insert(@ModelAttribute("emp") EmpVO vo) {
		System.out.println(vo);
		empService.insertEmp(vo);
		
		// 커맨드 객체는 자동으로 model에 추가되고 view 페이지로 전달됨
		// 모델이름 = 클래스 첫글자 소문자 / @ModelAttribute로 이름 바꾸기
		// model.addAttribute("emp", "vo");
		// model.addAttribute("insertResult", "success");
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/home");	// view(html) 이름
		mv.addObject("insertResult", "success");
//		mv.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
		return mv;
	}	
	
	@PostMapping("/insert2")	// 데이터 + 상태 넘겨줌
	public ResponseEntity<EmpVO> insert2(EmpVO vo) {
		return new ResponseEntity<>(vo,HttpStatus.OK);
	}

	@PostMapping("/insert3")	// 데이터 + 상태 넘겨줌
	public String insert3(EmpVO vo, RedirectAttributes rttr) {
		System.out.println("등록 : " + vo);
		rttr.addAttribute("insertResult", "성공");
		rttr.addFlashAttribute("flashResult", "한번만 사용가능");
		return "redirect:empResult";
	}
	
	// 단건조회
	@GetMapping("/info/{empId}")
	public String info(@PathVariable int empId, Model model) {
		model.addAttribute("emp", empService.getEmpInfo(empId));
		return "empInfo";
	}
	
	// 수정
	@GetMapping("/update/{empId}")
	public String update(@PathVariable int empId) {
		return "index";
	}
	
	// 삭제
	@GetMapping("/delete")
	public String delete(int employeeId, String name) {
		empService.deleteEmp(employeeId);
		return "redirect:empList";
	}

	@GetMapping("/")
	public String test() {
		return "index";
	}

}
