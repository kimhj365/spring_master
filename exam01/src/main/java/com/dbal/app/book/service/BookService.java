package com.dbal.app.book.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.dbal.app.book.model.BookVO;

@Service
public interface BookService {
	
	// 도서조회
	public List<BookVO> getBookList();
	
	// 도서 번호 조회
	public int getBookNo();
	
	// 대여조회
	public List<Map<String, Object>> getRentList();
	
	// 도서등록
	// mapper와 데이터 타입 다를 수 있음
	public boolean insertBook(BookVO vo);
}
