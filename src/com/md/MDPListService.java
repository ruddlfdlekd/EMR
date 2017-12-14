package com.md;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.action.Action;
import com.action.ActionFoward;

import com.util.MakePage;
import com.util.MdpMakeRow;
import com.util.Pageing;

public class MDPListService implements Action {

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
			MdpMakeRow mdpmakeRow = new MdpMakeRow();
			mdpmakeRow.setKind(request.getParameter("kind"));
			mdpmakeRow.setSearch(request.getParameter("search"));
			System.out.println("kind : " + mdpmakeRow.getKind());
			System.out.println("search : " + mdpmakeRow.getSearch());
			MdpDAO mdpDAO = new MdpDAO();
			int totalCount;
			try {
				totalCount=mdpDAO.getTotalCount(mdpmakeRow);
				MakePage makePage = new MakePage(curPage, totalCount);
				mdpmakeRow=makePage.getMakeRow(mdpmakeRow);
				List<MdpDTO> ar = mdpDAO.selectList(mdpmakeRow);
				//페이징 처리
				
				Pageing pageing = makePage.pageing();
				request.setAttribute("list", ar);
				request.setAttribute("page", pageing);
				request.setAttribute("make", mdpmakeRow);
			} catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}
		actionFoward.setCheck(true);
		actionFoward.setPath("../WEB-INF/view/md/MDPList.jsp");
		return actionFoward;
	}

}
