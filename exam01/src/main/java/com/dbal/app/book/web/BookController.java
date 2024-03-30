package com.dbal.app.book.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dbal.app.book.model.BookVO;
import com.dbal.app.book.service.BookService;

@Controller
public class BookController {
	
	@Autowired
	BookService bookService;
	
	// index
    @RequestMapping("/index")
    public String index() {
    	return "book/index";
    }
    
	// 도서 조회
    @GetMapping("/bookList")
    public String getBookList(Model model) {
    	// 목록조회
    	model.addAttribute("bookList", bookService.getBookList());
    	return "book/bookList";
    }
    
    // 도서 등록페이지 이동
    @GetMapping("/insertBook")
    public String insertBookForm(Model model) {
    	model.addAttribute("bookNo", bookService.getBookNo());
    	return "book/insertBook";
    }
	
    // 도서 등록처리
	@PostMapping("/insertBook") 
	public String insertBook(BookVO vo) {
		bookService.insertBook(vo);
		return "redirect:bookList";	// 데이터 가지고 뷰 페이지 이동
	}

    // 대여조회
    @RequestMapping(value = "/rentList", method = RequestMethod.GET)
    public String rentList(Model model) {
        model.addAttribute("rentList", bookService.getRentList());
        return "book/rentList";
    }
}
