package com.kh.travelmaker.member.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.travelmaker.member.vo.MemberVo;

@Repository
public class MemberDao {

	public int join(SqlSessionTemplate sst, MemberVo vo) {

		return sst.insert("MemberMapper.join",vo);
	}

	public MemberVo login(SqlSessionTemplate sst, MemberVo vo) {

		return sst.selectOne("MemberMapper.login",vo);
	}

	public int quit(MemberVo vo, SqlSessionTemplate sst) {
		return sst.update("MemberMapper.quit", vo);
	}

	public List<MemberVo> list(SqlSessionTemplate sst) {

		return sst.selectList("MemberMapper.list");
	}

	public int edit(MemberVo vo, SqlSessionTemplate sst) {

		return sst.update("MemberMapper.edit",vo);
	}
	
}
