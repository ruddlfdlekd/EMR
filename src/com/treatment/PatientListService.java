package com.treatment;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.action.Action;
import com.action.ActionFoward;
import com.util.MakePage;
import com.util.MakeRow;
import com.util.Pageing;

public class PatientListService implements Action {
	public ActionFoward doProcess(HttpServletRequest request, HttpServletResponse response) {
		
		ActionFoward actionFoward = new ActionFoward();
		int curPage=1;
		int totalCount;
		
		try {
			curPage=Integer.parseInt(request.getParameter("curPage"));
		} catch (Exception e) {
			
		}
		
		try {
			PmemberDAO pmemberDAO = new PmemberDAO();
			MakeRow makeRow = new MakeRow();
			
			totalCount = pmemberDAO.getptCount();
			MakePage makePage = new MakePage(curPage, totalCount);
			makeRow = makePage.getMakeRow(makeRow);
			List<PmemberDTO> ar = pmemberDAO.getptList(makeRow);
			
			Pageing pageing = makePage.pageing();
			
			request.setAttribute("list", "Patient List");
			request.setAttribute("ptList", ar);
			request.setAttribute("page", pageing);
			request.setAttribute("make", makeRow);
		} catch (Exception e) {
			
		}
		
		actionFoward.setCheck(true);
		actionFoward.setPath("../WEB-INF/view/treatment/patientList.jsp");
		
		return actionFoward;
	}
}
