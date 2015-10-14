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
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import org.hibernate.search.annotations.Analyze;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Store;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.IndexedEmbedded;



@Entity
@Indexed
@Table(name="GUEST")
public class SearchGuest implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //@Column(name="ID", unique=true)
    private int id;
    
   
    @Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
    private String name;
    
    @Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
    private String lastName;
    
    @Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
    private String street;
    
    @Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
    private String city;
    
    @Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
    private String phone;
    
   
//    @OneToMany(mappedBy="searchGuest")
//    @Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
//   
//    private List<SearchReservations> searchReservations = new ArrayList<>();
//    
//  
//
//    public List<SearchReservations> getSearchReservations() {
//        return searchReservations;
//    }
//
//    public void setSearchReservations(List<SearchReservations> searchReservations) {
//        this.searchReservations = searchReservations;
//    }
//
//    

  
    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
    
   
    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    
    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getPhone() {
        return phone;
    }
    

}
