package com.dbal.app.book.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BookVO {
	private int bookNo;
	private String bookName;
	private String bookCoverimg;
//	@DateTimeFormat(pattern = "yyyy/mm/dd")
	private Date bookDate;
	private int bookPrice;
	private String bookPublisher;
	private String bookInfo;
}
