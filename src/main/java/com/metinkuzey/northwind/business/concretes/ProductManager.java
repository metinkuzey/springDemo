package com.metinkuzey.northwind.business.concretes;

import com.metinkuzey.northwind.business.abstracts.ProductService;
import com.metinkuzey.northwind.core.utilities.results.DataResult;
import com.metinkuzey.northwind.core.utilities.results.Result;
import com.metinkuzey.northwind.core.utilities.results.SuccessDataResult;
import com.metinkuzey.northwind.core.utilities.results.SuccessResult;
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
    public DataResult<List<Product>> getAll() {
        return new SuccessDataResult<List<Product>>(this.productDao.findAll(), "Data is listed.");
    }

    @Override
    public Result add(Product product) {
        this.productDao.save(product);
        return new SuccessResult("Product is added.");
    }
}
