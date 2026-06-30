package com.fashionStore.controller;

import java.io.IOException;
import java.sql.Timestamp;

import com.fashionStore.daoImpl.UserDAOImpl;
import com.fashionStore.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private UserDAOImpl userDAO;

    @Override
    public void init() throws ServletException {
        userDAO = new UserDAOImpl();
    }

    // Open Registration Page
    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        request.getRequestDispatcher(
                "/WEB-INF/views/partials/register.jsp")
                .forward(request, response);
    }

    // Save User Data
    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String password = request.getParameter("password");
        String address = request.getParameter("address");
        String city = request.getParameter("city");
        String state = request.getParameter("state");
        String pincode = request.getParameter("pincode");
        String country = request.getParameter("country");
        
        Timestamp created_at = new Timestamp(System.currentTimeMillis());
        
        User user = new User(name, email, phone, password, address, city, state, pincode, country, created_at);

        int result = userDAO.addUser(user);
        
        
        if(result > 0) {

            response.sendRedirect(
                    request.getContextPath() + "/login");

        } else {

            request.setAttribute(
                    "error",
                    "Registration Failed!");

            request.getRequestDispatcher(
                    "/WEB-INF/views/partials/register.jsp")
                    .forward(request, response);
        }
    }
}