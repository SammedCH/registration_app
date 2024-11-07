package com.registartionapp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.registartionapp.model.DAOService;
import com.registartionapp.model.DAOServiceImpl;

@WebServlet("/verifyLogin")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public LoginController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		DAOService dao=new DAOServiceImpl();
		dao.connectDB();
		boolean status = dao.verifyCredentials(email, password);
		if(status==true) {
			HttpSession session = request.getSession();
			session.setAttribute("email", "password");
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/CreateRegistration.jsp");
		    rd.forward(request, response);
		}else {
			request.setAttribute("error", "invalid username/password");
			RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
			rd.include(request, response);
		}
	}

}
