package com.demo.springmvc3.cofig;

import org.ocpsoft.prettytime.PrettyTime;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanUtil implements ApplicationContextAware {

  private static ApplicationContext context;

  @Override
  public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
      context=applicationContext;
  }

  public static Object getBean(Class<?> classType){
    return context.getBean(classType);
  }
}
