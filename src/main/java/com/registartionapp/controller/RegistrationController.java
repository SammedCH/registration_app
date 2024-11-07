package com.registartionapp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.registartionapp.model.DAOService;
import com.registartionapp.model.DAOServiceImpl;

@WebServlet("/registrationController")
public class RegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public RegistrationController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/CreateRegistration.jsp");
		   rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		String name = request.getParameter("name");
		String city = request.getParameter("city");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		
		
		DAOService dao=new DAOServiceImpl();
		dao.connectDB();
		dao.saveRegistration(name,city,email,mobile);
		
		request.setAttribute("msg", "Registration Successful");
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/CreateRegistration.jsp");
	   rd.include(request, response);
	} 

}
