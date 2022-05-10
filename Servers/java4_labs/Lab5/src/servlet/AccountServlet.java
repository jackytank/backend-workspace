package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import dao.UserDAO;
import model.User;

@WebServlet({ "/account/sign-in", "/account/sign-up", "/account/sign-out", "/account/forgot-password",
		"/account/change-password", "/account/edit-profile" })
public class AccountServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String URI = req.getRequestURI();
		if (URI.contains("sign-in")) {
			doSignin(req, resp);
		} else if (URI.contains("sign-up")) {
			doSignup(req, resp);
		} else if (URI.contains("sign-out")) {

		} else if (URI.contains("forgot-password")) {

		} else if (URI.contains("change-password")) {

		} else if (URI.contains("edit-profile")) {
			doEditProfile(req, resp);
		}
	}

	private void doSignin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String method = req.getMethod();
		if (method.equalsIgnoreCase("POST")) {
			String id = req.getParameter("username");
			String pw = req.getParameter("password");
			try {
				UserDAO dao = new UserDAO();
				User user = dao.findByID(id);
				if (!user.getPassword().equals(pw)) {
					req.setAttribute("message", "Wrong password!");
				} else {
					req.setAttribute("message", "Signin success!");
				}
			} catch (Exception e) {
				e.printStackTrace();
				req.setAttribute("message", "Error: " + e.getMessage());
			}
		}
		req.getRequestDispatcher("/views/Bai4/sign-in.jsp").forward(req, resp);

	}

	private void doSignup(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String method = req.getMethod();
		if (method.equalsIgnoreCase("POST")) {
			try {
				User entity = new User();
				BeanUtils.populate(entity, req.getParameterMap());
				UserDAO dao = new UserDAO();
				dao.insert(entity);
				req.setAttribute("message", "Signup Success!");
			} catch (Exception e) {
				e.printStackTrace();
				req.setAttribute("message", "Error: " + e.getMessage());
			}
		}
		req.getRequestDispatcher("/views/Bai4/sign-up.jsp").forward(req, resp);

	}

	private void doEditProfile(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String method = req.getMethod();
		if (method.equalsIgnoreCase("POST")) {
			try {
				User entity = new User();
				UserDAO dao = new UserDAO();
				BeanUtils.populate(entity, req.getParameterMap());
				dao.update(entity);
				req.setAttribute("message", "Update success");
			} catch (Exception e) {
				e.printStackTrace();
				req.setAttribute("message", "Error: " + e.getMessage());
			}
		}
		req.getRequestDispatcher("/views/Bai4/edit-profile.jsp").forward(req, resp);

	}

}
