package com.kh.travelmaker.member.vo;

import lombok.Data;

@Data
public class MemberVo {
	
	private String no;
	private String id;
	private String name;
	private String email;
	private String password;
	private String profilePicturePath;
	private String status;
	private String nick;
}
