package com.fashionStore.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.fashionStore.dao.CartItemDAO;
import com.fashionStore.model.CartItem;
import com.fashionStore.utility.DBConnection;

public class CartItemDAOImpl implements CartItemDAO {

    private static final String ADD_CART_ITEM =
            "INSERT INTO carts(user_id, product_id, quantity) VALUES(?,?,?)";

    private static final String GET_CART_ITEMS =
            "SELECT c.cart_id, c.user_id, c.product_id, c.quantity, " +
            "p.name, p.brand, p.size, p.price, p.image_path " +
            "FROM carts c " +
            "JOIN products p ON c.product_id = p.product_id " +
            "WHERE c.user_id = ?";

    private static final String UPDATE_QUANTITY =
            "UPDATE carts SET quantity=? WHERE cart_id=?";

    private static final String REMOVE_ITEM =
            "DELETE FROM carts WHERE cart_id=?";

    private static final String CLEAR_CART =
            "DELETE FROM carts WHERE user_id=?";

    @Override
    public int addCartItem(CartItem cartItem) {

        int result = 0;

        try (Connection con = DBConnection.getConnection();
             PreparedStatement pstmt =
                     con.prepareStatement(ADD_CART_ITEM)) {

            pstmt.setInt(1, cartItem.getUserId());
            pstmt.setInt(2, cartItem.getProductId());
            pstmt.setInt(3, cartItem.getQuantity());

            result = pstmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public List<CartItem> getCartItemsByUser(int userId) {

        List<CartItem> cartItems = new ArrayList<>();

        try (Connection con = DBConnection.getConnection();
             PreparedStatement pstmt =
                     con.prepareStatement(GET_CART_ITEMS)) {

            pstmt.setInt(1, userId);

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {

                CartItem item = new CartItem();

                item.setCartId(rs.getInt("cart_id"));
                item.setUserId(rs.getInt("user_id"));
                item.setProductId(rs.getInt("product_id"));
                item.setQuantity(rs.getInt("quantity"));

                item.setProductName(rs.getString("name"));
                item.setBrand(rs.getString("brand"));
                item.setSize(rs.getString("size"));
                item.setPrice(rs.getBigDecimal("price"));
                item.setImagePath(rs.getString("image_path"));

                cartItems.add(item);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return cartItems;
    }

    @Override
    public int updateQuantity(int cartId, int quantity) {

        int result = 0;

        try (Connection con = DBConnection.getConnection();
             PreparedStatement pstmt =
                     con.prepareStatement(UPDATE_QUANTITY)) {

            pstmt.setInt(1, quantity);
            pstmt.setInt(2, cartId);

            result = pstmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public int removeCartItem(int cartId) {

        int result = 0;

        try (Connection con = DBConnection.getConnection();
             PreparedStatement pstmt =
                     con.prepareStatement(REMOVE_ITEM)) {

            pstmt.setInt(1, cartId);

            result = pstmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public int clearCart(int userId) {

        int result = 0;

        try (Connection con = DBConnection.getConnection();
             PreparedStatement pstmt =
                     con.prepareStatement(CLEAR_CART)) {

            pstmt.setInt(1, userId);

            result = pstmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
}