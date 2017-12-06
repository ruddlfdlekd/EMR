package com.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.action.Action;
import com.action.ActionFoward;

public class MemberMainService implements Action {

	@Override
	public ActionFoward doProcess(HttpServletRequest request, HttpServletResponse response) {
		ActionFoward actionFoward = new ActionFoward();
		SmemberDTO memberDTO=(SmemberDTO)request.getSession().getAttribute("member");
		request.setAttribute("member", memberDTO);
		actionFoward.setCheck(true);
		if(memberDTO.getS_job()==1) {
			actionFoward.setPath("../WEB-INF/view/member/memberPage1.jsp");
		}
		else if(memberDTO.getS_job()==2) {
			actionFoward.setPath("../WEB-INF/view/member/memberPage2.jsp");
		}
		else {
			actionFoward.setPath("../WEB-INF/view/member/memberPage3.jsp");
		}
		return actionFoward;
	}

}
