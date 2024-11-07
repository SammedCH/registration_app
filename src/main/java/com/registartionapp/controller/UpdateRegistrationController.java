package com.registartionapp.controller;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.registartionapp.model.DAOService;
import com.registartionapp.model.DAOServiceImpl;

@WebServlet("/update")
public class UpdateRegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public UpdateRegistrationController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	  String email = request.getParameter("email");
	  String mobile = request.getParameter("mobile");
	  System.out.println(email);
	  System.out.println(mobile);
	  
	 request.setAttribute("email", email);
	 request.setAttribute("mobile", mobile);
	 RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/update_registration.jsp");
	 rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		
		DAOService service =new DAOServiceImpl();
		service.connectDB();
		service.updateRegistartion(email, mobile);
	
		 ResultSet result = service.listAllReg();
         request.setAttribute("result", result);
         RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/search_result.jsp");
         rd.forward(request, response);
	}

}
