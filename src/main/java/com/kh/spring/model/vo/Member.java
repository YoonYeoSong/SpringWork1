package com.kh.spring.model.vo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;


@NoArgsConstructor //�⺻������
@Data // ��������� ���� setter / getter, �Ű������� �ִ� ������, toString, equles, hashCode���� �� �������
public class Member {
	private String userId;
	private String password;
	private String userName;
	private String gender;
	private int age;
	private String email;
	private String phone;
	private String address;
	private String[] hobby;
	private Date enrollDate;
}
