package com.fashionStore.dao;

import java.util.List;
import com.fashionStore.model.ProductVariant;

public interface ProductVariantDAO {

	int addProductVariant(ProductVariant productVariant);

	ProductVariant getProductVariant(int variantId);

	List<ProductVariant> getAllProductVariants();

	List<ProductVariant> getVariantsByProductId(int productId);

	int updateProductVariant(ProductVariant productVariant);

	int deleteProductVariant(int variantId);
}