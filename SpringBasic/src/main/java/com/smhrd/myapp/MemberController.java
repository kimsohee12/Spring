package com.smhrd.myapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.smhrd.myapp.domain.WebMember;

@Controller
public class MemberController {
	
	@RequestMapping(value = "/member/join", method = RequestMethod.POST)
	public void join(@RequestParam("email") String email, @RequestParam("pw")String pw,
					@RequestParam("tel")String tel,  @RequestParam("address")String address) {
	
		WebMember wm = new WebMember(email,pw,tel,address);
	}
	
}
