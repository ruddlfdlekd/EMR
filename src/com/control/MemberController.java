package com.control;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.action.Action;
import com.action.ActionFoward;

/**
 * Servlet implementation class MemberController
 */
@WebServlet("/MemberController")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Map<String, Object> command;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberController() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    public void init(ServletConfig config) throws ServletException{
   
    	command = new HashMap<>();
    	String fileName = config.getInitParameter("property");
    	String filePath = config.getServletContext().getRealPath("WEB-INF/property");
    	FileInputStream fi= null;
    	Properties prop = new Properties();
    	try {
			fi = new FileInputStream(new File(filePath, fileName));
			prop.load(fi);
			Iterator<Object> it = prop.keySet().iterator();
			while(it.hasNext()) {
				String key = (String)it.next();
				String value= (String)prop.get(key);
				Class cls = Class.forName(value);
				Object ins = cls.newInstance();
				command.put(key, ins);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				fi.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
    	
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getServletPath();
		ActionFoward actionFoward=null;
		Action action=null;
		
		if(uri.charAt(1)=='a')
			uri="/member"+uri.substring(6);
		else if(uri.charAt(1)=='t')
			uri="/member"+uri.substring(10);
		
		action= (Action)command.get(uri);

		actionFoward = action.doProcess(request, response);
		if(actionFoward.isCheck()) {
			
			RequestDispatcher view = request.getRequestDispatcher(actionFoward.getPath());
			
			view.forward(request, response);
			
		}else {
			response.sendRedirect(actionFoward.getPath());
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
