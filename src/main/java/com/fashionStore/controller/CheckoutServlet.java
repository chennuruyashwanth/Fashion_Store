package com.fashionStore.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import com.fashionStore.daoImpl.CartItemDAOImpl;
import com.fashionStore.daoImpl.OrderDAOImpl;
import com.fashionStore.model.CartItem;
import com.fashionStore.model.Order;
import com.fashionStore.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/checkout")
public class CheckoutServlet extends HttpServlet {

    private CartItemDAOImpl cartDAO;
    private OrderDAOImpl orderDAO;

    @Override
    public void init() throws ServletException {

        cartDAO = new CartItemDAOImpl();
        orderDAO = new OrderDAOImpl();
    }
    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);

        if(session == null ||
           session.getAttribute("loggedInUser") == null) {

            response.sendRedirect("login");
            return;
        }

        User user =
                (User) session.getAttribute("loggedInUser");

        List<CartItem> cartItems =
                cartDAO.getCartItemsByUser(user.getUserId());

        BigDecimal totalAmount = BigDecimal.ZERO;

        for(CartItem item : cartItems) {

            totalAmount =
                    totalAmount.add(item.getSubTotal());
        }

        request.setAttribute("cartItems", cartItems);
        request.setAttribute("totalAmount", totalAmount);

        request.getRequestDispatcher(
                "/WEB-INF/views/partials/checkout.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);

        if (session == null ||
            session.getAttribute("loggedInUser") == null) {

            response.sendRedirect("login");
            return;
        }

        User user =
                (User) session.getAttribute("loggedInUser");

        String paymentMethod =
                request.getParameter("paymentMethod");

        List<CartItem> cartItems =
                cartDAO.getCartItemsByUser(user.getUserId());

        BigDecimal totalAmount = BigDecimal.ZERO;

        for (CartItem item : cartItems) {

            totalAmount =
                    totalAmount.add(item.getSubTotal());
        }

        Order order = new Order();

        order.setUserId(user.getUserId());
        order.setTotalAmount(totalAmount);
        order.setPaymentMode(paymentMethod);
        order.setStatus("PLACED");
        order.getOrderDate();

        int orderId = orderDAO.addOrder(order);

        if (orderId > 0) {

        	Order placedOrder =
        	        orderDAO.getOrder(orderId);

        	request.setAttribute(
        	        "order",
        	        placedOrder);
        	
            cartDAO.clearCart(user.getUserId());

            System.out.println("Order Date = " +
                    order.getOrderDate());
            
            request.getRequestDispatcher(
                    "/WEB-INF/views/partials/orderConfirmation.jsp")
                    .forward(request, response);

        } else {

            response.getWriter().println(
                    "Failed To Place Order");
        }
    }
}