package com.demo.springmvc3.service;

import com.demo.springmvc3.exception.MyEntityNotFoundException;
import com.demo.springmvc3.model.Product;
import com.demo.springmvc3.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
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
    return productRepository
            .findById(id).orElseThrow(()->new EntityNotFoundException(id + " Not Found!"));
  }

  @Override
  public void delete(int id) {
    productRepository.deleteById(id);
  }

  @Override
  @Transactional
  public void update(Product newProduct, int id) {
       Product product=findById(id);
       product.setCategory(newProduct.getCategory());
       product.setLastUpdted(newProduct.getLastUpdted());
       product.setName(newProduct.getName());
       product.setPrice(newProduct.getPrice());
       product.setQuantity(newProduct.getQuantity());
  }
}
