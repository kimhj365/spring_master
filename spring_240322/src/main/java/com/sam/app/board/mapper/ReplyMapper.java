package com.sam.app.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.sam.app.board.ReplyVO;
import com.sam.app.board.SearchVO;

@Mapper
public interface ReplyMapper {
	List<ReplyVO> getReplyList(Long bno, SearchVO svo);
	int insertReply(ReplyVO vo);
}
