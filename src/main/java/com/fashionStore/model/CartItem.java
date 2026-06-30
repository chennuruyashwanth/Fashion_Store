package com.fashionStore.model;

import java.math.BigDecimal;

public class CartItem {

    private int cartId;
    private int userId;
    private int productId;
    private int quantity;

    // Product Details
    private String productName;
    private String brand;
    private String size;
    private BigDecimal price;
    private String imagePath;

    public CartItem() {
    }

    public CartItem(int cartId, int userId, int productId,
                    int quantity, String productName,
                    String brand, String size,
                    BigDecimal price, String imagePath) {

        this.cartId = cartId;
        this.userId = userId;
        this.productId = productId;
        this.quantity = quantity;
        this.productName = productName;
        this.brand = brand;
        this.size = size;
        this.price = price;
        this.imagePath = imagePath;
    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public BigDecimal getSubTotal() {

        if(price == null) {
            return BigDecimal.ZERO;
        }

        return price.multiply(
                BigDecimal.valueOf(quantity));
    }
}