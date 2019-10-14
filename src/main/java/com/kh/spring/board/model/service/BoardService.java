package com.kh.spring.board.model.service;

import java.util.List;
import java.util.Map;


public interface BoardService {
	
	List<Map<String,String>> selectBoardList(int cPage,int numPerPage);
	int selectBoardCount();

}
