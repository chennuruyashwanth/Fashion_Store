<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.List" %>
<%@ page import="com.fashionStore.model.Order" %>
<%@ page import="com.fashionStore.model.OrderItem" %>

<%
Order order = (Order) request.getAttribute("order");

List<OrderItem> orderItems =
        (List<OrderItem>) request.getAttribute("orderItems");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Order Confirmation</title>

<link rel="stylesheet"
      href="<%=request.getContextPath()%>/assets/css/styles.css">

<link rel="stylesheet"
      href="<%=request.getContextPath()%>/assets/css/navbar.css">

<link rel="stylesheet"
      href="<%=request.getContextPath()%>/assets/css/footer.css">

<link rel="stylesheet"
      href="<%=request.getContextPath()%>/assets/css/orderConfirmation.css">

</head>
<body>

<jsp:include page="/WEB-INF/views/partials/navbar.jsp"/>

<div class="confirmation-container">

    <div class="confirmation-card">

        <div class="success-section">

            <div class="success-icon">
                ✓
            </div>

            <h1>Order Placed Successfully!</h1>

            <p>
                Thank you for shopping with FashionStore.
            </p>

        </div>

        <div class="order-details">

            <div class="detail-box">
                <h3>Order ID</h3>
                <p>#<%= order.getOrderId() %></p>
            </div>

            <div class="detail-box">
                <h3>Order Date</h3>
                <p><%= order.getOrderDate() %></p>
            </div>

            <div class="detail-box">
                <h3>Payment Method</h3>
                <p><%= order.getPaymentMode() %></p>
            </div>

            <div class="detail-box">
                <h3>Status</h3>
                <p><%= order.getStatus() %></p>
            </div>

        </div>

        <div class="ordered-products">

            <h2>Ordered Products</h2>

            <%
            if(orderItems != null && !orderItems.isEmpty()){

                for(OrderItem item : orderItems){
            %>

            <div class="product-row">

                <div>
                    Product ID :
                    <strong><%= item.getProductId() %></strong>
                </div>

                <div>
                    Qty :
                    <%= item.getQuantity() %>
                </div>

                <div>
                    ₹ <%= item.getPrice() %>
                </div>

            </div>

            <%
                }
            }
            %>

        </div>

        <div class="total-section">

            Total Amount :
            ₹ <%= order.getTotalAmount() %>

        </div>

        <div class="button-section">

            <a href="<%=request.getContextPath()%>/products"
               class="continue-btn">

                Continue Shopping

            </a>

        </div>

    </div>

</div>

<jsp:include page="/WEB-INF/views/partials/footer.jsp"/>

</body>
</html>