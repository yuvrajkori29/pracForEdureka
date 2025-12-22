package com.acceptform;
import java.io.PrintWriter;
import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;


public class message extends HttpServlet{
   public void service(HttpServletRequest req,HttpServletResponse res) throws IOException{
	    String n = req.getParameter("name");
	    
	    PrintWriter out  = res.getWriter();
	    System.out.println(n);
	    out.print("hello" + n);
	    
   }
}
