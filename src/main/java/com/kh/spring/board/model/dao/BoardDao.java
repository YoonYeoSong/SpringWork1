package com.kh.spring.board.model.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;

public interface BoardDao {
	List<Map<String,String>> selectBoardList(SqlSessionTemplate sqlsession,int cPage, int numPerPage);
	int selectBoardCount(SqlSessionTemplate sqlsession);
}
