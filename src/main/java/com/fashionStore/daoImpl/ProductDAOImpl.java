package com.fashionStore.daoImpl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.fashionStore.dao.ProductDAO;
import com.fashionStore.model.Product;
import com.fashionStore.utility.DBConnection;

public class ProductDAOImpl implements ProductDAO {

	private static final String INSERT_PRODUCT =
			"INSERT INTO products(category_id,name,description,brand,size,price,stock,image_path) VALUES(?,?,?,?,?,?,?,?)";

	private static final String GET_PRODUCT =
			"SELECT * FROM products WHERE product_id=?";

	private static final String GET_ALL_PRODUCTS =
			"SELECT * FROM products";

	private static final String GET_PRODUCTS_BY_CATEGORY =
			"SELECT * FROM products WHERE category_id=?";

	private static final String UPDATE_PRODUCT =
			"UPDATE products SET category_id=?,name=?,description=?,brand=?,size=?,price=?,stock=?,image_path=? WHERE product_id=?";

	private static final String DELETE_PRODUCT =
			"DELETE FROM products WHERE product_id=?";

	@Override
	public int addProduct(Product product) {

		int result = 0;

		try(Connection con = DBConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement(INSERT_PRODUCT)) {

			pstmt.setInt(1, product.getCategoryId());
			pstmt.setString(2, product.getName());
			pstmt.setString(3, product.getDescription());
			pstmt.setString(4, product.getBrand());
			pstmt.setString(5, product.getSize());
			pstmt.setBigDecimal(6, product.getPrice());
			pstmt.setInt(7, product.getStock());
			pstmt.setString(8, product.getImagePath());

			result = pstmt.executeUpdate();

		} catch(Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public Product getProduct(int productId) {

		Product product = null;

		try(Connection con = DBConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement(GET_PRODUCT)) {

			pstmt.setInt(1, productId);

			ResultSet rs = pstmt.executeQuery();

			if(rs.next()) {
				product = extractProduct(rs);
			}

		} catch(Exception e) {
			e.printStackTrace();
		}

		return product;
	}

	@Override
	public List<Product> getAllProducts() {

		List<Product> products = new ArrayList<>();

		try(Connection con = DBConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement(GET_ALL_PRODUCTS);
			ResultSet rs = pstmt.executeQuery()) {

			while(rs.next()) {
				products.add(extractProduct(rs));
			}

		} catch(Exception e) {
			e.printStackTrace();
		}

		return products;
	}

	@Override
	public List<Product> getProductsByCategory(int categoryId) {

		List<Product> products = new ArrayList<>();

		try(Connection con = DBConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement(GET_PRODUCTS_BY_CATEGORY)) {

			pstmt.setInt(1, categoryId);

			ResultSet rs = pstmt.executeQuery();

			while(rs.next()) {
				products.add(extractProduct(rs));
			}

		} catch(Exception e) {
			e.printStackTrace();
		}

		return products;
	}

	@Override
	public int updateProduct(Product product) {

		int result = 0;

		try(Connection con = DBConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement(UPDATE_PRODUCT)) {

			pstmt.setInt(1, product.getCategoryId());
			pstmt.setString(2, product.getName());
			pstmt.setString(3, product.getDescription());
			pstmt.setString(4, product.getBrand());
			pstmt.setString(5, product.getSize());
			pstmt.setBigDecimal(6, product.getPrice());
			pstmt.setInt(7, product.getStock());
			pstmt.setString(8, product.getImagePath());
			pstmt.setInt(9, product.getProductId());

			result = pstmt.executeUpdate();

		} catch(Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public int deleteProduct(int productId) {

		int result = 0;

		try(Connection con = DBConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement(DELETE_PRODUCT)) {

			pstmt.setInt(1, productId);

			result = pstmt.executeUpdate();

		} catch(Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	private Product extractProduct(ResultSet rs) throws SQLException {

		Product product = new Product();

		product.setProductId(rs.getInt("product_id"));
		product.setCategoryId(rs.getInt("category_id"));
		product.setName(rs.getString("name"));
		product.setDescription(rs.getString("description"));
		product.setBrand(rs.getString("brand"));
		product.setSize(rs.getString("size"));
		product.setPrice(rs.getBigDecimal("price"));
		product.setStock(rs.getInt("stock"));
		product.setImagePath(rs.getString("image_path"));
		product.setCreatedAt(rs.getTimestamp("created_at"));

		return product;
	}
}