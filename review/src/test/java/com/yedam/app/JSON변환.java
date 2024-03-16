package com.yedam.app;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JSON변환 {
	public static void main(String[] args) throws MalformedURLException, IOException {
	
		ObjectMapper objectMapper = new ObjectMapper();
		
		// object => JSON
		EmpVO vo = new EmpVO("길동", "홍");
		
		String str = objectMapper.writeValueAsString(vo);
		
		// JSON => object String
		String json = "{\"employeeId\":null,\"firstName\":\"길동\",\"lastName\":\"홍\",\"email\":null,\"phoneNumber\":null,\"hireDate\":null,\"salary\":null,\"jobId\":null,\"commissionPct\":null,\"departmentId\":null,\"managerId\":null,\"phone\":null,\"photo\":null}";
		vo = objectMapper.readValue(json, EmpVO.class);
		
		// url =>, object
		Map map = objectMapper.readValue(new URL("https://jsonplaceholder.typicode.com/todos/1"), Map.class);
		System.out.println(map.get("title"));
		
		
		
	}
}
