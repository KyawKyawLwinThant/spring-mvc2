package com.demo.springmvc3.model;

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
  private int quantity;
  @DateTimeFormat(pattern = "dd-MM-yyyy")
  private LocalDate lastUpdted;
  @ManyToOne
  private Category category;
}
