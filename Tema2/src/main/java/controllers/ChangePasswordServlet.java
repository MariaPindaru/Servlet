package controllers;

import database.dao.UserDao;
import database.model.UserEntity;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Optional;

@WebServlet(name = "ChangePasswordServlet", value = "/changePassword")
public class ChangePasswordServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDao userDao = new UserDao();

        String username = request.getParameter("username"), password = request.getParameter("password1");
        request.setAttribute("username", username);

        if(!password.equals(request.getParameter("password2"))){
            request.setAttribute("message", "The passwords  don't match. Please retry.");
            request.getRequestDispatcher("/forgotPassword.jsp").forward(request, response);
            return;
        }

        if(password.isEmpty()){
            request.setAttribute("message", "Invalid password. Please retry.");
            request.getRequestDispatcher("/forgotPassword.jsp").forward(request, response);
            return;
        }

        Optional<UserEntity> user = null;
        try {
            user = userDao.getAll().stream().filter(u -> u.getUsername().equals(username)).findAny();
        } catch (Exception e) {
            System.out.println(e);
        }

        user.get().setPassword(password);
        userDao.update(user.get());

        request.getSession().setAttribute("user", user);
        response.sendRedirect("/details");
    }
}
