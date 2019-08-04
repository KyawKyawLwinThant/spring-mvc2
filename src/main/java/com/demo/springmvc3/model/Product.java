package com.demo.springmvc3.model;

import com.demo.springmvc3.cofig.BeanUtil;
import com.demo.springmvc3.validation.GreaterThanTen;
import lombok.Data;
import org.ocpsoft.prettytime.PrettyTime;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

@Entity
@Data

@XmlRootElement
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


  public String getPrettyTime(){
    ZoneId defaultZoneId = ZoneId.systemDefault();
    PrettyTime prettyTime=(PrettyTime) BeanUtil.getBean(PrettyTime.class);
    return prettyTime.format(Date.from(lastUpdted.atStartOfDay(defaultZoneId)
            .toInstant()));
  }

}
