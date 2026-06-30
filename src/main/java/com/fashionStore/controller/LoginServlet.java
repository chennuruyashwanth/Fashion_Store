package com.fashionStore.controller;

import java.io.IOException;

import com.fashionStore.daoImpl.UserDAOImpl;
import com.fashionStore.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private UserDAOImpl userDAOImpl;

    @Override
    public void init() throws ServletException {

        userDAOImpl = new UserDAOImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        request.getRequestDispatcher(
                "/WEB-INF/views/partials/login.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        User user = userDAOImpl.validateUser(email, password);

        if (user != null) {

            System.out.println("Login Success");
            System.out.println("User ID : " + user.getUserId());

            HttpSession session = request.getSession();
            session.setAttribute("loggedInUser", user);

            response.sendRedirect(
                    request.getContextPath() + "/home");

        } else {

            System.out.println("Login Failed");

            request.setAttribute(
                    "error",
                    "Invalid Email or Password");

            request.getRequestDispatcher(
                    "/WEB-INF/views/partials/login.jsp")
                    .forward(request, response);
        }
    }
}