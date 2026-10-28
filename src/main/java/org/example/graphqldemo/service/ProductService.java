package org.example.graphqldemo.service;

import org.example.graphqldemo.dto.Product;
import org.example.graphqldemo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> findByCategory(String category){
        return productRepository.findByCategory(category);
    }

    public List<Product> getProducts() {
        return productRepository.findAll();
    }


    public Product updateStock(int id, int stock){

        Product existingProduct= productRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("product not found with id "+id));

        existingProduct.setStock(stock);
        return productRepository.save(existingProduct);
    }


    public Product receiveNewShipment(int id, int quantity){

        Product existingProduct= productRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("product not found with id "+id));

        existingProduct.setStock(existingProduct.getStock()+quantity);
        return productRepository.save(existingProduct);
    }
}
