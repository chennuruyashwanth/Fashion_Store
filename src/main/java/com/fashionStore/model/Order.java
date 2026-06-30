package com.fashionStore.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class Order {

	private int orderId;
	private int userId;
	private BigDecimal totalAmount;
	private String paymentMode;
	private String status;
	private Timestamp orderDate;

	public Order() {

	}

	public Order(int orderId, int userId, BigDecimal totalAmount, String paymentMode, String status,
			Timestamp orderDate) {
		super();
		this.orderId = orderId;
		this.userId = userId;
		this.totalAmount = totalAmount;
		this.paymentMode = paymentMode;
		this.status = status;
		this.orderDate = orderDate;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Timestamp getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Timestamp orderDate) {
		this.orderDate = orderDate;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", userId=" + userId + ", totalAmount=" + totalAmount
				+ ", paymentMode=" + paymentMode + ", status=" + status + ", orderDate=" + orderDate + "]";
	}
}