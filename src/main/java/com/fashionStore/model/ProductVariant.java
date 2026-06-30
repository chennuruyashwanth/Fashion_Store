package com.fashionStore.model;

public class ProductVariant {

	private int variantId;
	private int productId;
	private String size;
	private int stock;

	public ProductVariant() {

	}

	public ProductVariant(int variantId, int productId, String size, int stock) {
		super();
		this.variantId = variantId;
		this.productId = productId;
		this.size = size;
		this.stock = stock;
	}

	public int getVariantId() {
		return variantId;
	}

	public void setVariantId(int variantId) {
		this.variantId = variantId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "ProductVariant [variantId=" + variantId +
				", productId=" + productId +
				", size=" + size +
				", stock=" + stock + "]";
	}
}