package com.hybrid.gungduk.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.hybrid.gungduk.dto.RegistDto;

public class RegistDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	public int registerCheck(String email){ //�ߺ��Ǵ� ���̵� �ִ��� üũ
	
		String rs = sqlSession.selectOne("register.registCheck", email);
		
		if(rs != null) return 0; //�̹� �����ϴ� ȸ��
		else return 1; //���� ������ ȸ�� ���̵�
	}
	
	public int register(RegistDto regDtoReq){
		return sqlSession.insert("register.regist", regDtoReq);
	}
}
