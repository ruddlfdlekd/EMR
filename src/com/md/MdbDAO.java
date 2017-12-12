package com.md;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.util.DBConnector;

public class MdbDAO {
public int getTotalCount(MdbMakeRow mdbMakeRow)throws Exception{
	Connection con = DBConnector.getConnect();
	String sql = "select nvl(count(M_OQ),0)from mdb where "+mdbMakeRow.getKind()+" like ?";
	PreparedStatement st = con.prepareStatement(sql);
	st.setString(1, "%"+mdbMakeRow.getSearch()+"%");
	ResultSet rs = st.executeQuery();
	rs.next();
	int totalCount=rs.getInt(1);
	DBConnector.disConnect(rs, st, con);
	return totalCount;	
}

//selectList
public ArrayList<MdbDTO> selectList(MdbMakeRow mdbMakeRow) throws Exception{
	Connection con = DBConnector.getConnect();
	String sql="select * from"
			+ "(select rownum R,N.* from"
			+ "(select * from mdb where "+mdbMakeRow.getKind()+" like? order by M_OQ desc)N)"
			+ "where R between ? and ?";
PreparedStatement st = con.prepareStatement(sql);
st.setString(1, "%"+mdbMakeRow.getSearch()+"%");
st.setInt(2, mdbMakeRow.getStartRow());
st.setInt(3, mdbMakeRow.getLastRow());

ResultSet rs = st.executeQuery();
ArrayList<MdbDTO> ar = new ArrayList<>();

while(rs.next()) {
	MdbDTO mdbDTO = new MdbDTO();
	mdbDTO.setM_num(rs.getInt("m_num"));
	mdbDTO.setM_name(rs.getString("m_name"));
	mdbDTO.setM_oq(rs.getInt("m_oq"));
	mdbDTO.setM_omoney(rs.getInt("m_omoney"));
	mdbDTO.setM_mf(rs.getString("m_mf"));
	ar.add(mdbDTO);
	
}
DBConnector.disConnect(rs, st, con);
return ar;
}
}