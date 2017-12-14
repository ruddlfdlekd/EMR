package com.treatment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.member.SmemberDTO;
import com.util.DBConnector;
import com.util.MakeRow;

public class PmemberDAO {
	Connection con;
	PreparedStatement st;
	ResultSet rs;
	String sql;
	
	//patient total count
	public int getptCount() throws Exception {
		con = DBConnector.getConnect();
		sql = "select nvl(count(p_num), 0) from p_member";
		st = con.prepareStatement(sql);
		rs = st.executeQuery();
		rs.next();
		int totalCount = rs.getInt(1);
		DBConnector.disConnect(rs, st, con);
		return totalCount;
	}
	
	//patient total list
	public List<PmemberDTO> getptList(MakeRow makeRow) throws Exception {
		List<PmemberDTO> ar = new ArrayList<PmemberDTO>();
		con = DBConnector.getConnect();
		sql = "select * from (select rownum R, N.* from (select * from p_member order by p_num desc) N) where R between ? and ?";
		st = con.prepareStatement(sql);
		st.setInt(1, makeRow.getStartRow());
		st.setInt(2, makeRow.getLastRow());
		rs = st.executeQuery();
		while(rs.next()) {
			PmemberDTO pmemberDTO = new PmemberDTO();
			pmemberDTO.setP_num(rs.getInt("p_num"));
			pmemberDTO.setP_name(rs.getString("p_name"));
			pmemberDTO.setP_age(rs.getInt("p_age"));
			pmemberDTO.setP_s_num(rs.getInt("p_s_num"));
			pmemberDTO.setP_btype(rs.getString("p_btype"));
			pmemberDTO.setP_dname(rs.getString("p_dname"));
			pmemberDTO.setP_snote(rs.getString("p_snote"));
			ar.add(pmemberDTO);
		}
		DBConnector.disConnect(rs, st, con);
		return ar;
	}
	
	//patient one list
	public ArrayList<Object> getptOneList(int p_num) throws Exception {
		con = DBConnector.getConnect();
		//sql = "select * from p_member where p_num=?";
		sql = "select p_member.*, s_member.s_name from p_member, s_member where p_num=? and s_member.s_num = p_member.p_s_num";
		st = con.prepareStatement(sql);
		st.setInt(1, p_num);
		rs = st.executeQuery();
		PmemberDTO pmemberDTO= new PmemberDTO();
		SmemberDTO smemberDTO = new SmemberDTO();
		ArrayList<Object> ar = new ArrayList<>();
		if(rs.next()) {
			pmemberDTO.setP_num(rs.getInt("p_num"));
			pmemberDTO.setP_name(rs.getString("p_name"));
			pmemberDTO.setP_age(rs.getInt("p_age"));
			pmemberDTO.setP_s_num(rs.getInt("p_s_num"));
			pmemberDTO.setP_btype(rs.getString("p_btype"));
			pmemberDTO.setP_dname(rs.getString("p_dname"));
			pmemberDTO.setP_snote(rs.getString("p_snote"));
			pmemberDTO.setP_sung(rs.getString("p_sung"));
			smemberDTO.setS_name(rs.getString("s_name"));
			ar.add(pmemberDTO);
			ar.add(smemberDTO);
		}
		DBConnector.disConnect(rs, st, con);
		return ar;
	}
	
	//p_chart insert
	public void setpcInsert(PmemberDTO pmemberDTO) throws Exception {
		con = DBConnector.getConnect();
		sql = "insert into p_chart (p_num, p_cr) values (?, ?)";
		st = con.prepareStatement(sql);
		st.setInt(1, pmemberDTO.getP_num());
		st.setString(2, pmemberDTO.getP_snote());
		st.executeUpdate();
		DBConnector.disConnect(st, con);
	}

}
