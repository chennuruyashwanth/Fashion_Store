package com.fashionStore.dao;

import java.util.List;

import com.fashionStore.model.CartItem;

public interface CartItemDAO {

	int addCartItem(CartItem cartItem);
	
	List<CartItem> getCartItemsByUser(int userId);
	
	int updateQuantity(int cartId, int quantity);
	
	int removeCartItem(int cartId);
	
	int clearCart(int userId);

}