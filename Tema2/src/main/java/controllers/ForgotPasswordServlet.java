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

@WebServlet(name = "ForgotPassword", urlPatterns = "/forgotPassword")
public class ForgotPasswordServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDao userDao = new UserDao();
        String username = request.getParameter("username");

        if (userDao.getUser(username) != null) {
            request.setAttribute("username", username);
            request.getRequestDispatcher("/forgotPassword.jsp").forward(request, response);
        }
        else{
            request.setAttribute("message", "Unknown username. Please retry.");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("/");
    }
}
