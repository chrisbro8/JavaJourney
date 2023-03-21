/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.theatre;

/**
 *
 * @author ehima
 */

import java.util.ArrayList;
public class  Ticket{
    public int  row;
    public int  seat;
    public double  price;
    private Person personk1;
    
    
    
    
    
    public  Ticket(int rownumber,int seatnumber,double pricenumber,Person personk1){
        this.row = rownumber;
        this.seat = seatnumber;
        this.price = pricenumber;
        this.personk1 = personk1;
       
        
        
    }
    
    public Ticket(Person personk1){
         this.personk1 = personk1;
        
        
    }
 
    public void setrow(int rownumber){
        this.row=rownumber;
    }
    public void setseat(int seatnumber){
        this.seat=seatnumber;
    }
    public void setprice(double pricenumber){
        this.price=pricenumber;
    }
    public void setPerson(Person personk1){
        this.personk1=personk1;
    }
    
    
    public int getrow(){
        return row;
    }
    public int getseat(){
        return seat;
    }
    public double  getprice(){
        return price;
    }
    public void print(){
        System.out.println("Your name is:"+personk1.name());
        System.out.println("Your Surname is:"+personk1.surname());
        System.out.println(" Your email is:"+personk1.email());
        System.out.println("The row seat is :"+row);
        System.out.println("The seat is:"+seat);
        System.out.println("The price is:"+price);
        
      
    
    }
    public void print2(){
      
        System.out.println("The row seat is :"+row);
        System.out.println("The seat is:"+seat);
        System.out.println("The price is:"+price);
        
      
    
    }
    
}
