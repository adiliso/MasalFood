package org.example.masalfood.Business.concretes;

import lombok.AllArgsConstructor;
import org.example.masalfood.Business.abstracts.ProductService;
import org.example.masalfood.DataAccess.ProductDao;
import org.example.masalfood.Entities.Product;
import org.example.masalfood.Business.models.Responses.Result.DataResult;
import org.example.masalfood.Business.models.Responses.Result.SuccessDataResult;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ProductManager implements ProductService {
    private ProductDao productDAO;

    @Override
    public DataResult<List<Product>> getAllProducts() {
        return new SuccessDataResult<>("ugurlu", productDAO.findAll());
    }

    @Override
    public DataResult<List<Product>> showFeaturedProducts() {
        List<Product> list = productDAO.findAll();
        List<Product> result = new ArrayList<>();
        for (Product product : list) {
            if (product.isFeatured()) {
                result.add(product);
            }
        }
        return new SuccessDataResult<>(result);
    }
}
