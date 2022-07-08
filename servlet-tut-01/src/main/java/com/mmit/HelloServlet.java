package com.mmit;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public HelloServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//hello?name-aung&pass=123
		String name = request.getParameter("uname");
		var pass = request.getParameter("upass");
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		out.println("<br>Name -> " + name);
		out.println("<br>Password -> " + pass);
		out.println("<br>Current date -> " + LocalDate.now());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
