package com.yedam.app.상속;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.yedam.app.EmpVO;

public class 인터페이스활용 {
	public static void main(String[] args) {
		
		List<EmpVO> list = new ArrayList<>();
		list.add(new EmpVO("kim", "ccc", 20000));
		list.add(new EmpVO("choi", "aaa", 14000));
		list.add(new EmpVO("park", "bbb", 10000));
		
		// sort(람다식)
		Collections.sort(list, (EmpVO o1, EmpVO o2) -> o1.getFirstName().compareTo(o2.getFirstName()) );
		for(EmpVO vo: list) {
			System.out.println(vo.getFirstName() + " : " + vo.getLastName());
		}
		
		// 급여비교
		Collections.sort(list, (EmpVO o1, EmpVO o2) -> o1.getSalary() - o2.getSalary() );
		for(EmpVO vo: list) {
			System.out.println(vo.getFirstName() + " : " + vo.getSalary());
		}

	}
}
