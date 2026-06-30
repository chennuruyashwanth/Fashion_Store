<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

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

                <img src="fashionStore/src/webapp/assets/images/fashion banner.png"
                     alt="Fashion Banner">

            </div>

        </section>

        <section class="categories container">

            <div class="section-title">

                <h2>Shop By Category</h2>

                <p>Find your favourite fashion category.</p>

            </div>

            <div class="category-grid">

                <div class="category-card">
                    <img src="https://via.placeholder.com/300x350">
                    <h3>Men</h3>
                </div>

                <div class="category-card">
                    <img src="https://via.placeholder.com/300x350">
                    <h3>Women</h3>
                </div>

                <div class="category-card">
                    <img src="https://via.placeholder.com/300x350">
                    <h3>Kids</h3>
                </div>

            </div>

        </section>

        <section class="featured-products container">

            <div class="section-title">

                <h2>Featured Products</h2>

                <p>Trending products for you.</p>

            </div>

            <div class="product-grid">

                <div class="product-card">

                    <img src="https://via.placeholder.com/300x350">

                    <div class="product-info">

                        <h4>Men's T-Shirt</h4>

                        <p class="text-muted">
                            Premium Cotton T-Shirt
                        </p>

                        <p class="product-price">
                            ₹999
                        </p>

                    </div>

                </div>

                <div class="product-card">

                    <img src="https://via.placeholder.com/300x350">

                    <div class="product-info">

                        <h4>Women's Dress</h4>

                        <p class="text-muted">
                            Elegant Summer Dress
                        </p>

                        <p class="product-price">
                            ₹1499
                        </p>

                    </div>

                </div>

                <div class="product-card">

                    <img src="https://via.placeholder.com/300x350">

                    <div class="product-info">

                        <h4>Kids Hoodie</h4>

                        <p class="text-muted">
                            Comfortable Winter Hoodie
                        </p>

                        <p class="product-price">
                            ₹799
                        </p>

                    </div>

                </div>

            </div>

        </section>

    </main>

    <jsp:include page="/WEB-INF/views/partials/footer.jsp"/>

</body>
</html>