package com.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.util.DBConnector;

public class SmemberDAO {
	public SmemberDTO Login(SmemberDTO smemberDTO)throws Exception {
		Connection con = DBConnector.getConnect();
		String sql = "select * from s_member where s_num=? and s_pw=?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, smemberDTO.getS_num());
		st.setString(2, smemberDTO.getS_pw());
		ResultSet rs = st.executeQuery();
	
		if(rs.next()) {
		smemberDTO.setS_job(rs.getInt("s_job"));
		smemberDTO.setS_birth(rs.getDate("s_birth"));
		smemberDTO.setS_age(rs.getInt("s_age"));
		smemberDTO.setS_phone(rs.getString("s_phone"));
		smemberDTO.setS_name(rs.getString("s_name"));
		smemberDTO.setS_email(rs.getString("s_email"));
		}
		DBConnector.disConnect(rs, st, con);
		return smemberDTO;
		}
	
	
	
	
	
	public int Update(SmemberDTO smemberDTO)throws Exception{
		
		Connection con = DBConnector.getConnect();
		String sql = "update s_member set s_pw=?, s_name=?, s_email=?, s_phone=? where s_num=?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, smemberDTO.getS_pw());
		st.setString(2, smemberDTO.getS_name());
		st.setString(3, smemberDTO.getS_email());
		st.setString(4, smemberDTO.getS_phone());
		st.setInt(5, smemberDTO.getS_num());
		int result= st.executeUpdate();
		DBConnector.disConnect(st, con);
		
		return result;
	}

}
