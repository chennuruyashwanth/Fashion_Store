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

@WebServlet("/products")
public class ProductServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private ProductDAOImpl productDAO;
    private CategoryDAOImpl categoryDAO;

    @Override
    public void init() throws ServletException {

        productDAO = new ProductDAOImpl();
        categoryDAO = new CategoryDAOImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        try {

        	List<Product> products;
        	List<Category> categories = categoryDAO.getAllCategories();

        	String categoryIdParam =
        	        request.getParameter("category");

        	if(categoryIdParam != null &&
        	   !categoryIdParam.isEmpty()) {

        	    int categoryId =
        	            Integer.parseInt(categoryIdParam);

        	    products =
        	            productDAO.getProductsByCategory(categoryId);

        	} else {

        	    products =
        	            productDAO.getAllProducts();
        	}

        	String sort = request.getParameter("sort");

        	if(sort != null) {

        	    if(sort.equals("lowToHigh")) {

        	        products.sort(
        	            (p1, p2) ->
        	            p1.getPrice().compareTo(p2.getPrice())
        	        );

        	    } else if(sort.equals("highToLow")) {

        	        products.sort(
        	            (p1, p2) ->
        	            p2.getPrice().compareTo(p1.getPrice())
        	        );
        	    }
        	}

        	request.setAttribute("products", products);
            request.setAttribute("categories", categories);

            request.getRequestDispatcher(
                    "/WEB-INF/views/partials/products.jsp")
                    .forward(request, response);

        } catch (Exception e) {

            e.printStackTrace();

            response.getWriter().println(
                    "Error Loading Products : "
                    + e.getMessage());
        }
    }
}