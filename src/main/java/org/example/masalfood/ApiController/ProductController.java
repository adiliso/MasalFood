package org.example.masalfood.ApiController;

import lombok.AllArgsConstructor;
import org.example.masalfood.Business.abstracts.ProductService;
import org.example.masalfood.Entities.Product;
import org.example.masalfood.Business.Dto.Responses.Result.DataResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@AllArgsConstructor
public class ProductController {
    private ProductService productService;

    @GetMapping("/get-all-products")
    public DataResult<List<Product>> getAllProducts() {
        return this.productService.getAllProducts();
    }

    @GetMapping("/get-featured-products")
    public DataResult<List<Product>> getFeaturedProducts() {
        return productService.showFeaturedProducts();
    }
}
