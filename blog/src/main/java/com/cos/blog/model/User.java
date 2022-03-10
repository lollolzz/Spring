package com.cos.blog.model;

import java.security.Timestamp;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

//lombox 적용 안됨 현상 .... 고치는 중 ...
@Entity // User 클래스가 Mysql에 테이블이 생성 된다. 
public class User {
	
	
	@Id // Primary key 
	@GeneratedValue(strategy = Generation Type.TABLE) // 프로젝트에서 연결된 DB의 넘버링 전략을 따라간다 
	private int id; // 시퀀스, auto_increment(my sql)
	
	private String username; // 아이디 
	
	private String password;
	
	private String email;
	
	private Timestamp createDate;
	
	
	

}
