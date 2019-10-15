package com.kh.spring.board.model.service;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.spring.board.model.dao.BoardDao;
import com.kh.spring.board.model.vo.Attachment;


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
	
	@Override
	  public int insertBoard(Map<String, String> param, List<Attachment> attachList) {
	    //세션 트랜젝션 관리(by spring)
	    int result = 0;
	    int boardNo = 0;
	    result = dao.insertBoard(sqlsession, param); //board테이블에 데이터 입력!

	    if(attachList.size() > 0) {
	      for(Attachment a : attachList) {
	        a.setBoardNo(Integer.parseInt(param.get("boardNo")));
	        result = dao.insertAttachment(sqlsession, a);
	      }
	    }
	    
	    return result;
	  }

}
