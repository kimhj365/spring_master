package com.sam.app.board.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.sam.app.board.ReplyVO;
import com.sam.app.board.SearchVO;
import com.sam.app.board.mapper.ReplyMapper;
import com.sam.app.common.Paging;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@RestController
public class ReplyController {
	@Autowired ReplyMapper dao;
	
	// 리스트 페이지 이동
	@RequestMapping("/board/replyMng")
	public ModelAndView replyMng() {
		ModelAndView mv = new ModelAndView("replyMng");
		return mv;
	}
	
	// 댓글 목록 조회
	@GetMapping("/ajax/replyList/{bno}")
	public List<ReplyVO> replyList(Long bno, SearchVO svo, Paging pvo){
		
		svo.setStart(pvo.getFirst());
		svo.setEnd(pvo.getLast());
		return dao.getReplyList(bno, svo);
	}
}
