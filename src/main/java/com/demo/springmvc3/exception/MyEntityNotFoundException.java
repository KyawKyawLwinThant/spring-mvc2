package com.demo.springmvc3.exception;

public class MyEntityNotFoundException extends RuntimeException {
  public MyEntityNotFoundException(String message){
    super(message);
  }
}
