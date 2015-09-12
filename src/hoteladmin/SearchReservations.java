/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hoteladmin;

import java.io.Serializable;
import java.util.Date;  
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.search.annotations.Analyze;
import org.hibernate.search.annotations.DateBridge;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.Resolution;
import org.hibernate.search.annotations.Store;



/**
 *
 * @author lokal
 */
@Entity

@Table(name="RESERVATIONS")

public class SearchReservations implements Serializable {

    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    @Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
    @Temporal(TemporalType.TIMESTAMP)
   @DateBridge(resolution=Resolution.MINUTE)
    private Date resFrom;
    
    @Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
    @Temporal(TemporalType.TIMESTAMP)
    @DateBridge(resolution=Resolution.MINUTE)
    private Date resTo;
    
    @Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
    private Short roomNr;
     
    @Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
    private String services;
    
    @Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
    private int bill;
    
    @Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
    private int guest;
    
   
    
    //@Field(index=Index.YES, analyze=Analyze.NO, store=Store.NO)
    @ManyToOne
    @JoinColumn(name="GUEST")
    
    private SearchGuest searchGuest = new SearchGuest();

    public SearchGuest getSearchGuest() {   
        return searchGuest;
    }

    public void setSearchGuest(SearchGuest searchGuest) {
        this.searchGuest = searchGuest;
    }   
    
    public SearchReservations() {
    }

    public SearchReservations(Integer id) {
        this.id = id;
    }

    public SearchReservations(Integer id, Date resFrom, String services) {
        this.id = id;
        this.resFrom = resFrom;
        this.services = services;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getResFrom() {
        return resFrom;
    }

    public void setResFrom(Date resFrom) {
        this.resFrom = resFrom;
    }

    public Date getResTo() {
        return resTo;
    }

    public void setResTo(Date resTo) {
        this.resTo = resTo;
    }

    public Short getRoomNr() {
        return roomNr;
    }

    public int getGuest() {
        return guest;
    }

    public void setRoomNr(Short roomNr) {
        this.roomNr = roomNr;
    }

    public void setGuest(int guest) {
        this.guest = guest;
    }

    public String getServices() {
        return services;
    }

    public void setServices(String services) {
        this.services = services;
    }

    public Integer getBill() {
        return bill;
    }

    public void setBill(Integer bill) {
        this.bill = bill;
    }

}
