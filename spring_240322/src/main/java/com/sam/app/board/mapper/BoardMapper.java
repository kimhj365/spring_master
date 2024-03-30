package com.sam.app.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.sam.app.board.BoardVO;
import com.sam.app.board.SearchVO;


@Mapper
public interface BoardMapper {
	List<BoardVO> getBoardList(@Param("vo") BoardVO vo, SearchVO svo);
	BoardVO getBoardInfo(int boardNo);
	int insertBoard(BoardVO vo);
	int updateBoard(BoardVO vo);
	int deleteBoard(int boardNo);
}
