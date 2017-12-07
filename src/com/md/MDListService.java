package com.md;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.action.Action;
import com.action.ActionFoward;
import com.util.MakePage;
import com.util.Pageing;
import com.util.MakeRow;


public class MDListService implements Action {

	@Override
	public ActionFoward doProcess(HttpServletRequest request, HttpServletResponse response) {
		ActionFoward actionFoward = new ActionFoward();
		//curpage
		int curPage=1;
		try {
			curPage=Integer.parseInt(request.getParameter("curPage"));
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	MMakeRow mmakeRow = new MMakeRow();
	mmakeRow.setKind(request.getParameter("kind"));
	mmakeRow.setSearch(request.getParameter("search"));
	MdDAO mdDAO = new MdDAO();
	int totalCount;
	try {
		
		totalCount=mdDAO.getTotalCount(mmakeRow);
		MakePage makePage = new MakePage(curPage, totalCount);
		mmakeRow=makePage.getMakeRow(mmakeRow);
		List<MdDTO> ar = mdDAO.selectList(mmakeRow);
		//페이징 처리
		
		Pageing pageing = makePage.pageing();
		request.setAttribute("list", ar);
		request.setAttribute("page", pageing);
		request.setAttribute("make", mmakeRow);
	} catch (Exception e) {
		// TODO: handle exception
	}
		// 전송
		actionFoward.setCheck(true);
		actionFoward.setPath("../../WEB-INF/view/md/MDList.jsp");
		return actionFoward;
	}

}
