package com.fashionStore.controller;

import java.io.IOException;
import java.util.List;

import com.fashionStore.daoImpl.CartItemDAOImpl;
import com.fashionStore.model.CartItem;
import com.fashionStore.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/cart")
public class CartItemServlet extends HttpServlet {

private static final long serialVersionUID = 1L;

private CartItemDAOImpl cartDAO;

	@Override
	public void init() throws ServletException {
	    cartDAO = new CartItemDAOImpl();
	}
	
	@Override
	protected void doGet(HttpServletRequest request,
	HttpServletResponse response)
	throws ServletException, IOException {

	HttpSession session = request.getSession(false);

	System.out.println("Cart Servlet Called");

	if(session == null) {

	    System.out.println("Session is NULL");

	    response.sendRedirect("login");
	    return;
	}

	Object userObj =
	        session.getAttribute("loggedInUser");

	System.out.println("Logged User : " + userObj);

	if(userObj == null) {

	    System.out.println("loggedInUser not found in session");

	    response.sendRedirect("login");
	    return;
	}

	User user = (User) userObj;

	int userId = user.getUserId();

	String action = request.getParameter("action");

	if(action == null) {
	    action = "view";
	}

	switch(action) {

	case "add":
	    addToCart(request, response, userId);
	    break;

	case "update":
	    updateCart(request, response);
	    break;

	case "remove":
	    removeItem(request, response);
	    break;

	case "clear":
	    clearCart(request, response, userId);
	    break;

	default:
	    viewCart(request, response, userId);
	}

	}

	
	@Override
	protected void doPost(HttpServletRequest request,
	                      HttpServletResponse response)
	        throws ServletException, IOException {
	
	    doGet(request, response);
	}
	
	private void addToCart(HttpServletRequest request,
            HttpServletResponse response,
            int userId)
		throws IOException {
		
		System.out.println("===== ADD TO CART =====");
		
		String productParam = request.getParameter("productId");
		
		System.out.println("Product ID = " + productParam);
		System.out.println("User ID = " + userId);
		
		int productId = Integer.parseInt(productParam);
		
		CartItem item = new CartItem();
		
		item.setUserId(userId);
		item.setProductId(productId);
		item.setQuantity(1);
		
		int result = cartDAO.addCartItem(item);
		
		System.out.println("Rows Inserted = " + result);
		
		response.sendRedirect("cart");
	}
	
	private void viewCart(HttpServletRequest request,
	                      HttpServletResponse response,
	                      int userId)
	        throws ServletException, IOException {
	
	    List<CartItem> cartItems =
	            cartDAO.getCartItemsByUser(userId);
	
	    request.setAttribute("cartItems", cartItems);
	
	    request.getRequestDispatcher(
	            "/WEB-INF/views/partials/cart.jsp")
	            .forward(request, response);
	}
	
	private void updateCart(HttpServletRequest request,
	                        HttpServletResponse response)
	        throws IOException {
	
	    int cartId =
	            Integer.parseInt(request.getParameter("cartId"));
	
	    int quantity =
	            Integer.parseInt(request.getParameter("quantity"));
	
	    cartDAO.updateQuantity(cartId, quantity);
	
	    response.sendRedirect("cart");
	}
	
	private void removeItem(HttpServletRequest request,
	                        HttpServletResponse response)
	        throws IOException {
	
	    int cartId =
	            Integer.parseInt(request.getParameter("cartId"));
	
	    cartDAO.removeCartItem(cartId);
	
	    response.sendRedirect("cart");
	}
	
	private void clearCart(HttpServletRequest request,
	                       HttpServletResponse response,
	                       int userId)
	        throws IOException {
	
	    cartDAO.clearCart(userId);
	
	    response.sendRedirect("cart");
	}

}
