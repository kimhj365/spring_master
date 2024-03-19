package com.example.demo.board.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.board.BoardVO;
import com.example.demo.board.SearchVO;
import com.example.demo.board.mapper.BoardMapper;

@Controller
public class BoardController {
	@Autowired BoardMapper dao;
	
	// ajax 목록 조회
	@RequestMapping("/ajaxBoard")
	@ResponseBody
	public List<BoardVO> ajaxBoard(BoardVO vo, SearchVO svo) {
		return dao.getBoardList(vo, svo);
	}
	
	// 목록 조회
	@RequestMapping("/board/boardList")
	public String boardList(Model model, BoardVO vo, SearchVO svo) {
		model.addAttribute("boardList", dao.getBoardList(vo, svo));
		return "board/boardList";
	}
}
