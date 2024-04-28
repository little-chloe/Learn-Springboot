package com.project.shopapp.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.project.shopapp.dtos.ProductDTO;
import com.project.shopapp.dtos.ProductImageDTO;
import com.project.shopapp.exceptions.DataNotFoundException;
import com.project.shopapp.exceptions.InvalidParamException;
import com.project.shopapp.models.Product;
import com.project.shopapp.models.ProductImage;

public interface IProductService {
    public Product createProduct(ProductDTO productDTO) throws DataNotFoundException;

    Product getProductById(Long id) throws DataNotFoundException;

    Page<Product> getAllProducts(PageRequest pageRequest);

    Product updateProduct(long id, ProductDTO productDTO) throws DataNotFoundException;

    void deleteProduct(long id);

    boolean existsByName(String name);

    public ProductImage createProductImage(Long productId, ProductImageDTO productImageDTO)
            throws DataNotFoundException, InvalidParamException;
}