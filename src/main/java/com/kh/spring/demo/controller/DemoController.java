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
		System.out.println("/demo/demo.do ��Ʈ�ѷ� ȣ��");
		return "demo/demo";
	}


	@RequestMapping("/demo/demo1.do")
	public String demo1(HttpServletRequest req, HttpServletResponse res)
	{
		//��Ʈ�ѷ� �޼ҵ尡 ���� �� �ִ� Parameter
		// HttpServletRequest
		// HttpServletResponse
		// HttpSession
		// java.util.Locale
		// InputStream, Reader : ��û�� ���� ��Ʈ��
		// OutputStream, Writer : ��û�� ���� ��� ��Ʈ��
		// @PathVariable
		// @RequestParam
		// @RequestHeader
		// @CookieValue
		// @RequestBody : Ajax ���۽� json��ü�� �޴� �Ķ���� Ÿ��
		// Map, Model, ModelMap : ���� �����͸� �����ϴ� ���� ��ü
		// Command��ü : Vo�Ķ���ͷ� �Ѿ���� ���� �ڵ����� Vo����!
		String devName = req.getParameter("devName");
		int devAge = Integer.parseInt(req.getParameter("devAge"));
		String devEmail = req.getParameter("devEmail");
		String devGender = req.getParameter("devGender");
		String[] devLangs = req.getParameterValues("devLang");

		System.out.println(devName + devAge + devEmail + devGender);

		for(String s : devLangs)
			System.out.println(s); //demoResult.jsp �ȸ��� 404�߸鼭 syso console�� ����

		Dev dev = new Dev(devName, devAge, devEmail, devGender, devLangs);
		req.setAttribute("dev", dev);

		return "demo/demoResult";

	}


//	//@RequestParam(value="inputName��") //�Ű����� ����->�Ű����� ��ġ
//	@RequestMapping("/demo/demo2.do")
//	public String demo2(
//				@RequestParam(value="devName") String devName, // �Ű����� �ȿ� �Ķ��� �������� �ڷ������� �޾� ����
//				@RequestParam(value="devAge", required = false, defaultValue = "28") int devAge,      //�Ű�����
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
	
	//@RequestParam(value="inputName��") //�Ű����� ����->�Ű����� ��ġ
	//���� ��ü�� request���� �ʰ� Model��ü�� �̿��Ͽ�
	//�����͸� ������ �� ����
	@RequestMapping("/demo/demo2.do")
	public String demo2(
				@RequestParam(value="devName") String devName, // �Ű����� �ȿ� �Ķ��� �������� �ڷ������� �޾� ����
				@RequestParam(value="devAge", required = false, defaultValue = "28") int devAge,      //�Ű�����
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
		
		//reDirect��ȯ
		// return "/";  -->/WEB-INF/views//.jsp ->���� ã�� �� ����
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
	
	@RequestMapping("/demo/update.do")
	public String updateDev(Dev dev,Model model)
	{
		
		System.out.println("오긴하냐");
		
		//Dev dev = new Dev(devName, devAge, devEmail, devGender, devLang);
		model.addAttribute("dev", dev); 
		return "demo/updatedev";
	}
	
	
	@RequestMapping("/demo/updateEnd.do")
	public String updateEnd(Dev dev, Model model)
	{
		System.out.println(dev);
		int result = devService.updateEnd(dev);
		
		System.out.println(result>0?"업데이트완료":"실패");
		
		List<Dev> list = devService.selectDevList();
		for(Dev d : list)
		{
			System.out.println(d.toString());
		}
		model.addAttribute("list", list);
		return "demo/devList";
	}
	
	@RequestMapping("/demo/delete.do")
	public String delete(HttpServletRequest req,Dev dev, Model model)
	{
		int devNo = Integer.parseInt(req.getParameter("devNo"));
		System.out.println("devNo : " + devNo);
		
		int result = devService.deleteDev(devNo);
		
		System.out.println(result>0?"삭제완료":"실패");
		
		List<Dev> list = devService.selectDevList();
		for(Dev d : list)
		{
			System.out.println(d.toString());
		}
		model.addAttribute("list", list);
		return "demo/devList";
	}
	
	
	
}
