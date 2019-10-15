package com.kh.spring.board.model.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;

import com.kh.spring.board.model.vo.Attachment;

public interface BoardDao {
	List<Map<String,String>> selectBoardList(SqlSessionTemplate sqlsession,int cPage, int numPerPage);
	int selectBoardCount(SqlSessionTemplate sqlsession);
	int insertBoard(SqlSessionTemplate session, Map<String,String> param);
	int insertAttachment(SqlSessionTemplate session, Attachment att);
}
