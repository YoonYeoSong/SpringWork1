package com.kh.spring.demo.controller;


import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.spring.model.service.DevService;
import com.kh.spring.model.vo.Dev;
import com.kh.spring.model.vo.Member;

import lombok.Data;

@Controller
public class DemoController {
	
	@Autowired
	DevService devService;
	

	@RequestMapping("/demo/demo.do")
	public String demo()
	{
		System.out.println("/demo/demo.do 컨트롤러 호출");
		return "demo/demo";
	}


	@RequestMapping("/demo/demo1.do")
	public String demo1(HttpServletRequest req, HttpServletResponse res)
	{
		//컨트롤러 메소드가 받을 수 있는 Parameter
		// HttpServletRequest
		// HttpServletResponse
		// HttpSession
		// java.util.Locale
		// InputStream, Reader : 요청에 대한 스트림
		// OutputStream, Writer : 요청에 대한 출력 스트림
		// @PathVariable
		// @RequestParam
		// @RequestHeader
		// @CookieValue
		// @RequestBody : Ajax 전송시 json객체를 받는 파라미터 타입
		// Map, Model, ModelMap : 보낼 데이터를 보관하는 전용 객체
		// Command객체 : Vo파라미터로 넘어오는 값을 자동으로 Vo대입!
		String devName = req.getParameter("devName");
		int devAge = Integer.parseInt(req.getParameter("devAge"));
		String devEmail = req.getParameter("devEmail");
		String devGender = req.getParameter("devGender");
		String[] devLangs = req.getParameterValues("devLang");

		System.out.println(devName + devAge + devEmail + devGender);

		for(String s : devLangs)
			System.out.println(s); //demoResult.jsp 안만들어서 404뜨면서 syso console에 찍힘

		Dev dev = new Dev(devName, devAge, devEmail, devGender, devLangs);
		req.setAttribute("dev", dev);

		return "demo/demoResult";

	}


//	//@RequestParam(value="inputName명") //매개변수 지정->매개변수 위치
//	@RequestMapping("/demo/demo2.do")
//	public String demo2(
//				@RequestParam(value="devName") String devName, // 매개변수 안에 파람의 벨류값을 자료형으로 받아 정의
//				@RequestParam(value="devAge", required = false, defaultValue = "28") int devAge,      //매개변수
//				@RequestParam(value="devEmail") String devEmail, 
//				@RequestParam(value="devGender") String devGender, 
//				@RequestParam(value="devLang") String[] devLang,
//				HttpServletRequest request
//			) 
//	{
//		System.out.println(devName);
//		System.out.println(devAge);
//		System.out.println(devEmail);
//		System.out.println(devGender);
//		System.out.println(devLang);
//		
//		Dev dev = new Dev(devName, devAge, devEmail, devGender, devLang);
//		request.setAttribute("dev", dev);
//		return "demo/demoResult";
//	}
	
//	@RequestMapping("/demo/demo2.do")
//	public String demo2(String devName, int devAge, String devEmail, String devGender, String[] devLang)
//	{
//		System.out.println(devName);
//		System.out.println(devAge);
//		System.out.println(devEmail);
//		System.out.println(devGender);
//		System.out.println(devLang);
//		return "demo/demoResult";
//	}
	
	//@RequestParam(value="inputName명") //매개변수 지정->매개변수 위치
	//공유 객체를 request하지 않고 Model객체를 이용하여
	//데이터를 공유할 수 있음
	@RequestMapping("/demo/demo2.do")
	public String demo2(
				@RequestParam(value="devName") String devName, // 매개변수 안에 파람의 벨류값을 자료형으로 받아 정의
				@RequestParam(value="devAge", required = false, defaultValue = "28") int devAge,      //매개변수
				@RequestParam(value="devEmail") String devEmail, 
				@RequestParam(value="devGender") String devGender, 
				@RequestParam(value="devLang") String[] devLang,
				Model model
			) 
	{
		System.out.println(devName);
		System.out.println(devAge);
		System.out.println(devEmail);
		System.out.println(devGender);
		System.out.println(devLang);
		
		Dev dev = new Dev(devName, devAge, devEmail, devGender, devLang);
		model.addAttribute("dev", dev); 
		return "demo/demoResult";
	}
	
	@RequestMapping("/demo/demo3.do")
	public String demo3(@RequestParam Map map, Model model)
	{
		System.out.println(map);
		model.addAttribute("dev", map);
		return "demo/demoResult";
	}
	
	@RequestMapping("/demo/demo4.do")
	public String demo4(Dev dev, Model model)
	{
		model.addAttribute("dev", dev);
		return "demo/demoResult";
	}
	
	
	@RequestMapping("/demo/insertDev.do")
	public String insertDev(Dev dev)
	{
		System.out.println(dev);
		int result = devService.insertDev(dev);
		
		System.out.println(result);
		
		//reDirect전환
		// return "/";  -->/WEB-INF/views//.jsp ->에러 찾을 수 없음
		return "redirect:/";
	}
	
	@RequestMapping("/demo/selectDevList.do")
	public String selectDevList(Model model) // HttpServletRequest request
	{
		List<Dev> list = devService.selectDevList();
		for(Dev d : list)
		{
			System.out.println(d.toString());
		}
		model.addAttribute("list", list);
		return "demo/devList";
	}
	


}
