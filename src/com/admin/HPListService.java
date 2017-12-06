package com.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.action.Action;
import com.action.ActionFoward;

public class HPListService implements Action {

	@Override
	public ActionFoward doProcess(HttpServletRequest request, HttpServletResponse response) {
		ActionFoward actionFoward = new ActionFoward();
		actionFoward.setCheck(false);
		actionFoward.setPath("../../WEB-INF/view/admin/adminHPList.jsp");
		return actionFoward;
	}

}
