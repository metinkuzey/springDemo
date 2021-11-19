package com.metinkuzey.northwind.dataAccess.abstracts;

import com.metinkuzey.northwind.entities.concretes.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductDao extends JpaRepository<Product,Integer> {
    // SELECT * FROM PRODUCTS WHERE PRODUCT_NAME = ABC
    Product getByProductName(String productName);
    // SELECT * FROM PRODUCTS WHERE PRODUCT_NAME = ABC ANN CATEGORY_ID=123
    Product getByProductNameAndCategory_CategoryId(String productName, int categoryId);
    // SELECT * FROM PRODUCTS WHERE PRODUCT_NAME = ABC OR CATEGORY_ID = 123
    List<Product> getByProductNameOrCategory_CategoryId(String productName, int categoryId);
    // SELECT * FROM PRODUCTS WHERE CATEGORY_ID IN(1,2,3,4,5)
    List<Product> getByCategoryIn(List<Integer> categories);
    // SELECT * FROM PRODUCTS WHERE PRODUCT_NAME LKE '%ABC%'
    List<Product> getByProductNameContains(String productName);
    // SELECT * FROM PRODUCTS WHERE PRODUCT_NAME LKE 'ABC%'
    List<Product> getByProductNameStartsWith(String productName);
    // SELECT * FROM PRODUCTS WHERE PRODUCT_NAME LKE '%ABC'
    //List<Product> getByProductNameEndsWith(String productName);
    /** JQL **/
    // SELECT * FROM PRODUCTS WHERE PRODUCT_NAME = ABC ANN CATEGORY_ID=123
    @Query("From Product where productName=:productName and category.categoryId=:categoryId")
    List<Product> getByNameAndCategory(String productName, int categoryId);

}
