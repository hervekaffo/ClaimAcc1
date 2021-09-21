package com.servelet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import com.user.Student;

/**
 * Servlet implementation class GpaServlet
 */
@WebServlet("/GpaServlet")
public class GpaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GpaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String grade1 = request.getParameter("gradeOne");
		String grade2 = request.getParameter("gradeTwo");
		String grade3 = request.getParameter("gradeThree");
		int credit = 12;
		double gpa =((Double.parseDouble(grade1)*credit)+
	                                  (Double.parseDouble(grade2)*credit)+
	                      (Double.parseDouble(grade3)*credit) )/36;
		//Get the student Object from the session and update the GPA :
		HttpSession session = request.getSession(true);
		Student student = (Student)session.getAttribute("student");
			student.setGpa(gpa);
			
		//Add the updated student value to the session object and for the user to the account page:
			session.setAttribute("student", student);
			RequestDispatcher rs = request.getRequestDispatcher("account.jsp");
				  rs.forward(request,response);
			
			
	

	}
	


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
