package com.java;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.ClassDao;


@WebServlet("/Login")
public class Login extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	     String username = request.getParameter("username");
	     String password = request.getParameter("password");
	     
	     ClassDao dao = new ClassDao();
	     
	     
	     if (dao.check(username, password))
	     {
			HttpSession session = request.getSession();
			session.setAttribute("uname",username);		
	    	 response.sendRedirect("Welcome.jsp");
		}
	    else {
			response.sendRedirect("login.jsp");
		}
	
}
}