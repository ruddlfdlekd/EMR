package com.hospital;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.member.PmemberDTO;
import com.util.DBConnector;
import com.util.HMakeRow;

public class HPmemberDAO {
	
	public List<HPmemberDTO> SelectList(HMakeRow hmakeRow) throws Exception{
		Connection con = DBConnector.getConnect();
		List<HPmemberDTO> ar = new ArrayList<>();
		HPmemberDTO hpmemberDTO = null;

		
		
		
		
		if(hmakeRow.getTt().equals("ward")) {
		String sql ="select * from "
				+ "(select rownum R, N.* from "
				+ "(select * from "+hmakeRow.getTt()+" where "+hmakeRow.getKind()+" like ? order by w_num asc) N) "
				+ "where R between ? and ?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, "%"+hmakeRow.getSearch()+"%");
		st.setInt(2, hmakeRow.getStartRow());
		st.setInt(3, hmakeRow.getLastRow());
		ResultSet rs = st.executeQuery();
		while(rs.next()) {
		hpmemberDTO = new HPmemberDTO();
		hpmemberDTO.setW_num(rs.getInt("w_num"));
		hpmemberDTO.setW_rnum(rs.getInt("w_rnum"));
		hpmemberDTO.setW_rmax(rs.getInt("w_rmax"));
		hpmemberDTO.setP_num(rs.getInt("p_num"));
		hpmemberDTO.setP_name(rs.getString("p_name"));
		hpmemberDTO.setP_sung(rs.getString("p_sung"));
		hpmemberDTO.setS_num(rs.getInt("s_num"));
		hpmemberDTO.setS_name(rs.getString("s_name"));
		hpmemberDTO.setP_date(rs.getDate("p_date"));
			ar.add(hpmemberDTO);
		}
		DBConnector.disConnect(rs, st, con);
		}
		else {
			String sql ="select * from "
					+ "(select rownum R, N.* from "
					+ "(select * from "+hmakeRow.getTt()+" where "+hmakeRow.getKind()+" like ? order by p_num asc) N) "
					+ "where R between ? and ?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, "%"+hmakeRow.getSearch()+"%");
			st.setInt(2, hmakeRow.getStartRow());
			st.setInt(3, hmakeRow.getLastRow());
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				hpmemberDTO = new HPmemberDTO();
				hpmemberDTO.setP_num(rs.getInt("p_num"));
				hpmemberDTO.setP_name(rs.getString("p_name"));
				hpmemberDTO.setS_num(rs.getInt("s_num"));
				hpmemberDTO.setS_name(rs.getString("s_name"));
				hpmemberDTO.setP_sdate(rs.getDate("p_sdate"));
				ar.add(hpmemberDTO);
				}
			DBConnector.disConnect(rs, st, con);
		}

		return ar;
	}
	
	
	
	
	
	
	public int getTotalCount(HMakeRow hmakeRow)throws Exception{
		Connection con = DBConnector.getConnect();
		String sql ="select nvl(count(*),0) from "+hmakeRow.getTt()+" where "+hmakeRow.getKind()+" like ?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, "%"+hmakeRow.getSearch()+"%");
		ResultSet rs = st.executeQuery();
		rs.next();
		int totalCount= rs.getInt(1);
		
		DBConnector.disConnect(rs, st, con);
		
		return totalCount;
	}
	
	
	
	public PmemberDTO SelectOne(int p_num)throws Exception{
		Connection con = DBConnector.getConnect();
		String sql ="select * from p_member where p_num=?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, p_num);
		ResultSet rs = st.executeQuery();
		PmemberDTO pmemberDTO = new PmemberDTO();
		if(rs.next()) {
			pmemberDTO.setP_age(rs.getInt("p_age"));
			pmemberDTO.setP_s_num(rs.getInt("p_s_num"));
			pmemberDTO.setP_num(rs.getInt("p_num"));
			pmemberDTO.setP_btype(rs.getString("p_btype"));
			pmemberDTO.setP_dname(rs.getString("p_dname"));
			pmemberDTO.setP_name(rs.getString("p_name"));
			pmemberDTO.setP_snote(rs.getString("p_snote"));
			pmemberDTO.setP_sung(rs.getString("p_sung"));
		}
		
		
		return pmemberDTO;
		
		
		
	}
	
	
}
