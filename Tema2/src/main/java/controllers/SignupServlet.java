package controllers;

import database.dao.UserDao;
import database.dao.UserDetailsDao;
import database.model.UserEntity;
import database.model.UserdetailsEntity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;

@WebServlet(name = "SignupServlet", urlPatterns = "/signup")
public class SignupServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDao userDao = new UserDao();
        UserDetailsDao userDetailsDao = new UserDetailsDao();
        String username = request.getParameter("username"), password = request.getParameter("password1");

        if (UsernameExists(userDao, username)) {
            request.setAttribute("message", "Username unavailable...");
            request.getRequestDispatcher("/signup.jsp").forward(request, response);
            return;
        }

        if (!password.equals(request.getParameter("password2"))) {
            request.setAttribute("message", "The passwords don't match! Try again...");
            request.getRequestDispatcher("/signup.jsp").forward(request, response);
            return;
        }

        if (password.isEmpty() || username.isEmpty()) {
            request.setAttribute("message", "Username and password are required. Please retry.");
            request.getRequestDispatcher("/signup.jsp").forward(request, response);
            return;
        }

        CreateUser(userDao, username, password);

        UserEntity user = userDao.getUser(username, password);

        if (user != null) {
            HttpSession session = request.getSession(true);
            session.setAttribute("user", user); // Login user.

            UserdetailsEntity details = new UserdetailsEntity();
            details.setUserId(user.getIdUser());
            details.setName(request.getParameter("name"));
            details.setAddress(request.getParameter("address"));
            details.setBirthdate(request.getParameter("birthdate").isEmpty() ? null : Date.valueOf(request.getParameter("birthdate")));
            userDetailsDao.create(details);

            response.sendRedirect("/details");
        } else {
            request.setAttribute("message", "An error occurred. Please try again later.");
            request.getRequestDispatcher("/signup.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession(false).invalidate();
        request.getRequestDispatcher("/signup.jsp").forward(request, response);
    }

    private void CreateUser(UserDao userDao, String username, String password) {
        UserEntity newUser = new UserEntity();
        newUser.setUsername(username);
        newUser.setPassword(password);
        userDao.create(newUser);
    }

    private boolean UsernameExists(UserDao userDao, String username){
        return userDao.getAll().stream().anyMatch(u -> u.getUsername().equals(username));
    }
}
