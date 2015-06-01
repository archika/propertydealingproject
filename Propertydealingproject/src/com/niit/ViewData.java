package com.niit;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.DbAction;

/**
 * Servlet implementation class ViewData
 */
@WebServlet("/viewdata")
public class ViewData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewData() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
    	PrintWriter out=response.getWriter();
    	out.println("<body>");
    	out.println("<a href='Customerregistration.html'>Insert New Record</a>");
    	ResultSet rs=DbAction.getCustomerData();
    	out.println("<table border='1'><tr><th>CUSTNAME</th><th>MOBILENO</th><th>EMAILID</th><th>DOB</th><th>GENDER</th><th>OCCUPATION</th><th>ADDRESS</th><tr>");
    	try{
	    	while(rs.next()){
	    		out.println("<tr>");
	    		out.println("<td>"+rs.getString(2)+"</td>");
	    		out.println("<td>"+rs.getString(3)+"</td>");
	    		out.println("<td>"+rs.getString(4)+"</td>");
	    		out.println("<td>"+rs.getString(5)+"</td>");
	    		out.println("<td>"+rs.getString(6)+"</td>");
	    		out.println("<td>"+rs.getString(7)+"</td>");
	    		out.println("<td>"+rs.getString(8)+"</td>");
	    		out.println("<td><a href='#'>Edit</a> / <a href='delete?id="+rs.getString(1)+"'>Delete</a></td>");
	    		out.println("</tr>");
	    	}
    	}
    	catch(Exception ex){
    		
    	}
    	out.println("</table>");
    	out.println("</body>");
    	
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
 