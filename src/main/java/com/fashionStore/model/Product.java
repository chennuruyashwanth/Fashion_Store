package com.fashionStore.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class Product {

	private int productId;
	private int categoryId;
	private String name;
	private String description;
	private String brand;
	private String size;
	private BigDecimal price;
	private int stock;
	private String imagePath;
	private Timestamp createdAt;

	public Product() {

	}

	public Product(int productId, int categoryId, String name, String description, String brand, String size,
			BigDecimal price, int stock, String imagePath, Timestamp createdAt) {
		super();
		this.productId = productId;
		this.categoryId = categoryId;
		this.name = name;
		this.description = description;
		this.brand = brand;
		this.size = size;
		this.price = price;
		this.stock = stock;
		this.imagePath = imagePath;
		this.createdAt = createdAt;
	}
	
	

	public Product(int productId, int categoryId, String name, String description, String brand, String size,
			BigDecimal price, int stock, String imagePath) {
		super();
		this.productId = productId;
		this.categoryId = categoryId;
		this.name = name;
		this.description = description;
		this.brand = brand;
		this.size = size;
		this.price = price;
		this.stock = stock;
		this.imagePath = imagePath;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", categoryId=" + categoryId + ", name=" + name
				+ ", description=" + description + ", brand=" + brand + ", size=" + size + ", price=" + price
				+ ", stock=" + stock + ", imagePath=" + imagePath + ", createdAt=" + createdAt + "]";
	}
}