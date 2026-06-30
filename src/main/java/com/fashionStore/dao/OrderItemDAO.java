package com.fashionStore.dao;

import java.util.List;
import com.fashionStore.model.OrderItem;

public interface OrderItemDAO {

	int addOrderItem(OrderItem orderItem);

	OrderItem getOrderItem(int orderItemId);

	List<OrderItem> getOrderItemsByOrderId(int orderId);

	int updateOrderItem(OrderItem orderItem);

	int deleteOrderItem(int orderItemId);
}