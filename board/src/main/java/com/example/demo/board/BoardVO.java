package com.example.demo.board;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BoardVO {
	Integer board_no;
	String title;
	String content;
	String writer;
	Date write_date;
	Integer click_cnt;
	String image;
}
