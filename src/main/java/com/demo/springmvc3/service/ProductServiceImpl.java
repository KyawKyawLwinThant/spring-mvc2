package com.demo.springmvc3.service;

import com.demo.springmvc3.model.Product;
import com.demo.springmvc3.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

  @Autowired
  private ProductRepository productRepository;

  @Override
  public Product create(Product product) {
    return productRepository.save(product);
  }

  @Override
  public List<Product> findAll() {
    return productRepository.findAll();
  }

  @Override
  public Product findById(int id) {
    return productRepository.getOne(id);
  }
}
