package com.exe.emp;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/SaveServlet") 
public class SaveServlet extends HttpServlet {
	 protected void doPost(HttpServletRequest request, HttpServletResponse response)   
	         throws ServletException, IOException {  
	        response.setContentType("text/html");  
	        PrintWriter out=response.getWriter();  
	        String Id=request.getParameter("id"); 
	        String Name=request.getParameter("name");  
	        String Password=request.getParameter("password");  
	        String Email=request.getParameter("email");  
	        String Country=request.getParameter("country");  
	         Random r=new Random(); 
	        Emp e=new Emp();  
	        e.setId(r.nextInt(100));
	        e.setName(Name);  
	        e.setPassword(Password);  
	        e.setEmail(Email);  
	        e.setCountry(Country);  
	          
	        int status=EmpDao.save(e);  
	        if(status>0){  
	            out.print("<p>Record saved successfully!</p>");  
	            request.getRequestDispatcher("index.html").include(request, response);  
	        }else{  
	            out.println("Sorry! unable to save record");  
	        }  
	          
	        out.close();  
	    } 

}
