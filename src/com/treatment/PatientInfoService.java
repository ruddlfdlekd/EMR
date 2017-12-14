package com.treatment;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.action.Action;
import com.action.ActionFoward;

public class PatientInfoService implements Action{
	public ActionFoward doProcess(HttpServletRequest request, HttpServletResponse response) {
		ActionFoward actionFoward = new ActionFoward();
		String p_num = request.getParameter("p_num");
		request.setAttribute("p_num", p_num);
		actionFoward.setCheck(true);
		actionFoward.setPath("../WEB-INF/view/treatment/patientInfo.jsp");
		return actionFoward;
	}
}
