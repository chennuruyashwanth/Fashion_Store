package com.fashionStore.dao;

import java.util.List;
import com.fashionStore.model.Product;

public interface ProductDAO {

	int addProduct(Product product);

	Product getProduct(int productId);

	List<Product> getAllProducts();

	List<Product> getProductsByCategory(int categoryId);

	int updateProduct(Product product);

	int deleteProduct(int productId);
}