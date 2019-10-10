package com.kh.spring.demo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.kh.spring.model.service.MemberService;
import com.kh.spring.model.vo.Member;

//@SessionAttributes("loginMember")
@Controller
public class MemberController {
	
	Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	MemberService memberService;
	@Autowired
	BCryptPasswordEncoder pwEncoder;
	
	@RequestMapping("/member/memberLogin.do")
	public String memberLogin(Member m, Model model, HttpSession session, SessionStatus sessionStatus) // HttpSession session,
	{
//		String userId = request.getParameter("userId");
//		String password = request.getParameter("password");
//		
//		Member m = new Member();
		
		//HttpSession session = request.getSession();
		
		
		Member loginMember = memberService.selectMemberOne(m);
		String msg="";
		String loc="/";
		
		if(loginMember != null)
		{
			logger.debug("유저Id(DB) : " + loginMember.getUserId());
			logger.debug("유저PW(DB) : "+ loginMember.getPassword());
			logger.debug("유저ID : " + m.getUserId());
			logger.debug("유저PW : " + m.getPassword());
			//if(m.getUserId().equals(loginMember.getUserId()) && m.getPassword().equals(loginMember.getPassword()))
			if(pwEncoder.matches(m.getPassword(), loginMember.getPassword()))
			{
				//request.setAttribute("loginMember", loginMember);		
				msg="성공";
				session.setAttribute("loginMember", loginMember);
				//model.addAttribute("loginMember", loginMember);
				logger.debug("로그인성공");
			}else
			{
				msg="실패";
				logger.debug("로그인실패");
			}
		}
		
		model.addAttribute("msg", msg);
		model.addAttribute("loc", loc);
		

		return "common/msg";
	}
	
	// 로그아웃
	@RequestMapping("/member/memberLogout.do")
	public String memberLogout(HttpServletRequest request, HttpServletResponse response, SessionStatus sessionStatus)
	{
//		if(!sessionStatus.isComplete())
//		{
//			sessionStatus.setComplete();		
//		}
		HttpSession session = request.getSession();		
		session.invalidate();
		return "redirect:/";
	}
	
	@RequestMapping("/member/memberEnroll.do")
	public String enroll()
	{
		//화면전환용 메소드
		return "member/memberEnroll";
	}
	
	@RequestMapping("/member/memberEnrollEnd.do")
	public String enrollEnd(Model model, Member m)
	{
		String msg ="";
		String loc= "/";
		m.setPassword(pwEncoder.encode(m.getPassword()));
		
		int result = memberService.memberEnrollEnd(m);
		
		if(result > 0)
		{
			msg="가입성공";
			logger.debug("가입성공");
		}else
		{
			msg="가입실패";
			logger.debug("가입실패");
		}
		
		model.addAttribute("msg", msg);
		model.addAttribute("loc", loc);
			
		
		System.out.println(m);
		
		return "common/msg";
	}
	
	

}
