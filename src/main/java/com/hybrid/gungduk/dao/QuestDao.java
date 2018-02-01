package com.hybrid.gungduk.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.hybrid.gungduk.dto.PlcDto;
import com.hybrid.gungduk.dto.QuestDto;
import com.hybrid.gungduk.dto.SuccDto;
import com.hybrid.gungduk.dto.UserDto;

public class QuestDao {

	@Autowired
	private SqlSession sqlSession;
	
	public QuestDto show(PlcDto plcDtoReq){
		QuestDto result = sqlSession.selectOne("quest.showQuest", plcDtoReq);
		return result;
	}
	
	public String checkAnswer(PlcDto plcDtoReq){
		String answer = sqlSession.selectOne("quest.checkAnswer", plcDtoReq);
		return answer;
	}
	
	public int checkSucc(SuccDto sucDtoReq){
		String yesOrNo = sqlSession.selectOne("quest.checkSucc", sucDtoReq);
		if(yesOrNo != null)
			return 2;//������
		else 
			return sqlSession.insert("quest.createSucc", sucDtoReq);//�������� ������ �������
	}
}
