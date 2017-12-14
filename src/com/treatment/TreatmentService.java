package com.treatment;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.action.Action;
import com.action.ActionFoward;
import com.member.SmemberDTO;

public class TreatmentService implements Action{
	public ActionFoward doProcess(HttpServletRequest request, HttpServletResponse response) {
		PmemberDAO pmemberDAO = null;
		PmemberDTO pmemberDTO = null;
		
		ActionFoward actionFoward = new ActionFoward();
		String method = request.getMethod();
		
		if(method.equals("POST")) {
			pmemberDTO = new PmemberDTO();
			pmemberDTO.setP_num(Integer.parseInt(request.getParameter("p_num")));
			pmemberDTO.setP_snote(request.getParameter("p_record"));
			pmemberDAO = new PmemberDAO();
			try {
				pmemberDAO.setpcInsert(pmemberDTO);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		} else {
			pmemberDAO = new PmemberDAO();
			try {
				ArrayList<Object> ar= pmemberDAO.getptOneList(Integer.parseInt(request.getParameter("p_num")));
				request.setAttribute("p_info", (PmemberDTO)ar.get(0));
				request.setAttribute("s_info", (SmemberDTO)ar.get(1));
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		actionFoward.setCheck(true);
		actionFoward.setPath("../WEB-INF/view/treatment/treatment.jsp");
		return actionFoward;
	}
}
