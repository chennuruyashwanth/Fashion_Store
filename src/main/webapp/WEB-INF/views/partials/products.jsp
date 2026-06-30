<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.List" %>
<%@ page import="com.fashionStore.model.Product" %>
<%@ page import="com.fashionStore.model.Category" %>

<%
List<Product> products =
        (List<Product>) request.getAttribute("products");

List<Category> categories =
        (List<Category>) request.getAttribute("categories");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Shop Products</title>

<link rel="stylesheet" href="assets/css/styles.css">
<link rel="stylesheet" href="assets/css/navbar.css">
<link rel="stylesheet" href="assets/css/footer.css">
<link rel="stylesheet" href="assets/css/products.css">

</head>
<script>

function toggleFilters() {

    var filterSection =
        document.getElementById("filterSection");

    if (filterSection.style.display === "none" ||
        filterSection.style.display === "") {

        filterSection.style.display = "block";

    } else {

        filterSection.style.display = "none";
    }
}

</script>
<body>

    <jsp:include page="/WEB-INF/views/partials/navbar.jsp"/>

    <main class="products-page">

        <div class="page-header">
            <h1>Shop Products</h1>
            <p>Explore our latest fashion collection</p>
        </div>

			       <div class="filter-container">
			
			    <button type="button"
			            class="filter-toggle-btn"
			            onclick="toggleFilters()">
			        Filters
			    </button>
			
			    <div id="filterSection" class="filter-section" style="display:none;">
			
			        <form action="products" method="get">
			
			            <select name="category">
			                <option value="">All Categories</option>
			
			                <%
			                if(categories != null){
			                    for(Category category : categories){
			                %>
			
			                <option value="<%= category.getCategoryId() %>">
			                    <%= category.getCategoryName() %>
			                </option>
			
			                <%
			                    }
			                }
			                %>
			
			            </select>
			
			            <input type="text"
			                   name="brand"
			                   placeholder="Brand">
			
			            <select name="size">
			                <option value="">All Sizes</option>
			                <option value="S">S</option>
			                <option value="M">M</option>
			                <option value="L">L</option>
			                <option value="XL">XL</option>
			            </select>
			
			            <input type="number"
			                   name="minPrice"
			                   placeholder="Min Price">
			
			            <input type="number"
			                   name="maxPrice"
			                   placeholder="Max Price">
			
			            <select name="sort">
			                <option value="">Sort By</option>
			                <option value="lowToHigh">
			                    Price Low To High
			                </option>
			                <option value="highToLow">
			                    Price High To Low
			                </option>
			            </select>
			
			            <button type="submit">
			                Apply Filter
			            </button>
			
			        </form>
			
			    </div>
			
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

                    <h3>
                        <%= product.getName() %>
                    </h3>

                    <p class="brand">
                        <%= product.getBrand() %>
                    </p>

                    <p class="price">
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
            else{
            %>

            <h2>No Products Available</h2>

            <%
            }
            %>

        </div>

    </main>

    <jsp:include page="/WEB-INF/views/partials/footer.jsp"/>

</body>
</html>