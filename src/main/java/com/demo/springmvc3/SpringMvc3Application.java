package com.demo.springmvc3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationContextInitializedEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@SpringBootApplication
public class SpringMvc3Application {

  private static Logger
          logger= LoggerFactory.getLogger(SpringMvc3Application.class);



  public static void main(String[] args) {
    SpringApplication.run(SpringMvc3Application.class, args);
  }






}
