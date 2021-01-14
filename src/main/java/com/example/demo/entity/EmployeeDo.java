package com.example.demo.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "employeesDos")
@Data
public class EmployeeDo {

    private long id;
    private String firstNameDo;
    private String lastNameDoo;
   
    
 
    public EmployeeDo() {
  
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
        public long getId() {
        return id;
    }

	
   
}
