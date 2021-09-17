package com.servelet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.user.Address;
import com.user.Student;

/**
 * Servlet implementation class RegistrationServelet
 */
@WebServlet("/RegistrationServelet")
public class RegistrationServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationServelet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Student student = new Student();
		student.setEmail(request.getParameter("email"));
		student.setFirstName(request.getParameter("firstName"));
		student.setLastName(request.getParameter("lastName"));
		student.setPassword(request.getParameter("password"));
		student.setSchoolName("Claim Academy");
		
		Address address = new Address();
		
		address.setCity(request.getParameter("city"));
		address.setState(request.getParameter("state"));
		address.setStreet(request.getParameter("street"));
		address.setZipCode(request.getParameter("city"));
		
		HttpSession session = request.getSession(true);
		session.setAttribute("student", student);
		
		RequestDispatcher rs = request.getRequestDispatcher("account.jsp");
		rs.forward(request, response);
	}

}
