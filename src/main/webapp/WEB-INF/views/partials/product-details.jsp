<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="com.fashionStore.model.Product" %>

<%
Product product = (Product) request.getAttribute("product");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product Details</title>

<link rel="stylesheet" href="assets/css/styles.css">
<link rel="stylesheet" href="assets/css/navbar.css">
<link rel="stylesheet" href="assets/css/footer.css">
<link rel="stylesheet" href="assets/css/product-details.css">

</head>
<body>

<jsp:include page="/WEB-INF/views/partials/navbar.jsp"/>

<%
if(product != null){
%>

<div class="product-container">

    <div class="product-image">

      <img src="<%= product.getImagePath() %>"
     alt="<%= product.getName() %>">

    </div>

    <div class="product-info">

        <h1><%= product.getName() %></h1>

        <p class="brand">
            Brand: <%= product.getBrand() %>
        </p>

        <p class="price">
            ₹ <%= product.getPrice() %>
        </p>

        <p class="size">
            Size: <%= product.getSize() %>
        </p>

        <p class="stock">
            Available Stock:
            <%= product.getStock() %>
        </p>

        <p class="description">
            <%= product.getDescription() %>
        </p>

        <div class="product-actions">

           <form action="cart" method="post">

			    <input type="hidden"
			           name="action"
			           value="add">
			
			    <input type="hidden"
			           name="productId"
			           value="<%= product.getProductId() %>">
			
			    <label>Select Size</label>
			
			    <select name="size" required>
			        <option value="">Choose Size</option>
			        <option value="S">Small</option>
			        <option value="M">Medium</option>
			        <option value="L">Large</option>
			        <option value="XL">Extra Large</option>
			    </select>
			
			    <button type="submit" class="btn">
			        Add To Cart
			    </button>
			
			</form>

            <a href="products"
               class="btn secondary-btn">
                Continue Shopping
            </a>

        </div>

    </div>

</div>

<%
}
else{
%>

<h2 class="not-found">
    Product Not Found
</h2>

<%
}
%>

<jsp:include page="/WEB-INF/views/partials/footer.jsp"/>

</body>
</html>