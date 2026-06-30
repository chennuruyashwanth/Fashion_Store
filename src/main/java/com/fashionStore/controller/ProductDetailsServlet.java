package com.fashionStore.controller;

import java.io.IOException;

import com.fashionStore.daoImpl.ProductDAOImpl;
import com.fashionStore.model.Product;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/product-details")
public class ProductDetailsServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private ProductDAOImpl productDAO;

    @Override
    public void init() throws ServletException {

        productDAO = new ProductDAOImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        try {

            int productId =
                    Integer.parseInt(
                            request.getParameter("id"));

            Product product =
                    productDAO.getProduct(productId);

            request.setAttribute("product", product);

            request.getRequestDispatcher(
                    "/WEB-INF/views/partials/product-details.jsp")
                    .forward(request, response);

        }
        catch(Exception e) {

            e.printStackTrace();

            response.getWriter().println(
                    "Error loading product details");
        }
    }
}