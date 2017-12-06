package com.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.action.Action;
import com.action.ActionFoward;


public class MemberUpdateService implements Action {

	@Override
	public ActionFoward doProcess(HttpServletRequest request, HttpServletResponse response) {
		ActionFoward actionFoward= new ActionFoward();
		String method=request.getMethod();

		if(method.equals("POST")) {
			SmemberDTO smemberDTO=(SmemberDTO)request.getSession().getAttribute("member");
			SmemberDAO smemberDAO = new SmemberDAO();
			SmemberDTO smemberDTO2 = new SmemberDTO();
			try {
			smemberDTO2.setS_num(smemberDTO.getS_num());
			smemberDTO2.setS_birth(smemberDTO.getS_birth());
			smemberDTO2.setS_age(smemberDTO.getS_age());
			smemberDTO2.setS_job(smemberDTO.getS_job());
			smemberDTO2.setS_pw(request.getParameter("s_pw"));
			smemberDTO2.setS_name(request.getParameter("s_name"));
			smemberDTO2.setS_phone(request.getParameter("s_phone"));
			smemberDTO2.setS_email(request.getParameter("s_email"));
			}catch(Exception e) {
			}
			int result;
			try {
				result = smemberDAO.Update(smemberDTO2);
			} catch (Exception e) {
				result = 0;
			}

			if(result>0) {
				
				request.getSession().setAttribute("member" ,smemberDTO2);
				actionFoward.setCheck(true);
				actionFoward.setPath("../WEB-INF/view/member/memberMypage.jsp");
				}
			else {
				request.setAttribute("message", "Fail");
				request.setAttribute("path", "./member/memberMypage.member");
				actionFoward.setCheck(true);
				actionFoward.setPath("../WEB-INF/view/common/result.jsp");
				}
		}
		
		else {
			actionFoward.setCheck(true);
			actionFoward.setPath("../WEB-INF/view/member/memberUpdate.jsp");
		}
		
		
		return actionFoward;
	}

}
