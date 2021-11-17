package com.metinkuzey.northwind.business.abstracts;

import com.metinkuzey.northwind.core.utilities.results.DataResult;
import com.metinkuzey.northwind.core.utilities.results.Result;
import com.metinkuzey.northwind.entities.concretes.Product;

import java.util.List;

public interface ProductService {
    DataResult<List<Product>>  getAll();
    Result add(Product product);
}
