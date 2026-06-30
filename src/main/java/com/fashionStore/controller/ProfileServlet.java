package com.fashionStore.controller;

import java.io.IOException;
import java.util.List;

import com.fashionStore.daoImpl.OrderDAOImpl;
import com.fashionStore.model.Order;
import com.fashionStore.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private OrderDAOImpl orderDAO;

    @Override
    public void init() throws ServletException {

        orderDAO = new OrderDAOImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session =
                request.getSession(false);

        if(session == null ||
           session.getAttribute("loggedInUser") == null) {

            response.sendRedirect(
                    request.getContextPath() + "/login");
            return;
        }

        User user =
                (User) session.getAttribute("loggedInUser");

        List<Order> orders =
                orderDAO.getOrdersByUserId(
                        user.getUserId());

        request.setAttribute("user", user);
        request.setAttribute("orders", orders);

        request.getRequestDispatcher(
                "/WEB-INF/views/partials/profile.jsp")
                .forward(request, response);
    }
}