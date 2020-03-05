package com.serv.form;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.utility.ConnectionDatabase;

/**
 * Servlet implementation class regserv
 */
@WebServlet("/regserv")
public class regserv extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public regserv() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		PreparedStatement ps=null;
		String name=request.getParameter("name");
		String add=request.getParameter("add");
		String pass=request.getParameter("pass2");
		try{
			Connection con=(Connection) ConnectionDatabase.getConnection();		
			 ps= (PreparedStatement) con.prepareStatement("insert into userlogin(name,address,password)values(?,?,?)");
           ps.setString(1, name);
			
			ps.setString(2, add);
			ps.setString(3, pass);
			int i=ps.executeUpdate();
			if(i!=0){
				System.out.println("added successfully");
			}else{
				System.out.println("not added successfully");
			}
		}catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try{
				ps.close();
				
			}catch(SQLException e){
				e.printStackTrace();
			}}
		RequestDispatcher rd=request.getRequestDispatcher("RegSuccess.jsp");
		rd.forward(request,response);
	}
	
	
	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
