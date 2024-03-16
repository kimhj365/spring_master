package com.yedam.app.콜렉션;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.yedam.app.EmpVO;

public class 맵테스트 {
	public static void main(String[] args) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("100", "park");
		map.put("101", "kim");
		map.put("102", "choi");

		String name = (String) map.get("100");

		// 반복문
		for (String key : map.keySet()) {
			System.out.println(key + " : " + map.get(key));
		}

		// VO == Map
		List<HashMap<String, Object>> empList = new ArrayList<HashMap<String, Object>>();
		map = new HashMap<>();
		map.put("firstName", "park");
		map.put("lastName", "aaa");
		map.put("salary", 20000);
		empList.add(map);

		map = new HashMap<>();
		map.put("firstName", "choi");
		map.put("lastName", "bbb");
		map.put("salary", 10000);
		empList.add(map);

		// firstName만 출력
		for (HashMap<String, Object> empMap : empList) {
			System.out.println(empMap.get("firstName"));
		}

		// filter : 급여가 15000 이상인 사람만
		for (HashMap<String, Object> empMap : empList) {
			if ((int) (empMap.get("salary")) >= 15000) {
				System.out.println(empMap.get("firstName") + " : " + empMap.get("salary"));
			}
		}

		// stream
		List<HashMap<String, Object>> filterList = new ArrayList<HashMap<String, Object>>();
		filterList = empList.stream().filter(empMap -> (int) empMap.get("salary") >= 15000).collect(Collectors.toList());
		
		for(HashMap<String, Object> empMap : filterList) {
			System.out.println(empMap.get("firstName") + " : " + empMap.get("salary"));
		}

	}
}
