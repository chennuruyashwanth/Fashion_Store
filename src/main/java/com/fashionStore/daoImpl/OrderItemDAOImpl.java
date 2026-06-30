package com.fashionStore.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fashionStore.dao.OrderItemDAO;
import com.fashionStore.model.OrderItem;
import com.fashionStore.utility.DBConnection;

public class OrderItemDAOImpl implements OrderItemDAO {

	private static final String INSERT_ORDER_ITEM =
			"INSERT INTO order_items(order_id,product_id,quantity,price) VALUES(?,?,?,?)";

	private static final String GET_ORDER_ITEM =
			"SELECT * FROM order_items WHERE order_item_id=?";

	private static final String GET_ORDER_ITEMS_BY_ORDER =
			"SELECT * FROM order_items WHERE order_id=?";

	private static final String UPDATE_ORDER_ITEM =
			"UPDATE order_items SET order_id=?, product_id=?, quantity=?, price=? WHERE order_item_id=?";

	private static final String DELETE_ORDER_ITEM =
			"DELETE FROM order_items WHERE order_item_id=?";

	@Override
	public int addOrderItem(OrderItem orderItem) {

		int result = 0;

		try(Connection con = DBConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement(INSERT_ORDER_ITEM)) {

			pstmt.setInt(1, orderItem.getOrderId());
			pstmt.setInt(2, orderItem.getProductId());
			pstmt.setInt(3, orderItem.getQuantity());
			pstmt.setBigDecimal(4, orderItem.getPrice());

			result = pstmt.executeUpdate();

		} catch(Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public OrderItem getOrderItem(int orderItemId) {

		OrderItem orderItem = null;

		try(Connection con = DBConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement(GET_ORDER_ITEM)) {

			pstmt.setInt(1, orderItemId);

			ResultSet rs = pstmt.executeQuery();

			if(rs.next()) {
				orderItem = extractOrderItem(rs);
			}

		} catch(Exception e) {
			e.printStackTrace();
		}

		return orderItem;
	}

	@Override
	public List<OrderItem> getOrderItemsByOrderId(int orderId) {

		List<OrderItem> orderItems = new ArrayList<>();

		try(Connection con = DBConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement(GET_ORDER_ITEMS_BY_ORDER)) {

			pstmt.setInt(1, orderId);

			ResultSet rs = pstmt.executeQuery();

			while(rs.next()) {
				orderItems.add(extractOrderItem(rs));
			}

		} catch(Exception e) {
			e.printStackTrace();
		}

		return orderItems;
	}

	@Override
	public int updateOrderItem(OrderItem orderItem) {

		int result = 0;

		try(Connection con = DBConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement(UPDATE_ORDER_ITEM)) {

			pstmt.setInt(1, orderItem.getOrderId());
			pstmt.setInt(2, orderItem.getProductId());
			pstmt.setInt(3, orderItem.getQuantity());
			pstmt.setBigDecimal(4, orderItem.getPrice());
			pstmt.setInt(5, orderItem.getOrderItemId());

			result = pstmt.executeUpdate();

		} catch(Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public int deleteOrderItem(int orderItemId) {

		int result = 0;

		try(Connection con = DBConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement(DELETE_ORDER_ITEM)) {

			pstmt.setInt(1, orderItemId);

			result = pstmt.executeUpdate();

		} catch(Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	private OrderItem extractOrderItem(ResultSet rs) throws SQLException {

		OrderItem orderItem = new OrderItem();

		orderItem.setOrderItemId(rs.getInt("order_item_id"));
		orderItem.setOrderId(rs.getInt("order_id"));
		orderItem.setProductId(rs.getInt("product_id"));
		orderItem.setQuantity(rs.getInt("quantity"));
		orderItem.setPrice(rs.getBigDecimal("price"));

		return orderItem;
	}
}