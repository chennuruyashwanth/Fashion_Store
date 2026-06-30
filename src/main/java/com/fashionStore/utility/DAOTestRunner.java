package com.fashionStore.utility;

import java.util.List;

import com.fashionStore.daoImpl.CartDAOImpl;
import com.fashionStore.daoImpl.CartItemDAOImpl;
import com.fashionStore.daoImpl.CategoryDAOImpl;
import com.fashionStore.daoImpl.OrderDAOImpl;
import com.fashionStore.daoImpl.OrderItemDAOImpl;
import com.fashionStore.daoImpl.ProductDAOImpl;
import com.fashionStore.daoImpl.ProductVariantDAOImpl;
import com.fashionStore.daoImpl.UserDAOImpl;

import com.fashionStore.model.Cart;
import com.fashionStore.model.CartItem;
import com.fashionStore.model.Category;
import com.fashionStore.model.Order;
import com.fashionStore.model.OrderItem;
import com.fashionStore.model.Product;
import com.fashionStore.model.ProductVariant;
import com.fashionStore.model.User;

public class DAOTestRunner {

	public static void main(String[] args) {

		// =========================================
		// USER DAO TEST
		// =========================================

		System.out.println("\n========== USERS ==========");

		UserDAOImpl userDAO = new UserDAOImpl();

		List<User> users = userDAO.getAllUsers();

		for(User user : users) {
			System.out.println(user);
		}


		// =========================================
		// CATEGORY DAO TEST
		// =========================================

		System.out.println("\n========== CATEGORIES ==========");

		CategoryDAOImpl categoryDAO = new CategoryDAOImpl();

		List<Category> categories = categoryDAO.getAllCategories();

		for(Category category : categories) {
			System.out.println(category);
		}


		// =========================================
		// PRODUCT DAO TEST
		// =========================================

		System.out.println("\n========== PRODUCTS ==========");

		ProductDAOImpl productDAO = new ProductDAOImpl();

		List<Product> products = productDAO.getAllProducts();

		for(Product product : products) {
			System.out.println(product);
		}


		// =========================================
		// PRODUCT VARIANT DAO TEST
		// =========================================

		System.out.println("\n========== PRODUCT VARIANTS ==========");

		ProductVariantDAOImpl variantDAO =
				new ProductVariantDAOImpl();

		List<ProductVariant> variants =
				variantDAO.getAllProductVariants();

		for(ProductVariant variant : variants) {
			System.out.println(variant);
		}


		// =========================================
		// CART DAO TEST
		// =========================================

		System.out.println("\n========== CART ==========");

		CartDAOImpl cartDAO = new CartDAOImpl();

		Cart cart = cartDAO.getCartByUserId(1);

		System.out.println(cart);


		// =========================================
		// CART ITEM DAO TEST
		// =========================================

		System.out.println("\n========== CART ITEMS ==========");

		CartItemDAOImpl cartItemDAO =
				new CartItemDAOImpl();

		List<CartItem> cartItems =
				cartItemDAO.getCartItemsByUser(1);

		for(CartItem item : cartItems) {
			System.out.println(item);
		}


		// =========================================
		// ORDER DAO TEST
		// =========================================

		System.out.println("\n========== ORDERS ==========");

		OrderDAOImpl orderDAO = new OrderDAOImpl();

		List<Order> orders =
				orderDAO.getOrdersByUserId(1);

		for(Order order : orders) {
			System.out.println(order);
		}


		// =========================================
		// ORDER ITEM DAO TEST
		// =========================================

		System.out.println("\n========== ORDER ITEMS ==========");

		OrderItemDAOImpl orderItemDAO =
				new OrderItemDAOImpl();

		List<OrderItem> orderItems =
				orderItemDAO.getOrderItemsByOrderId(1);

		for(OrderItem item : orderItems) {
			System.out.println(item);
		}


		System.out.println(
				"\n========== ALL DAO TESTS COMPLETED ==========");
	}
}