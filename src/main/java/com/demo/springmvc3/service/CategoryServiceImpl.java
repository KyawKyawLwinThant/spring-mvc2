package com.demo.springmvc3.service;

import com.demo.springmvc3.model.Category;
import com.demo.springmvc3.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
@Service
public class CategoryServiceImpl implements CategoryService {

  @Autowired
  private CategoryRepository categoryRepository;

  @Override
  public Category create(Category category) {
    return categoryRepository.save(category);
  }

  @Override
  public Category findById(int id) {
    return categoryRepository.findById(id)
            .orElseThrow(()->new EntityNotFoundException(id +" not found."));
  }

  @Override
  public List<Category> findAll() {
    return categoryRepository.findAll();
  }
}
