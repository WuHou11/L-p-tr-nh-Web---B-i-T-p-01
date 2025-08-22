package vn.demo;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/2","/home","/trang chu"} )
public class HomeControl extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		resp.setContentType("text/html");
		
		String name = req.getParameter("ten");
		String lastname = req.getParameter("ho");
		
		PrintWriter out = resp.getWriter();
		
		out.print("Hello " + lastname + " " + name);
		out.close();
		
	}

}
