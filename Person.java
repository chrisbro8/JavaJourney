/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.theatre;

/**
 *
 * @author ehima
 */
import java.util.*;

public class Person {
    public String name;
    public String surname;
    public String email;
    
    public Person(String name,String surname,String email){
        this.name=name;
        this.surname=surname;
        this.email=email;
        
        
    }
    public Person(){
        
        
        
    }
    public String name(){
        return name;
    }
    public String surname(){
        return surname;
    }
    public String email(){
        return email;
    }
    public void setname(String name){
        this.name=name;
    }
     public void setsurname(String surname){
        this.surname=surname;
    }
      public void setemail(String email){
        this.email=email;
    }
}
