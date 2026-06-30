package com.fashionStore.controller;

import java.io.IOException;
import java.util.List;

import com.fashionStore.daoImpl.OrderDAOImpl;
import com.fashionStore.daoImpl.OrderItemDAOImpl;
import com.fashionStore.model.Order;
import com.fashionStore.model.OrderItem;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/orderConfirmation")
public class OrderConfirmationServlet extends HttpServlet {

    private OrderDAOImpl orderDAO;
    private OrderItemDAOImpl orderItemDAO;

    @Override
    public void init() {

        orderDAO = new OrderDAOImpl();
        orderItemDAO = new OrderItemDAOImpl();
    }

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        int orderId =
                Integer.parseInt(
                        request.getParameter("orderId"));

        Order order =
                orderDAO.getOrder(orderId);

        List<OrderItem> orderItems =
                orderItemDAO.getOrderItemsByOrderId(orderId);

        request.setAttribute("order", order);
        request.setAttribute("orderItems", orderItems);

        request.getRequestDispatcher(
                "/WEB-INF/views/partials/orderConfirmation.jsp")
               .forward(request, response);
    }
}