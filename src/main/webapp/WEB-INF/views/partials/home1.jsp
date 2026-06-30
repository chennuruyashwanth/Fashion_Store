<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.List" %>
<%@ page import="com.fashionStore.model.Category" %>
<%@ page import="com.fashionStore.model.Product" %>

<%
List<Category> categories =
        (List<Category>) request.getAttribute("categories");

List<Product> products =
        (List<Product>) request.getAttribute("products");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Fashion Store</title>

<link rel="stylesheet" href="assets/css/styles.css">
<link rel="stylesheet" href="assets/css/navbar.css">
<link rel="stylesheet" href="assets/css/footer.css">
<link rel="stylesheet" href="assets/css/home.css">
</head>
<body>

<jsp:include page="/WEB-INF/views/partials/navbar.jsp"/>

<main>

    <!-- HERO SECTION -->

    <section class="hero">

        <div class="hero-content">

            <h1>Discover Your Fashion Style</h1>

            <p>
                Explore the latest fashion trends and elevate
                your wardrobe with premium collections.
            </p>

            <div class="hero-buttons">

                <a href="products" class="btn btn-primary">
                    Shop Now
                </a>

                <a href="products" class="btn btn-secondary">
                    Explore
                </a>

            </div>

        </div>

        <div class="hero-image">

            <img
                src="/fashionStore/assets/images/fashion banner.png"
                alt="Fashion Banner">

        </div>

    </section>

    <!-- CATEGORY SECTION -->

    <section class="categories container">

        <div class="section-title">

            <h2>Shop By Category</h2>

            <p>Find your favourite fashion category.</p>

        </div>

        <div class="category-grid">

            <%
            if(categories != null && !categories.isEmpty()){
                for(Category category : categories){
            %>

                <div class="category-card">

                    <h3>
                        <%= category.getCategoryName() %>
                    </h3>

                </div>

            <%
                }
            } else {
            %>

                <h3>No Categories Found</h3>

            <%
            }
            %>

        </div>

    </section>

    <!-- PRODUCT SECTION -->

    <section class="featured-products container">

        <div class="section-title">

            <h2>Featured Products</h2>

            <p>Trending products for you.</p>

        </div>

       <div class="product-grid">

			<%
			if(products != null && !products.isEmpty()){
			    for(Product product : products){
			%>
			
			    <div class="product-card">
			
			        <div class="product-image">
			            <img src="<%= product.getImagePath() %>"
			                 alt="<%= product.getName() %>">
			        </div>
			
			        <div class="product-info">
			
			            <h3><%= product.getName() %></h3>
			
			            <p class="brand">
			                <%= product.getBrand() %>
			            </p>
			
			            <p class="product-price">
			                ₹ <%= product.getPrice() %>
			            </p>
			
			            <a href="product-details?id=<%= product.getProductId() %>"
			               class="view-btn">
			               View Details
			            </a>

		        </div>
		
		    </div>
		
		<%
		    }
		}
		%>
		
		</div>

    </section>

</main>

<jsp:include page="/WEB-INF/views/partials/footer.jsp"/>

</body>
</html>