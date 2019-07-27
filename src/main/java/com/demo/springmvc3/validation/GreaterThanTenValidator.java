/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.springmvc3.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class GreaterThanTenValidator implements ConstraintValidator<GreaterThanTen,Integer>{

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
            return value >= 10;
    }
    
}
