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
    DataResult<List<Product>> getAll(){
        return this.productService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody Product product){
        return this.productService.add(product);
    }

}
