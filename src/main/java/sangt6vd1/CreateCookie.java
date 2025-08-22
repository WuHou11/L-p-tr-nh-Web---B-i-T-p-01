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

public class CreateCookie extends HttpServlet {
	 @Override
	 protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
			resp.setContentType("text/html");

	        String ten = req.getParameter("ten");
	        String holot = req.getParameter("holot");

            Cookie firstName = new Cookie("ten", ten);
            Cookie lastName = new Cookie("holot", holot);

            firstName.setMaxAge(60 * 60 * 24);
            lastName.setMaxAge(60 * 60 * 24);

            resp.addCookie(firstName);
            resp.addCookie(lastName);
            PrintWriter out = resp.getWriter();
            
            out.println("<b>First Name</b>: " + firstName.getValue() + " - <b>Last Name</b>: " + lastName.getValue());

        out.close();
	 }
}
