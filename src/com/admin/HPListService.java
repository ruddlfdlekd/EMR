package com.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.action.Action;
import com.action.ActionFoward;
import com.hospital.HPmemberDAO;
import com.hospital.HPmemberDTO;
import com.util.HMakeRow;
import com.util.MakePage;
import com.util.Pageing;

public class HPListService implements Action {

	@Override
	public ActionFoward doProcess(HttpServletRequest request, HttpServletResponse response) {
		ActionFoward actionFoward = new ActionFoward();
		//curPage null
		int curPage=1;
		try {
			curPage= Integer.parseInt(request.getParameter("curPage"));
		}catch (Exception e) {
			// TODO: handle exception
		}
	
		HMakeRow hmakeRow = new HMakeRow();
		hmakeRow.setKind(request.getParameter("kind"));
		hmakeRow.setSearch(request.getParameter("search"));
		
		HPmemberDAO hpmemberDAO = new HPmemberDAO();
		int totalCount;
	
		try {	
			
			totalCount = hpmemberDAO.getTotalCount(hmakeRow);
			MakePage makePage = new MakePage(curPage, totalCount);
			hmakeRow=makePage.getMakeRow(hmakeRow);
			List<HPmemberDTO> ar = hpmemberDAO.SelectList(hmakeRow);
			//페이징 처리
			System.out.println("12346");
			Pageing pageing = makePage.pageing();
			
			request.setAttribute("list", ar);
			request.setAttribute("page", pageing);
			request.setAttribute("make", hmakeRow);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//전송
		
		actionFoward.setCheck(true);
		actionFoward.setPath("../WEB-INF/view/admin/adminHPList.jsp");
		
		
		
		return actionFoward;
	}

}
