package vn.demo;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/2","/home","/trang chu"} )

public class CreateCookie extends HttpServlet {
	 @Override
	    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	        response.setContentType("text/html;charset=UTF-8");
	        PrintWriter out = response.getWriter();

	        String ten = request.getParameter("ten");
	        String holot = request.getParameter("holot");

	        if (ten != null && holot != null) {
	            Cookie firstName = new Cookie("ten", ten);
	            Cookie lastName = new Cookie("holot", holot);

	            firstName.setMaxAge(60 * 60 * 24); 
	            lastName.setMaxAge(60 * 60 * 24);

	            response.addCookie(firstName);
	            response.addCookie(lastName);

	            out.println("<b>First Name</b>: " + firstName.getValue()
	                    + " - <b>Last Name</b>: " + lastName.getValue() + "<br/>");
	        }
	        Cookie[] cookies = request.getCookies();
	        if (cookies != null) {
	            out.println("<h2>Danh sách Cookies:</h2>");
	            for (Cookie cookie : cookies) {
	                out.print("Name: " + cookie.getName() + ", ");
	                out.print("Value: " + cookie.getValue() + "<br/>");
	            }
	        } else {
	            out.println("<h2>Không tìm thấy cookie nào</h2>");
	        }

	        if (cookies != null) {
	            for (Cookie cookie : cookies) {
	                if ("ten".equals(cookie.getName())) {
	                    cookie.setMaxAge(0); 
	                    response.addCookie(cookie);
	                    out.print("<br/>Đã xóa cookie: " + cookie.getName() + "<br/>");
	                }
	            }
	        }

	        out.close();
	    }
	 
}
