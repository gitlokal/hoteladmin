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

import java.awt.Point;
import javax.swing.*;
import java.awt.event.*;
import java.util.Iterator;
import java.lang.InterruptedException;
import java.io.IOException;
import org.apache.lucene.index.CorruptIndexException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.search.FullTextSession;
import org.hibernate.search.Search;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.search.Query;
import org.hibernate.search.exception.EmptyQueryException;


public class SearchPanel extends GuestForm  {
    
        protected JTextField reservationField;
        protected JLabel reservation = new JLabel("nr rez.");
        private SearchGuest searchGuest = new SearchGuest();
        
        private SearchGuest search1;
        private ShowResult showResult= new ShowResult();
        private IndexWriter indexWriter;
        private Point point = reservation.getLocation();
        public SearchPanel(){
        super("szukaj");
        reservationField = new JTextField();
        reservationField.setColumns(8);
        this.add(reservation);
        this.add(reservationField);
        this.add(confirmButton);
        this.add(showResult);
        nameField.addActionListener(this);
     
 
        
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
                        MyDialog dialog = new MyDialog(point, "BŁĄD", "przerwany index");
                        
                    } catch(CorruptIndexException CE){
                        
                        MyDialog dialog = new MyDialog(point, "BŁĄD", "Index zajęty");
                        
                    } catch(IOException IO) {
                        
                        MyDialog dialog = new MyDialog(point, "BŁĄD", "Błąd I/O");
                        
                    } catch (EmptyQueryException EQ){
                        MyDialog dialog = new MyDialog(point, "BŁĄD", "nieprawdiłowe zapytanie");
                             
                    }
              
                    
    }
    
    
    private void searchingData() throws CorruptIndexException, InterruptedException, IOException, EmptyQueryException {

                            SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
                            Session session = sessionFactory.openSession();

                            FullTextSession fullTextSession = Search.getFullTextSession(session);
                            fullTextSession.createIndexer().startAndWait();
                            
                            final QueryBuilder b = fullTextSession.getSearchFactory().buildQueryBuilder().forEntity( SearchGuest.class ).get();
                            
                           
                                Query luceneQuery = b.keyword().onField("name").boostedTo(1).matching( searchGuest.getName() ).createQuery();
                                
                          
                            
                            org.hibernate.Query fullTextQuery = fullTextSession.createFullTextQuery( luceneQuery );
                            
                            Iterator it = fullTextQuery.list().iterator();

                            sessionFactory.close();

                            while(it.hasNext()){
                                search1 = (SearchGuest) it.next();
                               // System.out.print(search1.getPhone()+ " " +search1.getLastName());

                                
                                     
                                 
                                 System.out.println(search1.getName()+search1.getLastName()+ search1.getStreet()+ search1.getCity()+ search1.getPhone());
                                 
                                 
  
                             }
                                
                             showResult.setSearch(search1 );
                             showResult.revalidate();
                              
                    
                 
                     
    }
    
     
  
    
}
