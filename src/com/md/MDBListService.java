package com.md;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.action.Action;
import com.action.ActionFoward;
import com.util.MakePage;
import com.util.Pageing;
import com.util.MakeRow;
public class MDBListService implements Action {

	@Override
	public ActionFoward doProcess(HttpServletRequest request, HttpServletResponse response) {
		ActionFoward actionFoward = new ActionFoward();
		//curpage
		int curPage=1;
		try {
			String cpage = request.getParameter("curPage");
			if (cpage == null || cpage.equals("") ) {
				cpage="1";
			}
			System.out.println("cpager:" +cpage);
			curPage=Integer.parseInt(cpage);
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
MdbMakeRow mdbMakeRow = new MdbMakeRow();
mdbMakeRow.setKind(request.getParameter("kind"));
mdbMakeRow.setSearch(request.getParameter("search"));
System.out.println("kind:" + mdbMakeRow.getKind());
System.out.println("search:" + mdbMakeRow.getSearch());
MdbDAO mdbDAO = new MdbDAO();
int totalCount;
try {
	totalCount=mdbDAO.getTotalCount(mdbMakeRow);
	MakePage makePage= new MakePage(curPage, totalCount);
	mdbMakeRow=makePage.getMakeRow(mdbMakeRow);
	List<MdbDTO> ar = mdbDAO.selectList(mdbMakeRow);
	//페이징 처리
	Pageing pageing = makePage.pageing();
	request.setAttribute("list", ar);
	request.setAttribute("page", pageing);
	request.setAttribute("make", mdbMakeRow);
} catch (Exception e) {
	e.printStackTrace();
	// TODO: handle exception
}
//전송
		actionFoward.setCheck(false);
		actionFoward.setPath("../WEB-INF/view/md/MDBList.jsp");
		return actionFoward;
	}

}
