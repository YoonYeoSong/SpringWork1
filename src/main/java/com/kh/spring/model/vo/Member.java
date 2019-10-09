package com.kh.spring.model.vo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;


@NoArgsConstructor //기본생성자
@Data // 멤버변수에 대한 setter / getter, 매개변수가 있는 생성자, toString, equles, hashCode까지 다 만들어줌
public class Member {
	private String userId;
	private String password;
	private String userName;
	private String gender;
	private int age;
	private String email;
	private String phone;
	private String address;
	private String hobby;
	private Date enrolldate;
}
