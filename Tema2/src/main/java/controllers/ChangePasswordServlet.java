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
        String username = request.getParameter("username");

        if(username == null){
            response.sendRedirect("/login");
            return;
        }

        UserDao userDao = new UserDao();

        Optional<UserEntity> user = null;
        try {
            user = userDao.getAll().stream().filter(u -> u.getUsername().equals(username)).findAny();
        } catch (Exception e) {
            System.out.println(e);
        }
        if (user.isPresent()) {
            HttpSession session = request.getSession(true);
            session.setAttribute("user", user.get());

            request.setAttribute("username", user.get().getUsername());

            RequestDispatcher rd = request.getRequestDispatcher("/forgotPassword.jsp");
            rd.forward(request, response);

            response.sendRedirect("/changePassword");
        }
        else{
            request.setAttribute("message", "Unknown username. Please retry.");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDao userDao = new UserDao();

        UserEntity user = UserEntity.class.cast(request.getSession().getAttribute("user"));
        String username = user.getUsername(), password = request.getParameter("password1");
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

        user.setPassword(password);
        userDao.update(user);

        request.getSession().setAttribute("user", user);
        response.sendRedirect("/details");
    }
}
