package com.md;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.action.Action;
import com.action.ActionFoward;
import com.util.MMakeRow;
import com.util.MakePage;
import com.util.MdbMakeRow;
import com.util.Pageing;

public class MDBListService implements Action {

	@Override
	public ActionFoward doProcess(HttpServletRequest request, HttpServletResponse response) {
		ActionFoward actionFoward = new ActionFoward();
		//curpage
				int curPage=1;
				try {
					String cpage = request.getParameter("curPage");
					if ( cpage == null || cpage.equals("") ) {
						cpage="1";
					}
					System.out.println("cpager : " + cpage);
					curPage=Integer.parseInt(cpage);
					
				} catch (Exception e) {
					e.printStackTrace();
					// TODO: handle exception
				}
			MdbMakeRow mdbmakeRow = new MdbMakeRow();
			mdbmakeRow.setKind(request.getParameter("kind"));
			mdbmakeRow.setSearch(request.getParameter("search"));
			System.out.println("kind : " + mdbmakeRow.getKind());
			System.out.println("search : " + mdbmakeRow.getSearch());
			MdbDAO mdbDAO = new MdbDAO();
			int totalCount;
			try {
				totalCount=mdbDAO.getTotalCount(mdbmakeRow);
				MakePage makePage = new MakePage(curPage, totalCount);
				mdbmakeRow=makePage.getMakeRow(mdbmakeRow);
				List<MdbDTO> ar = mdbDAO.selectList(mdbmakeRow);
				//페이징 처리
				
				Pageing pageing = makePage.pageing();
				request.setAttribute("list", ar);
				request.setAttribute("page", pageing);
				request.setAttribute("make", mdbmakeRow);
			} catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}
		actionFoward.setCheck(true);
		actionFoward.setPath("../WEB-INF/view/md/MDBList.jsp");
		return actionFoward;
	}

}
