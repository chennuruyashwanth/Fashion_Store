<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<nav class="navbar">

    <!-- Logo -->
    <div class="logo">
        <a href="home">FashionStore</a>
    </div>

    <!-- Main Navigation -->
    <ul class="nav-links">
        <li><a href="home">Home</a></li>
        <li><a href="products">Products</a></li>
 		<li><a href="cart">Cart</a></li>
        <li><a href="login">Login</a></li>
        <li><a href="profile">Profile</a></li>
   </ul>

    <!-- Search -->
    <div class="search-box">
        <form action="products" method="get">
            <input type="text"
                   name="search"
                   placeholder="Search Products">
        </form>
    </div>

   
</nav>