package org.example.masalfood.Business.abstracts;

import org.example.masalfood.Entities.Product;
import org.example.masalfood.Business.Dto.Responses.Result.DataResult;

import java.util.List;

public interface ProductService {
    DataResult<List<Product>> getAllProducts();

    DataResult<List<Product>> showFeaturedProducts();
}
