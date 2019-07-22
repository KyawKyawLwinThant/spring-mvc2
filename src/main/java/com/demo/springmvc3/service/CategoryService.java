package com.demo.springmvc3.service;

import com.demo.springmvc3.model.Category;

import java.util.List;

public interface CategoryService {
  Category create(Category category);

  Category findById(int id);

  List<Category> findAll();
}
