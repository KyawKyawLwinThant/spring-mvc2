package com.demo.springmvc3.controller;

import com.demo.springmvc3.model.Category;
import com.demo.springmvc3.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class CategoryController {
  @Autowired
  private CategoryService categoryService;

  @GetMapping("/category")
  public String create(Model model){
    model.addAttribute("category",new Category());

    return "categoryForm";
  }

  @PostMapping("/category")
  public String process(@Valid Category category, BindingResult result, RedirectAttributes redirectAttributes){
    if(result.hasErrors()){
      return "categoryForm";
    }
    categoryService.create(category);
    redirectAttributes
            .addFlashAttribute("success1",true);

    return "redirect:/categories";
  }

  @GetMapping("/categories")
  public String showAllCategories(Model model){
    model.addAttribute("success1",model.containsAttribute("success1"));
    model.addAttribute("categories",categoryService.findAll());
    return "categories";
  }
}
