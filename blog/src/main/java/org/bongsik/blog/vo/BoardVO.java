package org.bongsik.blog.vo;

import java.util.Date;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class BoardVO {

	private int id;
	private String subject;
	private String context;
	private String attachments;
	private int likes;
	private int views;
	private Date create_time;
	private Date update_time;

}
