package com.dbal.app.book.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.dbal.app.book.model.BookVO;

@Mapper
public interface BookMapper {

	// 도서조회
	public List<BookVO> getBookList();
	
	// 도서 번호 조회
	public int getBookNo();
	
	// 대여조회
	public List<Map<String, Object>> getRentList();
	
	// 도서등록
	public int insertBook(BookVO vo);
}
