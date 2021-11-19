package com.metinkuzey.northwind.business.abstracts;

import com.metinkuzey.northwind.core.utilities.results.DataResult;
import com.metinkuzey.northwind.core.utilities.results.Result;
import com.metinkuzey.northwind.entities.concretes.Product;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductService {
    DataResult<List<Product>>  getAll();
    Result add(Product product);
    // SELECT * FROM PRODUCTS WHERE PRODUCT_NAME = ABC
    DataResult<Product> getByProductName(String productName);
    // SELECT * FROM PRODUCTS WHERE PRODUCT_NAME = ABC ANN CATEGORY_ID=123
    DataResult<Product> getByProductNameAndCategoryId(String productName, int categoryId);
    // SELECT * FROM PRODUCTS WHERE PRODUCT_NAME = ABC OR CATEGORY_ID = 123
    DataResult<List<Product>>  getByProductNameOrCategoryId(String productName, int categoryId);
    // SELECT * FROM PRODUCTS WHERE CATEGORY_ID IN(1,2,3,4,5)
    DataResult<List<Product>>  getByCategoryIdIn(List<Integer> categories);
    // SELECT * FROM PRODUCTS WHERE PRODUCT_NAME LKE '%ABC%'
    DataResult<List<Product>>  getByProductNameContains(String productName);
    // SELECT * FROM PRODUCTS WHERE PRODUCT_NAME LKE 'ABC%'
    DataResult<List<Product>>  getByProductNameStartsWith(String productName);
    // SELECT * FROM PRODUCTS WHERE PRODUCT_NAME LKE '%ABC'
    //DataResult<List<Product>>  getByProductNameEndsWith(String productName);
    // SELECT * FROM PRODUCTS WHERE PRODUCT_NAME = ABC ANN CATEGORY_ID=123
    DataResult<List<Product>>  getByNameAndCategory(String productName, int categoryId);

    DataResult<List<Product>> getAllSorted();
    DataResult<List<Product>> getAll(int pageNo, int pageSize);
}
