package com.booksystem.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.booksystem.bean.User;
import com.booksystem.service.*;

import org.springframework.beans.factory.annotation.Autowired;

@WebServlet(urlPatterns = "/signin")
public class SignInServlet extends HttpServlet {

	final Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private UserService userService;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();
		pw.write("<h1>Sign in</h1>");
		pw.write("<form action=\"/signin\" method=\"post\">");
		pw.write("<p>Username: <input name=\"username\"></p>");
		pw.write("<p>Password: <input name=\"password\" type=\"password\"></p>");
		pw.write("<p><button type=\"submit\">Sign in</button> <a href=\"/register\">Register</a></p>");
		pw.write("</form>");
		pw.flush();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("username");
		String password = req.getParameter("password");

		User user = userService.findByName(name);
		if (user == null) {
			this.doGet(req, resp);
			return;
		}

		if (!password.equals(user.getPassWord())) {
			this.doGet(req, resp);
			return;
		}

		Cookie cookie = new Cookie("name", name);
		resp.addCookie(cookie);
		resp.sendRedirect("/swagger-ui.html");
	}
}
