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
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import org.hibernate.search.annotations.Indexed;



  @Entity
  @Indexed
public class Guest implements Serializable {
      
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    
    private String name="empty";
    
    
    private String lastName="empty";
    
  
    private String street="empty";
    
    
    private String city="empty";
    
   
    private String phone="empty";
    

  public void setId(int id) {
        this.id = id;
    }
    
  public void setName(String name) {
       this.name=name;
  }
   
  public void setLastName(String lastName) {
       this.lastName=lastName;
  }
     
  public void setStreet(String street) {
       this.street=street;
  }
     
  public void setCity(String city) {
       this.city=city;
  } 

  public int getId() {
        return id;
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
   
  public String getStreet(){
     return this.street; 
  }
  
  public String getCity(){
     return this.city; 
  }
  
  public String getPhone(){
     return this.phone; 
  }
    
}
