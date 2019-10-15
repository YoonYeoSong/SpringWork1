package com.kh.spring.board.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.spring.board.model.vo.Attachment;

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
	
	@Override
	public int insertAttachment(SqlSessionTemplate session, Attachment att) {
		// TODO Auto-generated method stub
		return session.insert("board.insertAttachment", att);
	}
	@Override
	public int insertBoard(SqlSessionTemplate session, Map<String, String> param) {
		// TODO Auto-generated method stub
		return session.insert("board.insertBoard", param);
	}

}
