package com.serv.form;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.utility.ConnectionDatabase;

/**
 * Servlet implementation class Serv1
 */
@WebServlet("/Serv1")
public class Serv1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Serv1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		Connection con=null;
		Statement st=null;
		//Statement st=null;
		int flag=0;
		String username=request.getParameter("name");
		String password=request.getParameter("pass");
		try {
			con=ConnectionDatabase.getConnection();
			 st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from userlogin");
			while(rs.next()){
				if(rs.getString(2).equalsIgnoreCase(username)&&rs.getString(4).equals(password)){
					flag=1;
					break;
				}
			}
			if(flag==1){
				HttpSession session=request.getSession();
				session.setAttribute("uname",username );
			response.sendRedirect("success.jsp");
		//	rd.forward(request,response);
			}
			else{
				RequestDispatcher rd=request.getRequestDispatcher("failure.jsp");
				rd.forward(request, response);
			}

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try{
				st.close();
				
			}catch(SQLException e){
				e.printStackTrace();
			}}
	}
	

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
