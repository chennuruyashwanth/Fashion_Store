package com.fashionStore.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import com.fashionStore.daoImpl.OrderDAOImpl;
import com.fashionStore.daoImpl.OrderItemDAOImpl;
import com.fashionStore.model.CartItem;
import com.fashionStore.model.Order;
import com.fashionStore.model.OrderItem;
import com.fashionStore.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/placeOrder")
public class PlaceOrderServlet extends HttpServlet {

    private OrderDAOImpl orderDAO;
    private OrderItemDAOImpl orderItemDAO;

    @Override
    public void init() throws ServletException {

        orderDAO = new OrderDAOImpl();
        orderItemDAO = new OrderItemDAOImpl();
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        User user = (User) session.getAttribute("loggedInUser");

        if (user == null) {

            response.sendRedirect("login.jsp");
            return;
        }

        List<CartItem> cartItems =
                (List<CartItem>) session.getAttribute("cartItems");

        if (cartItems == null || cartItems.isEmpty()) {

            response.sendRedirect("cart");
            return;
        }

        String paymentMethod =
                request.getParameter("paymentMethod");

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

        int orderId = orderDAO.addOrder(order);

        for (CartItem cartItem : cartItems) {

            OrderItem orderItem = new OrderItem();

            orderItem.setOrderId(orderId);
            orderItem.setProductId(cartItem.getProductId());
            orderItem.setQuantity(cartItem.getQuantity());
            orderItem.setPrice(cartItem.getPrice());
            orderItemDAO.addOrderItem(orderItem);
            System.out.println("Generated Order Id= "+orderId);
        }

        Order savedOrder = orderDAO.getOrder(orderId);

        List<OrderItem> orderItems =
                orderItemDAO.getOrderItemsByOrderId(orderId);

        request.setAttribute("order", savedOrder);
        request.setAttribute("orderItems", orderItems);

        response.sendRedirect(
                request.getContextPath()
                + "/orderConfirmation?orderId="
                + orderId);
    }
}