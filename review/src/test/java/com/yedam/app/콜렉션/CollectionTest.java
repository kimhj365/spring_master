package com.yedam.app.콜렉션;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.yedam.app.EmpVO;

/*
 * List, Set, Map
 * 		- List : 중복값 O , index로 접근	=> 순차적 목록
 * 		- Set  : 중복값 X , index로 접근	=> 중복값 제거
 * 		- Map  : <k, v>   , key로 접근 		=> 검색 빠름
 * */
public class CollectionTest {
	public static void main(String[] args) {
		// 중복값 제거
		List<Integer> list = Arrays.asList(3, 3, 10, 11, 14, 3);
		System.out.println(list);

		// List => Set에 넣기
		HashSet<Integer> set = new HashSet<>(list);
		System.out.println(set);

		// List<EmpVO>
		List<EmpVO> empList = new ArrayList<>();
		empList.add(new EmpVO("kim", "ccc", 20000));
		empList.add(new EmpVO("choi", "aaa", 14000));
		empList.add(new EmpVO("park", "bbb", 10000));
		empList.add(new EmpVO("kim", "ccc", 20000));

		HashSet<EmpVO> empSet = new HashSet<>(empList);
		System.err.println(empSet.size());

		// 필터링 : 급여가 15000 이상인 사원만 검색
		List<EmpVO> filterList = new ArrayList<>();
		for (EmpVO vo : empSet) {
			if (vo.getSalary() >= 15000) {
				filterList.add(vo);
			}
		}
		System.out.println(filterList.size());

		// => Stream
		filterList = empSet.stream()
					.filter(vo -> vo.getSalary() >= 15000)
					.collect(Collectors.toList());
		System.out.println(filterList.get(0).getSalary());

		filterList = empSet.stream()
					.filter(vo -> vo.getLastName().contains("b"))
					.collect(Collectors.toList());
		System.out.println(filterList.get(0).getLastName());

	}
}
