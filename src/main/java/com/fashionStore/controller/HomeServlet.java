package com.fashionStore.controller;

import java.io.IOException;
import java.util.List;

import com.fashionStore.daoImpl.CategoryDAOImpl;
import com.fashionStore.daoImpl.ProductDAOImpl;
import com.fashionStore.model.Category;
import com.fashionStore.model.Product;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/home")
public class HomeServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private CategoryDAOImpl categoryDAO = new CategoryDAOImpl();;
	private ProductDAOImpl productDAO = new ProductDAOImpl();
	

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {

		List<Category> categories = categoryDAO.getAllCategories();

		List<Product> products = productDAO.getAllProducts();

		request.setAttribute("categories", categories);

		request.setAttribute("products", products);

		request.getRequestDispatcher("/WEB-INF/views/partials/home1.jsp").forward(request, response);
	}
}