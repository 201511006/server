package com.hybrid.gungduk.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.hybrid.gungduk.dto.RegDto;

public class RegDao {
	
	private Connection conn;
	
	public RegDao() {
		try {
			String dbURL = "jdbc:mysql://nydb.c284tnijrgky.ap-northeast-2.rds.amazonaws.com/gungduk";
			String dbID = "user";
			String dbPassword = "nynydbdb1234";
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public int registerCheck(String email){ //�ߺ��Ǵ� ���̵� �ִ��� üũ
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		String SQL = "SELECT * FROM USER WHERE email = ?";
		try {
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();
			if(rs.next()){
				return 0; //�̹� �����ϴ� ȸ��
			}else{
				return 1; //���� ������ ȸ�� ���̵�
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return -1;//DB����
	}
	
	public int register(String email, String pw, String phoneNum){
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		String SQL = "INSERT INTO USER VALUES (?, ?, ?)";
		try {
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, email);
			pstmt.setString(2, pw);
			pstmt.setString(3, phoneNum);
			return pstmt.executeUpdate();//����� SQL ���� ��ȯ -> 1
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return -1;//DB����
	}
}
