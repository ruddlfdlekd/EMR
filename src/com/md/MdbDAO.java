package com.md;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.util.DBConnector;
import com.util.MdbMakeRow;
import com.util.MakeRow;
import java.util.ArrayList;
import java.util.List;
public class MdbDAO {
	public int getTotalCount(MdbMakeRow mdbmakeRow) throws Exception{
		Connection con =DBConnector.getConnect();
		String sql ="select nvl(count(M_NUM), 0) from mdb where "+ mdbmakeRow.getKind()+ " like ?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, "%"+mdbmakeRow.getSearch()+"%");
		ResultSet rs = st.executeQuery();
		rs.next();
		int totalCount=rs.getInt(1);
		DBConnector.disConnect(rs, st, con);
		return totalCount;
		
	}

	//selectList
	public ArrayList<MdbDTO> selectList(MdbMakeRow mdbmakeRow) throws Exception{
	Connection con = DBConnector.getConnect();
	String sql ="select * from "
			+ "(select rownum R, N.* from "
			+ "(select * from mdb where "+mdbmakeRow.getKind()+" like ? order by M_NUM desc) N) "
			+ "where R between ? and ?";
	PreparedStatement st = con.prepareStatement(sql);
	st.setString(1, "%"+mdbmakeRow.getSearch()+"%");
	st.setInt(2, mdbmakeRow.getStartRow());
	st.setInt(3, mdbmakeRow.getLastRow());

	ResultSet rs = st.executeQuery();
	ArrayList<MdbDTO> ar = new ArrayList<>();


	while(rs.next()) {
		MdbDTO mdbDTO = new MdbDTO();
		mdbDTO.setM_num(rs.getInt("m_num"));
	    mdbDTO.setM_oq(rs.getInt("m_oq"));
	    mdbDTO.setM_omoney(rs.getInt("m_omoney"));
		ar.add(mdbDTO);
	}
	DBConnector.disConnect(rs, st, con);
	return ar;
	}

	}
