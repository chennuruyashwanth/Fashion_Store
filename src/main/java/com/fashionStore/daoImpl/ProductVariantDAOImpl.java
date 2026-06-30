package com.fashionStore.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fashionStore.dao.ProductVariantDAO;
import com.fashionStore.model.ProductVariant;
import com.fashionStore.utility.DBConnection;

public class ProductVariantDAOImpl implements ProductVariantDAO {

	private static final String INSERT_VARIANT =
			"INSERT INTO product_variants(product_id,size,stock) VALUES(?,?,?)";

	private static final String GET_VARIANT =
			"SELECT * FROM product_variants WHERE variant_id=?";

	private static final String GET_ALL_VARIANTS =
			"SELECT * FROM product_variants";

	private static final String GET_VARIANTS_BY_PRODUCT =
			"SELECT * FROM product_variants WHERE product_id=?";

	private static final String UPDATE_VARIANT =
			"UPDATE product_variants SET product_id=?, size=?, stock=? WHERE variant_id=?";

	private static final String DELETE_VARIANT =
			"DELETE FROM product_variants WHERE variant_id=?";

	@Override
	public int addProductVariant(ProductVariant productVariant) {

		int result = 0;

		try (Connection con = DBConnection.getConnection();
			 PreparedStatement pstmt = con.prepareStatement(INSERT_VARIANT)) {

			pstmt.setInt(1, productVariant.getProductId());
			pstmt.setString(2, productVariant.getSize());
			pstmt.setInt(3, productVariant.getStock());

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return result;
	}

	@Override
	public ProductVariant getProductVariant(int variantId) {

		ProductVariant productVariant = null;

		try (Connection con = DBConnection.getConnection();
			 PreparedStatement pstmt = con.prepareStatement(GET_VARIANT)) {

			pstmt.setInt(1, variantId);

			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				productVariant = extractProductVariant(rs);
			}

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return productVariant;
	}

	@Override
	public List<ProductVariant> getAllProductVariants() {

		List<ProductVariant> variants = new ArrayList<>();

		try (Connection con = DBConnection.getConnection();
			 PreparedStatement pstmt = con.prepareStatement(GET_ALL_VARIANTS);
			 ResultSet rs = pstmt.executeQuery()) {

			while (rs.next()) {
				variants.add(extractProductVariant(rs));
			}

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return variants;
	}

	@Override
	public List<ProductVariant> getVariantsByProductId(int productId) {

		List<ProductVariant> variants = new ArrayList<>();

		try (Connection con = DBConnection.getConnection();
			 PreparedStatement pstmt = con.prepareStatement(GET_VARIANTS_BY_PRODUCT)) {

			pstmt.setInt(1, productId);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				variants.add(extractProductVariant(rs));
			}

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return variants;
	}

	@Override
	public int updateProductVariant(ProductVariant productVariant) {

		int result = 0;

		try (Connection con = DBConnection.getConnection();
			 PreparedStatement pstmt = con.prepareStatement(UPDATE_VARIANT)) {

			pstmt.setInt(1, productVariant.getProductId());
			pstmt.setString(2, productVariant.getSize());
			pstmt.setInt(3, productVariant.getStock());
			pstmt.setInt(4, productVariant.getVariantId());

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return result;
	}

	@Override
	public int deleteProductVariant(int variantId) {

		int result = 0;

		try (Connection con = DBConnection.getConnection();
			 PreparedStatement pstmt = con.prepareStatement(DELETE_VARIANT)) {

			pstmt.setInt(1, variantId);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return result;
	}

	private ProductVariant extractProductVariant(ResultSet rs) throws SQLException {

		ProductVariant productVariant = new ProductVariant();

		productVariant.setVariantId(rs.getInt("variant_id"));
		productVariant.setProductId(rs.getInt("product_id"));
		productVariant.setSize(rs.getString("size"));
		productVariant.setStock(rs.getInt("stock"));

		return productVariant;
	}
}