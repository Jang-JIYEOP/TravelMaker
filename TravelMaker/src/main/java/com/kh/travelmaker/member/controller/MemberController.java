package com.kh.travelmaker.member.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.travelmaker.member.service.MemberService;
import com.kh.travelmaker.member.vo.MemberVo;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("member")
@RequiredArgsConstructor
public class MemberController {

	private final MemberService service;
	
	//회원가입 페이지 출력
	@GetMapping("join")
	public String join() {
		return "member/join";
	}
	//회원가입 기능 구현
	@PostMapping("join")
	public String join(MemberVo vo) throws Exception{
		int result = service.join(vo);
		
		if(result != 1) {
			throw new Exception();
		}
		return "member/join";
	}
	
	//로그인 기능 구현
	@PostMapping("login")
	public String login(MemberVo vo, HttpSession session) throws Exception {
		
		MemberVo loginMember = service.login(vo);
		
		if(loginMember == null) {
			throw new Exception("로그인 실패");
		}
		
		session.setAttribute("loginMember", loginMember);
		session.setAttribute("alertMsg", "로그인 성공 !");
		
		return "redirect:/home";
	}
	// 프로필 수정 기능 구현
	@PostMapping("edit")
	public String edit(MemberVo vo) throws Exception {
		int result = service.edit(vo);
		if(result != 1) {
			throw new Exception();
		}
		
		return "redirect:/home";
	}
	// 회원 탈퇴 기능 
	@GetMapping("quit")
	public String quit(MemberVo vo, HttpSession session) throws Exception{
		int result = service.quit(vo);
		
		if(result != 1) {
			throw new Exception();
		}
		
		session.removeAttribute("loginMember");
		session.setAttribute("alertMsg", "회원 탈퇴 성공");
		
		
		return "redirect:/home";
	}
	
	//회원 리스트 조회
	@GetMapping("list")
	public String list(Model model) {
		List<MemberVo> voList = service.list();
		
		model.addAttribute("memberVoList", voList);
		
		System.out.println(voList);
		return "member/list";
	}
	
	//로그아웃 기능 구현
	@GetMapping("logout")
	public String logout(HttpSession session) {
		session.removeAttribute("loginMember");
		return "redirect:/home";
	}
	
}
