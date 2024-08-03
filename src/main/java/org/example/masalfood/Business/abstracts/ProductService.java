package org.example.masalfood.Business;

import org.example.masalfood.Entities.Product;
import org.example.masalfood.Result.DataResult;
import org.example.masalfood.Result.Result;

import java.util.List;

public interface ProductService {
    DataResult<List<Product>> getAllProducts();

    DataResult<List<Product>> showFeaturedProducts();
}
