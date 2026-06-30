<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.List"%>
<%@ page import="java.math.BigDecimal"%>
<%@ page import="com.fashionStore.model.CartItem"%>
<%@ page import="com.fashionStore.model.User"%>

<%
User user = (User)session.getAttribute("loggedInUser");

List<CartItem> cartItems =
        (List<CartItem>)request.getAttribute("cartItems");

BigDecimal totalAmount =
        (BigDecimal)request.getAttribute("totalAmount");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Checkout</title>

<link rel="stylesheet"
href="<%=request.getContextPath()%>/assets/css/checkout.css">

</head>

<body>

<div class="logo">
        <a href="">FashionStore</a>
    </div>

<div class="checkout-page">

    <!-- LEFT SIDE -->
    <div class="delivery-card">

        <h2>Delivery Details</h2>

        <form action="checkout" method="post">

            <label>Full Name</label>
            <input type="text"
                   name="name"
                   value="<%= user!=null ? user.getName() : "" %>">

            <label>Phone</label>
            <input type="text"
                   name="phone"
                   value="<%= user!=null ? user.getPhone() : "" %>">

            <label>Address</label>
            <input type="text"
                   name="address"
                   value="<%= user!=null ? user.getAddress() : "" %>">

            <div class="row">

                <div class="field">
                    <label>City</label>
                    <input type="text"
                           name="city"
                           value="<%= user!=null ? user.getCity() : "" %>">
                </div>

                <div class="field">
                    <label>State</label>
                    <input type="text"
                           name="state"
                           value="<%= user!=null ? user.getState() : "" %>">
                </div>

            </div>

            <div class="row">

                <div class="field">
                    <label>Pincode</label>
                    <input type="text"
                           name="pincode"
                           value="<%= user!=null ? user.getPincode() : "" %>">
                </div>

                <div class="field">
                    <label>Country</label>
                    <input type="text"
                           name="country"
                           value="<%= user!=null ? user.getCountry() : "" %>">
                </div>

            </div>

            <label>Payment Method</label>

            <div class="payment-option">
                <input type="radio"
                       name="paymentMethod"
                       value="Cash On Delivery"
                       checked>
                Cash On Delivery
            </div>

            <div class="payment-option">
                <input type="radio"
                       name="paymentMethod"
                       value="UPI">
                UPI
            </div>

            <div class="payment-option">
                <input type="radio"
                       name="paymentMethod"
                       value="Card">
                Card
            </div>

            <button type="submit" class="place-order-btn">
                Place Order
            </button>

        </form>

    </div>

    <!-- RIGHT SIDE -->
    <div class="summary-card">

        <h2>Order Summary</h2>

        <%
        if(cartItems!=null){
            for(CartItem item : cartItems){
        %>

        <div class="product-item">

            <div>
                <h4><%= item.getProductName() %></h4>
                Qty : <%= item.getQuantity() %>
            </div>

            <span>
                ₹ <%= item.getSubTotal() %>
            </span>

        </div>

        <%
            }
        }
        %>

        <hr>

        <div class="total">
            Total Amount
            <span>₹ <%= totalAmount %></span>
        </div>

    </div>

</div>

 <div class="logo1">
        <a href="cart">Return To Cart</a>
    </div>

</body>
</html>