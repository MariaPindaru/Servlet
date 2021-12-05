package controllers;

import database.dao.UserDao;
import database.dao.UserDetailsDao;
import database.model.UserEntity;
import database.model.UserdetailsEntity;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@WebServlet(name = "DetailsServlet", urlPatterns = "/details")
public class DetailsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        UserEntity user = UserEntity.class.cast(request.getSession().getAttribute("user"));

        UserDetailsDao userDetailsDao = new UserDetailsDao();
        UserdetailsEntity details = userDetailsDao.get(user.getIdUser());
        details.setName(request.getParameter("name"));
        details.setAddress(request.getParameter("address"));
        details.setBirthdate(request.getParameter("birthdate").isEmpty() ? null : Date.valueOf(request.getParameter("birthdate")));
        userDetailsDao.update(details);

        request.setAttribute("username", user.getUsername());
        setDetailsAttributes(request, response, details);

        request.getRequestDispatcher("/details.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if(request.getSession(false).getAttribute("user") == null) {
            response.sendRedirect("/");
            return;
        }

        UserEntity user = UserEntity.class.cast(request.getSession().getAttribute("user"));
        request.setAttribute("username", user.getUsername());

        UserDetailsDao userDetailsDao = new UserDetailsDao();
        UserdetailsEntity details = userDetailsDao.get(user.getIdUser());
        setDetailsAttributes(request, response, details);

        request.getRequestDispatcher("/details.jsp").forward(request,response);
    }

    private void setDetailsAttributes(HttpServletRequest request, HttpServletResponse response, UserdetailsEntity details) throws ServletException, IOException {
        request.setAttribute("name", details.getName());
        request.setAttribute("address", details.getAddress());
        request.setAttribute("birthdate", details.getBirthdate() == null ? "" : details.getBirthdate().toString());
    }

}
