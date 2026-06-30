package com.fashionStore.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fashionStore.dao.OrderDAO;
import com.fashionStore.model.Order;
import com.fashionStore.utility.DBConnection;

public class OrderDAOImpl implements OrderDAO {

	private static final String INSERT_ORDER =
			"INSERT INTO orders(user_id,total_amount,payment_mode,status) VALUES(?,?,?,?)";

	private static final String GET_ORDER =
			"SELECT * FROM orders WHERE order_id=?";

	private static final String GET_ALL_ORDERS =
			"SELECT * FROM orders";

	private static final String GET_ORDERS_BY_USER =
			"SELECT * FROM orders WHERE user_id=?";

	private static final String UPDATE_ORDER =
			"UPDATE orders SET user_id=?, total_amount=?, payment_mode=?, status=? WHERE order_id=?";

	private static final String DELETE_ORDER =
			"DELETE FROM orders WHERE order_id=?";

	@Override
	public int addOrder(Order order) {

	    int orderId = 0;

	    try(Connection con = DBConnection.getConnection();
	        PreparedStatement pstmt =
	        con.prepareStatement(
	                INSERT_ORDER,
	                PreparedStatement.RETURN_GENERATED_KEYS)) {

	        pstmt.setInt(1, order.getUserId());
	        pstmt.setBigDecimal(2, order.getTotalAmount());
	        pstmt.setString(3, order.getPaymentMode());
	        pstmt.setString(4, order.getStatus());

	        int rows = pstmt.executeUpdate();

	        if(rows > 0) {

	            ResultSet rs =
	                    pstmt.getGeneratedKeys();

	            if(rs.next()) {

	                orderId = rs.getInt(1);
	            }
	        }

	    } catch(Exception e) {

	        e.printStackTrace();
	    }

	    return orderId;
	}

	@Override
	public Order getOrder(int orderId) {

		Order order = null;

		try(Connection con = DBConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement(GET_ORDER)) {

			pstmt.setInt(1, orderId);

			ResultSet rs = pstmt.executeQuery();

			if(rs.next()) {
				order = extractOrder(rs);
			}

		} catch(Exception e) {
			e.printStackTrace();
		}

		return order;
	}

	@Override
	public List<Order> getOrdersByUserId(int userId) {

		List<Order> orders = new ArrayList<>();

		try(Connection con = DBConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement(GET_ORDERS_BY_USER)) {

			pstmt.setInt(1, userId);

			ResultSet rs = pstmt.executeQuery();

			while(rs.next()) {
				orders.add(extractOrder(rs));
			}

		} catch(Exception e) {
			e.printStackTrace();
		}

		return orders;
	}

	@Override
	public List<Order> getAllOrders() {

		List<Order> orders = new ArrayList<>();

		try(Connection con = DBConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement(GET_ALL_ORDERS);
			ResultSet rs = pstmt.executeQuery()) {

			while(rs.next()) {
				orders.add(extractOrder(rs));
			}

		} catch(Exception e) {
			e.printStackTrace();
		}

		return orders;
	}

	@Override
	public int updateOrder(Order order) {

		int result = 0;

		try(Connection con = DBConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement(UPDATE_ORDER)) {

			pstmt.setInt(1, order.getUserId());
			pstmt.setBigDecimal(2, order.getTotalAmount());
			pstmt.setString(3, order.getPaymentMode());
			pstmt.setString(4, order.getStatus());
			pstmt.setInt(5, order.getOrderId());

			result = pstmt.executeUpdate();

		} catch(Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public int deleteOrder(int orderId) {

		int result = 0;

		try(Connection con = DBConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement(DELETE_ORDER)) {

			pstmt.setInt(1, orderId);

			result = pstmt.executeUpdate();

		} catch(Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	private Order extractOrder(ResultSet rs) throws SQLException {

		Order order = new Order();

		order.setOrderId(rs.getInt("order_id"));
		order.setUserId(rs.getInt("user_id"));
		order.setTotalAmount(rs.getBigDecimal("total_amount"));
		order.setPaymentMode(rs.getString("payment_mode"));
		order.setStatus(rs.getString("status"));
		order.setOrderDate(rs.getTimestamp("order_date"));

		return order;
	}
	
	public Order getLatestOrderByUserId(int userId) {

	    Order order = null;

	    String query =
	            "SELECT * FROM orders " +
	            "WHERE user_id=? " +
	            "ORDER BY order_id DESC LIMIT 1";

	    try(Connection con = DBConnection.getConnection();
	        PreparedStatement pstmt =
	                con.prepareStatement(query)) {

	        pstmt.setInt(1, userId);

	        ResultSet rs = pstmt.executeQuery();

	        if(rs.next()) {

	            order = new Order();

	            order.setOrderId(
	                    rs.getInt("order_id"));

	            order.setUserId(
	                    rs.getInt("user_id"));

	            order.setTotalAmount(
	                    rs.getBigDecimal("total_amount"));

	            order.setPaymentMode(
	                    rs.getString("payment_mode"));

	            order.setStatus(
	                    rs.getString("status"));

	            order.setOrderDate(
	                    rs.getTimestamp("order_date"));
	        }

	    } catch(Exception e) {

	        e.printStackTrace();
	    }

	    return order;
	}
}