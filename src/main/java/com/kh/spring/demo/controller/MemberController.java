package com.kh.spring.demo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.spring.model.service.MemberService;
import com.kh.spring.model.vo.Member;

@Controller
public class MemberController {
	
	@Autowired
	MemberService memberService;
	
	@RequestMapping("/member/memberLogin.do")
	public String memberLogin(Member m, HttpServletRequest request)
	{
//		String userId = request.getParameter("userId");
//		String password = request.getParameter("password");
//		
//		Member m = new Member();
		
		HttpSession session = request.getSession();
		
		
		Member loginMember = memberService.selectMemberOne(m);
		
		if(loginMember != null)
		{
			System.out.println("디비데이터(아이디) : " + loginMember.getUserId());
			System.out.println("디비데이터(비밀번호) : "+ loginMember.getPassword());
			System.out.println("직접입력값(아이디) : " + m.getUserId());
			System.out.println("직접입력값(비밀번호) : " + m.getPassword());
			if(m.getUserId().equals(loginMember.getUserId()) && m.getPassword().equals(loginMember.getPassword()))
			{
				//request.setAttribute("loginMember", loginMember);				
				session.setAttribute("loginMember", loginMember);
			}
		}

		return "redirect:/";
	}

}
