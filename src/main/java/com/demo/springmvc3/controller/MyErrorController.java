package com.demo.springmvc3.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

@Controller
public class MyErrorController implements ErrorController {
  @Override
  public String getErrorPath() {
    return "/error";
  }
  @GetMapping("/error")
  public String handleError(Model model, HttpServletRequest request){

    Object obj = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
      if(obj!=null){
         if(Integer.valueOf(obj.toString())== 404){
           model.addAttribute("msg","Not Found.");
           model.addAttribute("status",obj.toString());

         }
         else if(Integer.valueOf(obj.toString())==403){
           model.addAttribute("msg","You are Forbidden...");
           model.addAttribute("status",obj.toString());
         }
      }


      return "error";
  }
}
