package com.example.demo.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.board.ReplyVO;
import com.example.demo.board.SearchVO;

@Mapper
public interface ReplyMapper {
	List<ReplyVO> getReplyList(Long bno, SearchVO svo);
	int insertReply(ReplyVO vo);
}
