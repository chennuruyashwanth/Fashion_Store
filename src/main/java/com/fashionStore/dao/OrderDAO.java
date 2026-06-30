package com.fashionStore.dao;

import java.util.List;
import com.fashionStore.model.Order;

public interface OrderDAO {

	int addOrder(Order order);

	Order getOrder(int orderId);

	List<Order> getOrdersByUserId(int userId);

	List<Order> getAllOrders();

	int updateOrder(Order order);

	int deleteOrder(int orderId);
}