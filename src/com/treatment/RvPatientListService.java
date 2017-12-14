package com.treatment;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.action.Action;
import com.action.ActionFoward;

public class RvPatientListService implements Action {
	public ActionFoward doProcess(HttpServletRequest request, HttpServletResponse response){
		ActionFoward actionFoward = new ActionFoward();
		
		actionFoward.setCheck(true);
		actionFoward.setPath("../WEB-INF/view/treatment/rvpatientList.jsp");
		return actionFoward;
	}
}
