package sangt6vd1;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns= {"/login"})
public class DeleteCookie extends HttpServlet {
	 @Override
	 protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		resp.setContentType("text/html");

		Cookie cookie = null;
		Cookie[] cookies = null;
		// Get an array of Cookies associated with this domain
		cookies = req.getCookies();
		// Set response content type
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		if (cookies != null) {
			out.println("<h2> Cookies Name and Value</h2>");
			for (int i = 0; i < cookies.length; i++) {
				cookie = cookies[i];
				if ((cookie.getName()).compareTo("ten") == 0) {
					// delete cookie
					cookie.setMaxAge(0);
					resp.addCookie(cookie);
					out.print("Deleted cookie : " + cookie.getName() + "<br/>");
				}
				out.print("Name : " + cookie.getName() + ",  ");
				out.print("Value: " + cookie.getValue() + " <br/>");
			}
		}
		out.close();
	 }
}
