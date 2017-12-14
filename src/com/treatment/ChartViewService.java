package com.treatment;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.action.Action;
import com.action.ActionFoward;
import com.member.SmemberDTO;

public class ChartViewService implements Action{
	public ActionFoward doProcess(HttpServletRequest request, HttpServletResponse response) {
		ActionFoward actionFoward = new ActionFoward();
		PmemberDAO pmemberDAO;
		ArrayList<Object> ar;
		try {
			pmemberDAO = new PmemberDAO();
			ar = pmemberDAO.getptOneList(Integer.parseInt(request.getParameter("p_num")));
			request.setAttribute("p_info", (PmemberDTO)ar.get(0));
			request.setAttribute("s_info", (SmemberDTO)ar.get(1));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		actionFoward.setCheck(true);
		actionFoward.setPath("../WEB-INF/view/treatment/chartView.jsp");
		return actionFoward;
	}
}
