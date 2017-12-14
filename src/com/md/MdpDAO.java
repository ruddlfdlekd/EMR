package com.md;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.util.DBConnector;
import com.util.MdpMakeRow;

public class MdpDAO {
	public int getTotalCount(MdpMakeRow mdpmakeRow) throws Exception{
		Connection con =DBConnector.getConnect();
		String sql ="select nvl(count(s_num), 0) from mdp where "+ mdpmakeRow.getKind()+ " like ?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, "%"+mdpmakeRow.getSearch()+"%");
		ResultSet rs = st.executeQuery();
		rs.next();
		int totalCount=rs.getInt(1);
		DBConnector.disConnect(rs, st, con);
		return totalCount;
		
	}

	//selectList
	public ArrayList<MdpDTO> selectList(MdpMakeRow mdpmakeRow) throws Exception{
	Connection con = DBConnector.getConnect();
	String sql ="select * from "
			+ "(select rownum R, N.* from "
			+ "(select * from mdp where "+mdpmakeRow.getKind()+" like ? order by s_num desc) N) "
			+ "where R between ? and ?";
	PreparedStatement st = con.prepareStatement(sql);
	st.setString(1, "%"+mdpmakeRow.getSearch()+"%");
	st.setInt(2, mdpmakeRow.getStartRow());
	st.setInt(3, mdpmakeRow.getLastRow());

	ResultSet rs = st.executeQuery();
	ArrayList<MdpDTO> ar = new ArrayList<>();


	while(rs.next()) {
		MdpDTO mdpDTO = new MdpDTO();
		mdpDTO.setP_num(rs.getInt("p_num"));
		mdpDTO.setM_name(rs.getString("m_name"));
		mdpDTO.setM_q(rs.getInt("m_q"));
		mdpDTO.setS_num(rs.getInt("s_num"));
		ar.add(mdpDTO);
		
	}
	DBConnector.disConnect(rs, st, con);
	return ar;
	}

	}
