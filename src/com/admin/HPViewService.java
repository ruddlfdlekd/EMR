package com.admin;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.action.Action;
import com.action.ActionFoward;
import com.hospital.HPmemberDAO;
import com.member.PmemberDTO;

public class HPViewService implements Action {

	@Override
	public ActionFoward doProcess(HttpServletRequest request, HttpServletResponse response) {
		ActionFoward actionFoward = new ActionFoward();
		HPmemberDAO hpmemberDAO = new HPmemberDAO();
		PmemberDTO pmemberDTO = new PmemberDTO();

		try {
			pmemberDTO = hpmemberDAO.SelectOne(Integer.parseInt(request.getParameter("p_num")));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

		
		request.setAttribute("list", pmemberDTO);
		actionFoward.setPath("../WEB-INF/view/admin/adminHPView.jsp");
		actionFoward.setCheck(true);
		
		
		
		return actionFoward;
	}

}
