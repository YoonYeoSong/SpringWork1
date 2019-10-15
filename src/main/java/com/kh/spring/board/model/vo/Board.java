package com.kh.spring.board.model.vo;

import java.sql.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class Board {
	private int boardNo;
	private String baordTitle;
	private String boardWriter;
	private String boardContent;
	private Date boardDate;
	private int boardReadcount;

}
