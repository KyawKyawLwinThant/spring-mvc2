package com.demo.springmvc3.model;

import com.demo.springmvc3.validation.GreaterThanTen;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Data
public class Product implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String name;
  private double price;
  @GreaterThanTen(message = "Quantity must be greater than 10!")
  private int quantity;
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private LocalDate lastUpdted;
  @ManyToOne
  private Category category;
}
