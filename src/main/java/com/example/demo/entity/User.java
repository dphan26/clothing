package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "Users")
@Data
public class User {

    private int id;
    private String name;
    private String email;
    private String phone;
    private String address;
	private String password;
 
    public User() {
  
    }
 
  
 
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
        public int getId() {
        return id;
    }
   
    
  
 

 
}
