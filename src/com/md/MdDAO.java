package com.md;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.util.DBConnector;
import com.util.MakeRow;
import java.util.ArrayList;
import java.util.List;
public class MdDAO {
public int getTotalCount(MMakeRow mmakeRow) throws Exception{
	Connection con =DBConnector.getConnect();
	String sql ="select nvl(count(num), 0) from md where "+ mmakeRow.getKind()+ " like ?";
	PreparedStatement st = con.prepareStatement(sql);
	st.setString(1, "%"+mmakeRow.getSearch()+"%");
	ResultSet rs = st.executeQuery();
	rs.next();
	int totalCount=rs.getInt(1);
	DBConnector.disConnect(rs, st, con);
	return totalCount;
	
}

//selectList
public ArrayList<MdDTO> selectList(MMakeRow mmakeRow) throws Exception{
Connection con = DBConnector.getConnect();
String sql ="select * from "
		+ "(select rownum R, N.* from "
		+ "(select * from md where "+mmakeRow.getKind()+" like ? order by num desc) N) "
		+ "where R between ? and ?";
PreparedStatement st = con.prepareStatement(sql);
st.setString(1, "%"+mmakeRow.getSearch()+"%");
st.setInt(2, mmakeRow.getStartRow());
st.setInt(3, mmakeRow.getLastRow());

ResultSet rs = st.executeQuery();
ArrayList<MdDTO> ar = new ArrayList<>();


while(rs.next()) {
	MdDTO mdDTO = new MdDTO();
	mdDTO.setM_num(rs.getInt("m_num"));
	mdDTO.setM_name(rs.getString("m_name"));
	mdDTO.setM_q(rs.getInt("m_q"));
	mdDTO.setM_mf(rs.getString("m_mf"));
	ar.add(mdDTO);
}
DBConnector.disConnect(rs, st, con);
return ar;
}

}
