package com.kh.spring.board.model.vo;

import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class Attachment {

	private int attachmentNo;
	private int boardNo;
	private String originalFileName;
	private String renameFileName;
	private Date uploadDate;
	private String status;
	private int downloadCount;
	
}
