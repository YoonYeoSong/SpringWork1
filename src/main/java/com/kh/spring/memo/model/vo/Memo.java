package com.kh.spring.memo.model.vo;

import java.sql.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class Memo {
	private int memoNo;
	private String memo;
	private String password;
	private Date memodate;
	
}
