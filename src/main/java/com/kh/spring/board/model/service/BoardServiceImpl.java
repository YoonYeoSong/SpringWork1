package com.kh.spring.board.model.service;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.spring.board.model.dao.BoardDao;


@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	BoardDao dao;
	
	@Autowired
	SqlSessionTemplate sqlsession;
	
	@Override
	public List<Map<String, String>> selectBoardList(int cPage, int numPerPage) {
		// TODO Auto-generated method stub
		return dao.selectBoardList(sqlsession,cPage,numPerPage);
	}
	
	@Override
	public int selectBoardCount() {
		// TODO Auto-generated method stub
		return dao.selectBoardCount(sqlsession);
	}

}
