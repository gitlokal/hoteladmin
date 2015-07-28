/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in th  e editor.
 */
package hoteladmin;

/**
 *
 * @author lokal
 */

import javax.swing.*;
import java.util.List;
import java.awt.event.*;
import java.util.Iterator;
import java.lang.InterruptedException;
import org.apache.lucene.index.CorruptIndexException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.search.FullTextSession;
import org.hibernate.search.Search;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.hibernate.search.store.DirectoryProvider;  

public class SearchPanel extends GuestForm  {
    
        protected JTextField reservationField;
        protected JLabel reservation = new JLabel("nr rez.");
        private SearchGuest searchGuest = new SearchGuest();
    public SearchPanel(){
        super("szukaj");
        reservationField = new JTextField();
        reservationField.setColumns(8);
        this.add(reservation);
        this.add(reservationField);
        this.add(confirmButton);
        
       
        
        
        
    }   
    
    @Override
    public void actionPerformed(ActionEvent event){
                    searchGuest.setName( nameField.getText() );
                    searchGuest.setLastName( lastNameField.getText() );
                    searchGuest.setStreet(streetField.getText());
                    searchGuest.setCity( cityField.getText() );
                    searchGuest.setPhone( phoneField.getText() );
                    try{
                        searchingData();
                    } catch(InterruptedException IE){
                        System.out.println("blad1");
                        
                    } catch(CorruptIndexException CE){
                        System.out.println("blad2");
                    }
              
                    
    }
    private void searchingData() throws CorruptIndexException, InterruptedException {
                    SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
                    Session session = sessionFactory.openSession();
                    FullTextSession fullTextSession = Search.getFullTextSession(session);
                    fullTextSession.createIndexer().startAndWait();
                    final QueryBuilder b = fullTextSession.getSearchFactory().buildQueryBuilder().forEntity( SearchGuest.class ).get();

                    org.apache.lucene.search.Query luceneQuery = b.keyword().onField("name").boostedTo(3).matching( searchGuest.getName() ).createQuery();
                    org.hibernate.Query fullTextQuery = fullTextSession.createFullTextQuery( luceneQuery );
                    List result = (List) fullTextQuery.list(); //return a list of managed objects, do zmiany
                    //fullTextQuery.getFirstResult();
                    Iterator it = fullTextQuery.list().iterator();
                    while(it.hasNext()){
                        SearchGuest search1 = (SearchGuest) it.next();
                        System.out.print(search1.getPhone());
                    }
                    session.close();
    }
}
