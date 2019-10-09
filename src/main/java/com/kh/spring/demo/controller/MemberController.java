package com.kh.spring.demo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
			System.out.println("�������(���̵�) : " + loginMember.getUserId());
			System.out.println("�������(��й�ȣ) : "+ loginMember.getPassword());
			System.out.println("�����Է°�(���̵�) : " + m.getUserId());
			System.out.println("�����Է°�(��й�ȣ) : " + m.getPassword());
			if(m.getUserId().equals(loginMember.getUserId()) && m.getPassword().equals(loginMember.getPassword()))
			{
				//request.setAttribute("loginMember", loginMember);				
				session.setAttribute("loginMember", loginMember);
				System.out.println("로그인성공");
			}else
			{
				System.out.println("로그인실패");
			}
		}
		

		return "redirect:/";
	}
	
	@RequestMapping("/member/memberLogout.do")
	public String memberLogout(HttpServletRequest request, HttpServletResponse response)
	{
		HttpSession session = request.getSession();
		
		session.invalidate();
		return "redirect:/";
	}
	
	

}
