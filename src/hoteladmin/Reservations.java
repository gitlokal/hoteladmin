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
import java.util.Date;  
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.search.annotations.Indexed;

 @Entity
 @Indexed
public class Reservations implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date res_from;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date res_to;
    
    private int room_nr;
    
    private String services;
    
    private float bill;
      
    public void setId(int id) {
        this.id = id;
    }

    public void setRes_from(Date res_from) {
        this.res_from = res_from;
    }

    public void setRes_to(Date res_to) {
        this.res_to = res_to;
    }

    public void setRoom_nr(int room_nr) {
        this.room_nr = room_nr;
    }

    public void setServices(String services) {
        this.services = services;
    }

    public void setBill(float bill) {
        this.bill = bill;
    }

    public int getId() {
        return id;
    }

    public Date getRes_from() {
        return res_from;
    }

    public Date getRes_to() {
        return res_to;
    }

    public int getRoom_nr() {
        return room_nr;
    }

    public String getServices() {
        return services;
    }

    public float getBill() {
        return bill;
    }
    
    
    
}
