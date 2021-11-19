package com.metinkuzey.northwind.api.controllers;

import com.metinkuzey.northwind.business.abstracts.ProductService;
import com.metinkuzey.northwind.core.utilities.results.DataResult;
import com.metinkuzey.northwind.core.utilities.results.Result;
import com.metinkuzey.northwind.entities.concretes.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductsController {

    private ProductService productService;
    @Autowired
    public ProductsController(ProductService productService) {
        super ();
        this.productService = productService;
    }

    @GetMapping("/getAll")
    public DataResult<List<Product>> getAll(){
        return this.productService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody Product product){
        return this.productService.add(product);
    }

    @GetMapping("/getByProductName")
    public DataResult<Product> getByProductName(@RequestParam String productName){
        return this.productService.getByProductName(productName);
    }

    @GetMapping("/getByProductNameAndCategoryId")
    public DataResult<Product>
    getByProductNameAndCategoryId(@RequestParam("productName") String productName,@RequestParam("categoryId") int categoryId){
        System.out.println(productName);
        System.out.println(categoryId);

        return this.productService.getByProductNameAndCategoryId
                (productName, categoryId);
    }

    @GetMapping("/getByProductNameContains")
    public DataResult<List<Product>> getByProductNameContains(@RequestParam String productName){
        return this.productService.getByProductNameContains(productName);
    }

    @GetMapping("/getAllByPage")
    DataResult<List<Product>> getAll(int pageNo, int pageSize){
        return this.productService.getAll(pageNo, pageSize);
    }

    @GetMapping("/getAllDesc")
    public DataResult<List<Product>> getAllSorted() {
        return this.productService.getAllSorted();
    }

}
