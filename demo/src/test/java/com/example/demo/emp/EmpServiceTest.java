package com.example.demo.emp;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.emp.service.EmpService;

@SpringBootTest
public class EmpServiceTest {
	
	@Autowired EmpService empService;
	
	@Test
	public void 리스트페이지조회() {
		// Test Case 절차
		
		// 1. Given(준비. 테스트에 필요한 값 설정)
		EmpVO vo = new EmpVO();
		SearchVO svo = new SearchVO();
		svo.setStart(1);
		svo.setEnd(10);
		
		// 2. When(테스트 실행)
		Map<String, Object> map = empService.getEmpList(vo, svo);
		
		// 3. Then(결과 검증)
		// System.out.println(map.get("data"));
		assertThat(map.get("count")).isNotEqualTo(0);
	}
}
