package com.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.action.Action;
import com.action.ActionFoward;


public class MemberLoginService implements Action {

	@Override
	public ActionFoward doProcess(HttpServletRequest request, HttpServletResponse response) {
		ActionFoward actionFoward= new ActionFoward();
		String method=request.getMethod();
		if(method.equals("POST")) {
			SmemberDTO smemberDTO = new SmemberDTO();
			try {
			smemberDTO.setS_num(Integer.parseInt(request.getParameter("s_num")));
			smemberDTO.setS_pw(request.getParameter("s_pw"));
			}catch(Exception e) {
				smemberDTO.setS_num(1);
			}
			SmemberDAO smemberDAO = new SmemberDAO();
			try {
				smemberDTO = smemberDAO.Login(smemberDTO);
			
			} catch (Exception e) {
				smemberDTO=null;
				e.printStackTrace();
			}
			if(smemberDTO.getS_job()!=0) {
				if(smemberDTO.getS_job() == 1 ) {
				request.getSession().setAttribute("member" ,smemberDTO);
				actionFoward.setCheck(true);
				actionFoward.setPath("../WEB-INF/view/member/memberPage1.jsp");
				}
				else if(smemberDTO.getS_job() == 2 ) {
				request.getSession().setAttribute("member" ,smemberDTO);
				actionFoward.setCheck(true);
				actionFoward.setPath("../WEB-INF/view/member/memberPage2.jsp");
				}
				else {
				request.getSession().setAttribute("member" ,smemberDTO);
				actionFoward.setCheck(true);
				actionFoward.setPath("../WEB-INF/view/member/memberPage3.jsp");
				}
			}
			else {
				request.setAttribute("message", "Fail");
				request.setAttribute("path", "./member/memberLogin.member");
				actionFoward.setCheck(true);
				actionFoward.setPath("../WEB-INF/view/common/result.jsp");
				
			}
		}
		
		else {
			actionFoward.setPath("../index.jsp");
			actionFoward.setCheck(true);
		}
		
		
		return actionFoward;
	}

}
