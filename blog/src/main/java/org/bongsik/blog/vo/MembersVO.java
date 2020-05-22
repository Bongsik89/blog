package org.bongsik.blog.vo;

import java.util.Date;

import lombok.Data;
import lombok.ToString;
@Data
@ToString
public class MembersVO {
	
	private int id;
	private String userId;
	private String password;
	private String nickname;
	private String email;
	private int authority;
	private int declaration;
	private Date last_login;
	private Date create_time;
	private Date update_time;
	
	private String domain;
	

}
