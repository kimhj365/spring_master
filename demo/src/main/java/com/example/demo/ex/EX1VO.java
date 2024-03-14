package com.example.demo.ex;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EX1VO {
	private String username;
	private String password;
	private List<String> hobby;
}
