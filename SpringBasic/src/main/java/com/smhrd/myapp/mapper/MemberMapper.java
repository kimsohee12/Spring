package com.smhrd.myapp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.smhrd.myapp.domain.WebMember;

@Mapper
public interface MemberMapper {
	
	//회원가입 할때 사용할 메서드
	public int join (WebMember m);

	//로그인
	public WebMember login (WebMember m);
	
	//전체 회원정보 
	
	public List<WebMember> select();
}
