package com.kh.spring.board.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.spring.board.model.service.BoardService;
import com.kh.spring.board.model.vo.Board;

@Controller
public class BoardController {
	
	@Autowired
	BoardService boardservice;

	
	@RequestMapping("/board/boardList.do")
	public String selectBoardList(@RequestParam(value="cPage", required=false, defaultValue="0") int cPage)
	{
		int numPerPage = 5;
		List<Map<String,String>> list = boardservice.selectBoardList(cPage,numPerPage);
		int totalCount = boardservice.selectBoardCount();
		
		return "";
	}
}
