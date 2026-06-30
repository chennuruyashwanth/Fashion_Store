package com.fashionStore.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.fashionStore.dao.CartDAO;
import com.fashionStore.model.Cart;
import com.fashionStore.utility.DBConnection;

public class CartDAOImpl implements CartDAO {

	private static final String INSERT_CART =
			"INSERT INTO carts(user_id) VALUES(?)";

	private static final String GET_CART =
			"SELECT * FROM carts WHERE cart_id=?";

	private static final String GET_CART_BY_USER =
			"SELECT * FROM carts WHERE user_id=?";

	private static final String UPDATE_CART =
			"UPDATE carts SET user_id=? WHERE cart_id=?";

	private static final String DELETE_CART =
			"DELETE FROM carts WHERE cart_id=?";

	@Override
	public int addCart(Cart cart) {

		int result = 0;

		try(Connection con = DBConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement(INSERT_CART)) {

			pstmt.setInt(1, cart.getUserId());

			result = pstmt.executeUpdate();

		} catch(Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public Cart getCart(int cartId) {

		Cart cart = null;

		try(Connection con = DBConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement(GET_CART)) {

			pstmt.setInt(1, cartId);

			ResultSet rs = pstmt.executeQuery();

			if(rs.next()) {
				cart = extractCart(rs);
			}

		} catch(Exception e) {
			e.printStackTrace();
		}

		return cart;
	}

	@Override
	public Cart getCartByUserId(int userId) {

		Cart cart = null;

		try(Connection con = DBConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement(GET_CART_BY_USER)) {

			pstmt.setInt(1, userId);

			ResultSet rs = pstmt.executeQuery();

			if(rs.next()) {
				cart = extractCart(rs);
			}

		} catch(Exception e) {
			e.printStackTrace();
		}

		return cart;
	}

	@Override
	public int updateCart(Cart cart) {

		int result = 0;

		try(Connection con = DBConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement(UPDATE_CART)) {

			pstmt.setInt(1, cart.getUserId());
			pstmt.setInt(2, cart.getCartId());

			result = pstmt.executeUpdate();

		} catch(Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public int deleteCart(int cartId) {

		int result = 0;

		try(Connection con = DBConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement(DELETE_CART)) {

			pstmt.setInt(1, cartId);

			result = pstmt.executeUpdate();

		} catch(Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	private Cart extractCart(ResultSet rs) throws SQLException {

		Cart cart = new Cart();

		cart.setCartId(rs.getInt("cart_id"));
		cart.setUserId(rs.getInt("user_id"));
		cart.setCreatedAt(rs.getTimestamp("created_at"));

		return cart;
	}
}