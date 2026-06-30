<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%@ page import="java.util.List" %>
<%@ page import="java.math.BigDecimal" %>
<%@ page import="com.fashionStore.model.CartItem" %>

	<%
	List<CartItem> cartItems =
	(List<CartItem>) request.getAttribute("cartItems");
	
	BigDecimal total = BigDecimal.ZERO;
	%>

<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>Shopping Cart</title>

<link rel="stylesheet" href="assets/css/styles.css">
<link rel="stylesheet" href="assets/css/navbar.css">
<link rel="stylesheet" href="assets/css/footer.css">
<link rel="stylesheet" href="assets/css/cart.css">

</head>
<body>

<jsp:include page="/WEB-INF/views/partials/navbar.jsp"/>

<div class="cart-container">

<h1>My Cart</h1>

<%
if(cartItems != null && !cartItems.isEmpty()){
%>

<table class="cart-table">

    <thead>

        <tr>
            <th>Image</th>
            <th>Product</th>
            <th>Brand</th>
            <th>Price</th>
            <th>Quantity</th>
            <th>Subtotal</th>
            <th>Actions</th>
        </tr>

    </thead>

    <tbody>

    <%
    for(CartItem item : cartItems){

        BigDecimal subtotal =
                item.getPrice().multiply(
                        new BigDecimal(item.getQuantity()));

        total = total.add(subtotal);
    %>

        <tr>

            <td>
                <img
                src="<%= item.getImagePath() %>"
                width="80"
                height="80"
                alt="Product">
            </td>

            <td>
                <%= item.getProductName() %>
            </td>

            <td>
                <%= item.getBrand() %>
            </td>

            <td>
                ₹ <%= item.getPrice() %>
            </td>

            <td>

                <form action="cart"
                      method="get">

                    <input type="hidden"
                           name="action"
                           value="update">

                    <input type="hidden"
                           name="cartId"
                           value="<%= item.getCartId() %>">

                    <input type="number"
                           name="quantity"
                           value="<%= item.getQuantity() %>"
                           min="1">

                    <button type="submit">
                        Update
                    </button>

                </form>

            </td>

            <td>
                ₹ <%= subtotal %>
            </td>

            <td>

                <a href="cart?action=remove&cartId=<%= item.getCartId() %>"
                   onclick="return confirm('Remove this item?')">

                    Remove

                </a>

            </td>

        </tr>

    <%
    }
    %>

    </tbody>

</table>

<div class="cart-summary">

    <h2>
        Total : ₹ <%= total %>
    </h2>

    <a href="cart?action=clear"
       class="clear-btn">

        Clear Cart

    </a>

    <a href="<%=request.getContextPath()%>/checkout">
	    Proceed To Checkout
	</a>
     <a href="products">
        Continue Shopping
    </a>

</div>

<%
}
else{
%>

    <h2>Your Cart Is Empty</h2>

    <a href="products">
        Continue Shopping
    </a>

<%
}
%>

</div>

<jsp:include page="/WEB-INF/views/partials/footer.jsp"/>

</body>
</html>
