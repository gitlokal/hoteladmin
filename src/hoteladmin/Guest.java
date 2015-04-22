/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hoteladmin;

/**
 *
 * @author lokal
 */
public class Guest {
    private String name="empty";
    private String lastName="empty";
    private String address="empty";
    private String city="empty";
    private String phone="empty";
    
  public void setName(String name) {
       this.name=name;
  }
   
  public void setLastName(String lastName) {
       this.lastName=lastName;
  }
     
  public void setAddress(String addres) {
       this.address=address;
  }
     
  public void setCity(String city) {
       this.city=city;
  } 
   
  public void setPhone(String phone) {
       this.phone=phone;
  }
   
  
  public String getName(){
     return this.name; 
  }
  
  public String getLastName(){
     return this.lastName; 
  }
   
  public String getAddress(){
     return this.address; 
  }
  
  public String getCity(){
     return this.city; 
  }
  
  public String getPhone(){
     return this.phone; 
  }
    
}
