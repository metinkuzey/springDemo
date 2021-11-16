package com.metinkuzey.northwind.business.concretes;

import com.metinkuzey.northwind.business.abstracts.ProductService;
import com.metinkuzey.northwind.dataAccess.abstracts.ProductDao;
import com.metinkuzey.northwind.entities.concretes.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductManager implements ProductService {

    private ProductDao productDao;

     @Autowired
    public ProductManager(ProductDao productDao) {
        super();
        this.productDao = productDao;
    }

    @Override
    public List<Product> getAll() {
        return this.productDao.findAll();
    }
}
