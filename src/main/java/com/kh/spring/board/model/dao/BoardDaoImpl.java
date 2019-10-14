package com.kh.spring.board.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDaoImpl implements BoardDao {
	
	

	@Override
	public List<Map<String,String>> selectBoardList(SqlSessionTemplate sqlsession, int cPage, int numPerPage) {
		
		RowBounds rowbounds = new RowBounds((cPage-1)*numPerPage, numPerPage);
		return sqlsession.selectList("board.selectBoardList", null, rowbounds);
	}
	
	@Override
	public int selectBoardCount(SqlSessionTemplate sqlsession) {
		// TODO Auto-generated method stub
		return sqlsession.selectOne("board.selectBoardCount");
	}

}
