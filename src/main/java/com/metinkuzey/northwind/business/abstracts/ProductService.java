package com.metinkuzey.northwind.business.abstracts;

import com.metinkuzey.northwind.entities.concretes.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAll();
}
