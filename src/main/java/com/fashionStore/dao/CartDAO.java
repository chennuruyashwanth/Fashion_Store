package com.fashionStore.dao;

import com.fashionStore.model.Cart;

public interface CartDAO {

	int addCart(Cart cart);

	Cart getCart(int cartId);

	Cart getCartByUserId(int userId);

	int updateCart(Cart cart);

	int deleteCart(int cartId);
}