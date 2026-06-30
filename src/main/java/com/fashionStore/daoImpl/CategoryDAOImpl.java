package com.fashionStore.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.fashionStore.dao.CategoryDAO;
import com.fashionStore.model.Category;
import com.fashionStore.utility.DBConnection;

public class CategoryDAOImpl implements CategoryDAO {

	private static final String INSERT_QUERY =
			"INSERT INTO categories(category_name, description) VALUES(?,?)";

	private static final String GET_CATEGORY_QUERY =
			"SELECT * FROM categories WHERE category_id=?";

	private static final String GET_ALL_CATEGORIES_QUERY =
			"SELECT * FROM categories";

	private static final String UPDATE_QUERY =
			"UPDATE categories SET category_name=? WHERE category_id=?";

	private static final String DELETE_QUERY =
			"DELETE FROM categories WHERE category_id=?";

	@Override
	public int addCategory(Category category) {

		int result = 0;

		try (Connection con = DBConnection.getConnection();
			 PreparedStatement pstmt = con.prepareStatement(INSERT_QUERY)) {

			pstmt.setString(1, category.getCategoryName());
			pstmt.setString(2, category.getDescription());

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public Category getCategory(int categoryId) {

		Category category = null;

		try (Connection con = DBConnection.getConnection();
			 PreparedStatement pstmt = con.prepareStatement(GET_CATEGORY_QUERY)) {

			pstmt.setInt(1, categoryId);

			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {

				category = new Category();

				category.setCategoryId(rs.getInt("category_id"));
				category.setCategoryName(rs.getString("category_name"));
				category.setDescription(rs.getString("description"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return category;
	}

	@Override
	public List<Category> getAllCategories() {

		List<Category> categories = new ArrayList<Category>();

		try (Connection con = DBConnection.getConnection();
			 PreparedStatement stmt = con.prepareStatement(GET_ALL_CATEGORIES_QUERY);
			 ResultSet rs = stmt.executeQuery()){
			while (rs.next()) {

				Category category = new Category();

				category.setCategoryId(rs.getInt("category_id"));
				category.setCategoryName(rs.getString("category_name"));
				category.setDescription(rs.getString("description"));


				categories.add(category);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return categories;
	}

	@Override
	public int updateCategory(Category category) {

		int result = 0;

		try (Connection con = DBConnection.getConnection();
			 PreparedStatement pstmt = con.prepareStatement(UPDATE_QUERY)) {

			pstmt.setString(1, category.getCategoryName());
			pstmt.setInt(2, category.getCategoryId());
			pstmt.setString(2, category.getDescription());


			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public int deleteCategory(int categoryId) {

		int result = 0;

		try (Connection con = DBConnection.getConnection();
			 PreparedStatement pstmt = con.prepareStatement(DELETE_QUERY)) {

			pstmt.setInt(1, categoryId);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}
}