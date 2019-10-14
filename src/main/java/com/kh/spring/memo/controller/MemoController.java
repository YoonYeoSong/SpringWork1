package com.kh.spring.memo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.spring.memo.model.service.MemoService;
import com.kh.spring.memo.model.vo.Memo;



@Controller
public class MemoController {
	
	@Autowired
	MemoService memoservice;
	
	
	
	@RequestMapping("/memo/memo.do")
	public String selectMemoList(Model model) {
		
		List<Memo> list = memoservice.selectMemoList();
		model.addAttribute("list", list);
		
		return "memo/memoView";
	}

}
