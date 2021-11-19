package com.metinkuzey.northwind.business.concretes;

import com.metinkuzey.northwind.business.abstracts.ProductService;
import com.metinkuzey.northwind.core.utilities.results.DataResult;
import com.metinkuzey.northwind.core.utilities.results.Result;
import com.metinkuzey.northwind.core.utilities.results.SuccessDataResult;
import com.metinkuzey.northwind.core.utilities.results.SuccessResult;
import com.metinkuzey.northwind.dataAccess.abstracts.ProductDao;
import com.metinkuzey.northwind.entities.concretes.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

        return new SuccessDataResult<List<Product>>
                (this.productDao.findAll(),"Data listelendi");

    }

    @Override
    public Result add(Product product) {
        this.productDao.save(product);
        return new SuccessResult("Product is added.");
    }

    @Override
    public DataResult<Product> getByProductName(String productName) {
        return new SuccessDataResult<Product>
                (this.productDao.getByProductName(productName),"Data is listed.");
    }

    @Override
    public DataResult<Product> getByProductNameAndCategoryId(String productName, int categoryId) {
        //business codes

        return new SuccessDataResult<Product>
                (this.productDao.getByProductNameAndCategory_CategoryId(productName,categoryId),"Data is listed.");
    }

    @Override
    public DataResult<List<Product>> getByProductNameOrCategoryId(String productName, int categoryId) {
        return new SuccessDataResult<List<Product>>
                (this.productDao.getByProductNameOrCategory_CategoryId(productName, categoryId),"Data is listed.");
    }

    @Override
    public DataResult<List<Product>> getByCategoryIdIn(List<Integer> categories) {
        return new SuccessDataResult<List<Product>>
                (this.productDao.getByCategoryIn(categories),"Data is listed.");
    }

    @Override
    public DataResult<List<Product>> getByProductNameContains(String productName) {
        return new SuccessDataResult<List<Product>>
                (this.productDao.getByProductNameContains(productName),"Data is listed.");
    }

    @Override
    public DataResult<List<Product>> getByProductNameStartsWith(String productName) {
        return new SuccessDataResult<List<Product>>
                (this.productDao.getByProductNameStartsWith(productName),"Data is listed.");
    }

    @Override
    public DataResult<List<Product>> getByNameAndCategory(String productName, int categoryId) {
        return new SuccessDataResult<List<Product>>
                (this.productDao.getByNameAndCategory(productName,categoryId),"Data is listed.");
    }

    @Override
    public DataResult<List<Product>> getAll(int pageNo, int pageSize) {

        Pageable pageable = PageRequest.of(pageNo-1, pageSize);

        return new SuccessDataResult<List<Product>>
                (this.productDao.findAll(pageable).getContent());
    }

    @Override
    public DataResult<List<Product>> getAllSorted() {
        Sort sort = Sort.by(Sort.Direction.DESC,"productName");
        return new SuccessDataResult<List<Product>>
                (this.productDao.findAll(sort),"Başarılı");
    }

    /*
    @Override
    public DataResult<List<Product>> getByProductNameEndsWith(String productName) {
        // write your own business codes here
         return new SuccessDataResult<List<Product>>(this.productDao.getByProductNameEndWith(productName), "Data is listed.");
    }*/

}
