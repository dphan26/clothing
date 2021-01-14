package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "employees")
@Data
public class Employee {

    private long id;
    private String firstName;
    private String lastName;
    private String emailId;
    private String address;
 
    public Employee() {
  
    }
 
    public Employee(String firstName, String lastName, String emailId) {
         this.firstName = firstName;
         this.lastName = lastName;
         this.emailId = emailId;
    }
 
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
        public long getId() {
        return id;
    }
   
    
  
 

 
}
