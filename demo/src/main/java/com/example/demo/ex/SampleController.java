package com.example.demo.ex;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {
	
	@GetMapping(value = "/getText", produces = "application/json;charset=utf-8")
	public String getText() {
		return "{\"greet\" : \"안녕하세요\"}";
	}
	
	@GetMapping("/check")
	public ResponseEntity<SampleVO> check(Double height, Double weight){
		SampleVO vo = new SampleVO(0, "" + height, "" + weight);
		
		if(height > 150) {
			return new ResponseEntity<>(vo, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(vo, HttpStatus.BAD_GATEWAY);
		}
	}
}
