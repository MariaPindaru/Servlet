package controllers;

import database.dao.UserDao;
import database.model.UserEntity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Optional;

@WebServlet(name = "LoginServlet", urlPatterns = {"/", "/login"})
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        response.setContentType("text/html");
        if (username.isEmpty() || password.isEmpty()) {
            request.setAttribute("message", "Username and password are required. Please retry.");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
            return;
        }

        UserDao userDao = new UserDao();
        UserEntity user = userDao.getUser(username, password);

        if (user != null) {
            HttpSession session = request.getSession(true); // create session
            session.setAttribute("user", user);
            response.sendRedirect("/details");
        } else {
            request.setAttribute("message", "Unknown username/password. Please retry.");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/login.jsp").forward(request, response);
    }
}
