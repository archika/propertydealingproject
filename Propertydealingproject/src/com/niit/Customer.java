package com.niit;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.DbAction;

/**
 * Servlet implementation class Customer
 */
@WebServlet("/customer")
public class Customer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Customer() {
        super();
        // TODO Auto-generated constructor stub
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
    	PrintWriter out=response.getWriter();
     	String custname=request.getParameter("custname");
     	String mobileno=request.getParameter("mobileno");
     	String emailid=request.getParameter("emailid");
     	String dob=request.getParameter("dob");
     	String gender=request.getParameter("gender");
     	String occupation=request.getParameter("occupation");
     	String address=request.getParameter("address");
     	if(DbAction.authUser(custname,mobileno,emailid,dob,gender,occupation,address)){
    		RequestDispatcher rd=request.getRequestDispatcher("viewdata");
    		rd.include(request, response);
    	}
    	else
    	{
    		out.print("<h1>Hello</h1>");
    		RequestDispatcher rd=request.getRequestDispatcher("Customerregistration.html");
    		rd.include(request, response);
    	}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

}
