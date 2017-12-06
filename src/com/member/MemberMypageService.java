package com.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.action.Action;
import com.action.ActionFoward;
import com.member.SmemberDTO;



public class MemberMypageService implements Action {

	@Override
	public ActionFoward doProcess(HttpServletRequest request, HttpServletResponse response) {
		
		SmemberDTO memberDTO=(SmemberDTO)request.getSession().getAttribute("member");
		//SmemberDAO SmemberDAO = new SmemberDAO();
		
		request.setAttribute("member", memberDTO);
		ActionFoward actionFoward = new ActionFoward();
		actionFoward.setCheck(true);
		actionFoward.setPath("../WEB-INF/view/member/memberMypage.jsp");
		
		return actionFoward;
	}

}
