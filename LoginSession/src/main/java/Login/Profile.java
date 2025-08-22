package Login;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/Profile")
public class Profile extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(false);

		response.setContentType("text/html");
		if (session != null && session.getAttribute("user") != null) {
			String user = (String) session.getAttribute("user");
			response.getWriter().println("<h2>Welcome, " + user + "!</h2>");
			response.getWriter().println("<a href='Logout'>Logout</a>");
		} else {
			response.getWriter().println("<h3 style='color:red'>Access denied. Please login first!</h3>");
			response.getWriter().println("<a href='login.html'>Login</a>");
		}
	}
}
