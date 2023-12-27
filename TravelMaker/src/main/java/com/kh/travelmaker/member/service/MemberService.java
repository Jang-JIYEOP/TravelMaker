package com.kh.travelmaker.member.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import com.kh.travelmaker.member.dao.MemberDao;
import com.kh.travelmaker.member.vo.MemberVo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberService {
	private final MemberDao dao;
	private final SqlSessionTemplate sst;
	
	public int join(MemberVo vo) throws Exception {

		String id = vo.getId();
		if(id.length() < 4) {
			throw new Exception("아이디가 너무 짧음");
		}
		
		if("admin".equalsIgnoreCase(id)) {
			throw new Exception("사용 불가 아이디");
		
			
		}
		
		return dao.join(sst,vo);
		
		
	}

	public MemberVo login(MemberVo vo) {

		return dao.login(sst,vo);
	}

	

	public int quit(MemberVo vo) {
		return dao.quit(vo, sst);
	}

	public List<MemberVo> list() {

		return dao.list(sst);
	}

	public int edit(MemberVo vo) {

		return dao.edit(vo,sst);
	}

	
	


	
}
