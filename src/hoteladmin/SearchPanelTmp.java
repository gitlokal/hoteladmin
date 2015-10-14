/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hoteladmin;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import org.apache.lucene.index.CorruptIndexException;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.search.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.search.FullTextSession;
import org.hibernate.search.Search;
import org.hibernate.search.exception.EmptyQueryException;
import org.hibernate.search.query.dsl.QueryBuilder;
    


/**
 *
 * @author lokal
 */
public class SearchPanelTmp extends JPanel {
 
        private JTextField nameField, lastNameField, cityField, phoneField, roomNrField;
        private final JButton confirmButton = new JButton("wyczysc");
        private final JLabel lastName = new JLabel("nazwisko");
        private final JLabel phone = new JLabel("nr tel.");
        private final JLabel roomNr = new JLabel("pok.nr");
        private final int textFieldSize = 8;
        protected JTextField reservationField;
        protected JLabel reservation = new JLabel("nr. rez.");
        private SearchGuest searchGuest = new SearchGuest();
        private JPanel tables;
        
        private SearchReservations searchRes= new SearchReservations();
         
        private ShowResult showResult= new ShowResult();   
        private ShowResult ResShowResult= new ShowResult();
        
        private IndexWriter indexWriter;
        private Point point = reservation.getLocation();
        private FlowLayout flowLay = new FlowLayout( FlowLayout.TRAILING);
        
        public SearchPanelTmp(){    
 
 
        reservationField = new JTextField();
        
        reservationField.setColumns(textFieldSize);
        lastNameField = new JTextField();
        lastNameField.setColumns(textFieldSize);
        phoneField = new JTextField();
        phoneField.setColumns(textFieldSize);
        roomNrField = new JTextField();
        roomNrField.setColumns(textFieldSize);
        
        tables = new JPanel();
        this.add(lastName);
        this.add(lastNameField);
        this.add(phone);
        this.add(phoneField);
        this.add(roomNr);
        this.add(roomNrField);
        this.add(reservation);
        this.add(reservationField);
        this.add(confirmButton);
            
        
        tables.setLayout( new GridBagLayout() );
        GridBagConstraints gBC = new GridBagConstraints();
        gBC.fill = GridBagConstraints.HORIZONTAL;
        gBC.gridx = 0;
        gBC.gridy = 0;
        tables.add( showResult, gBC ) ;
       
        gBC.fill = GridBagConstraints.HORIZONTAL;
        gBC.gridx = 0;
        gBC.gridy = 1;
        tables.add( new JScrollPane( ResShowResult ), gBC );
        
        this.add( tables );
        

        lastNameField.addActionListener(new ActionListener(){
            
              @Override
              public void actionPerformed(ActionEvent e)
              {
                           showResult.removeAll();
                           ResShowResult.removeAll();
                           ResShowResult.revalidate();
                           tables.repaint();
                           if(!lastNameField.getText().isEmpty()){
                                try{
                                    int tmp = guestQuery("lastName", lastNameField.getText());
                                     if(  tmp != -1 )
                                             reservationsQuery("guest", tmp);

                                } catch(InterruptedException IE){
                                    MyDialog dialog = new MyDialog(point, "BŁĄD", "przerwany index");

                                } catch(CorruptIndexException CE){

                                    MyDialog dialog = new MyDialog(point, "BŁĄD", "Index zajęty");

                                } catch(IOException IO) {

                                    MyDialog dialog = new MyDialog(point, "BŁĄD", "Błąd I/O");

                                } catch (EmptyQueryException EQ){
                                    MyDialog dialog = new MyDialog(point, "BŁĄD", "nieprawdiłowe zapytanie");

                                }

                            lastNameField.setText("");
                            phoneField.setText("");
                            roomNrField.setText("");
                            reservationField.setText("");
                           } else{
                                MyDialog dialog = new MyDialog(point, "BŁĄD", "fraza za krótka");
                           }
                              
             }
               
        });
            
      
        phoneField.addActionListener(new ActionListener(){
            
              @Override
              public void actionPerformed(ActionEvent e)
              {
                           showResult.removeAll();
                           ResShowResult.removeAll();
                           if(!phoneField.getText().isEmpty()){
                                try{
                                    int tmp = guestQuery("phone", phoneField.getText());
                                     if(  tmp != -1 )
                                         reservationsQuery("guest", tmp);

                                } catch(InterruptedException IE){
                                    MyDialog dialog = new MyDialog(point, "BŁĄD", "przerwany index");

                                } catch(CorruptIndexException CE){

                                    MyDialog dialog = new MyDialog(point, "BŁĄD", "Index zajęty");

                                } catch(IOException IO) {

                                    MyDialog dialog = new MyDialog(point, "BŁĄD", "Błąd I/O");

                                } catch (EmptyQueryException EQ){
                                    MyDialog dialog = new MyDialog(point, "BŁĄD", "nieprawdiłowe zapytanie");

                                }

                                lastNameField.setText("");
                                phoneField.setText("");
                                roomNrField.setText("");
                                reservationField.setText("");
                           }else{
                                MyDialog dialog = new MyDialog(point, "BŁĄD", "fraza za krótka");
                           }
                          

             }
               
        });
        roomNrField.addActionListener(new ActionListener(){
            
              @Override
              public void actionPerformed(ActionEvent e)
              {
                           showResult.removeAll();
                           ResShowResult.removeAll();
                           if(!roomNrField.getText().isEmpty()){
                             try{

                                    int tmp = reservationsQuery( "room_Nr", Integer.parseInt( roomNrField.getText() ) );
                                     if(  tmp != -1 )
                                         guestQuery( "id", Integer.toString(tmp) );

                                } catch(InterruptedException IE){
                                    MyDialog dialog = new MyDialog(point, "BŁĄD", "przerwany index");

                                } catch(CorruptIndexException CE){

                                    MyDialog dialog = new MyDialog(point, "BŁĄD", "Index zajęty");

                                } catch(IOException IO) {

                                    MyDialog dialog = new MyDialog(point, "BŁĄD", "Błąd I/O");

                                } catch (EmptyQueryException EQ){
                                    MyDialog dialog = new MyDialog(point, "BŁĄD", "nieprawdiłowe zapytanie");

                                }
                 
                            lastNameField.setText("");
                            phoneField.setText("");
                            roomNrField.setText("");
                            reservationField.setText("");
                           }else{
                                MyDialog dialog = new MyDialog(point, "BŁĄD", "fraza za krótka");
                           }
                        

             }
               
        });
        reservationField.addActionListener(new ActionListener(){
            
              @Override
              public void actionPerformed(ActionEvent e)
              {
                           showResult.removeAll();
                           ResShowResult.removeAll();
                           if(!reservationField.getText().isEmpty()){
                                try{

                                      int tmp = reservationsQuery( "id",  Integer.parseInt( reservationField.getText() )  );
                                       if(  tmp != -1 )
                                           guestQuery("id", Integer.toString(tmp));

                                  } catch(InterruptedException IE){
                                      MyDialog dialog = new MyDialog(point, "BŁĄD", "przerwany index");

                                  } catch(CorruptIndexException CE){

                                      MyDialog dialog = new MyDialog(point, "BŁĄD", "Index zajęty");

                                  } catch(IOException IO) {

                                      MyDialog dialog = new MyDialog(point, "BŁĄD", "Błąd I/O");

                                  } catch (EmptyQueryException EQ){
                                      MyDialog dialog = new MyDialog(point, "BŁĄD", "nieprawdiłowe zapytanie");

                                  }

                              lastNameField.setText("");
                              phoneField.setText("");
                              roomNrField.setText("");
                              reservationField.setText("");
                           }else{
                                MyDialog dialog = new MyDialog(point, "BŁĄD", "fraza za krótka");
                           }
                       

             }
               
        });
   
     
       confirmButton.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e){
                           showResult.removeAll();
                           showResult.revalidate();
                           ResShowResult.removeAll();
                           ResShowResult.revalidate();

                    }
                
                });
       
    
        
    }   

    private int guestQuery(String searchOnField, String phrase) throws CorruptIndexException, InterruptedException, IOException, EmptyQueryException {

                             
                               SearchGuest searchGuestTmp= new SearchGuest() ;

                               SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
                               Session session = sessionFactory.openSession();

                               FullTextSession fullTextSession = Search.getFullTextSession(session);
                               fullTextSession.createIndexer().startAndWait();
                            
                            
                                QueryBuilder b = fullTextSession.getSearchFactory().buildQueryBuilder().forEntity( SearchGuest.class ).get();
                                Query luceneQuery = b.keyword().onField( searchOnField ).boostedTo(1).matching( phrase ).createQuery();
                                org.hibernate.Query fullTextQuery = fullTextSession.createFullTextQuery( luceneQuery, SearchGuest.class );

                                if( !fullTextQuery.list().isEmpty() ){
                                     Iterator it = fullTextQuery.list().iterator();
                                    
                                     while(it.hasNext()){ 
                                           searchGuestTmp = (SearchGuest) it.next();
                                           System.out.println(searchGuestTmp.getId()+ " "+searchGuestTmp.getName()+" "+searchGuestTmp.getLastName()+ " " 
                                                + searchGuestTmp.getStreet()+" "+ searchGuestTmp.getCity()+" "+ searchGuestTmp.getPhone());
                                       
                                    }
                                    sessionFactory.close();
                                    showResult.setSearch(searchGuestTmp );
                                    showResult.revalidate();
                                    
                                    return searchGuestTmp.getId();
                           

                                }else {
                                        sessionFactory.close();
                                        if(!lastNameField.getText().isEmpty() || !phoneField.getText().isEmpty()){
                                            MyDialog dialog = new MyDialog(point, "BŁĄD", "Brak pasujących wyników");
                                        }
                                        
                                         return -1;
                                }
                            

    }
   
   private int reservationsQuery( String searchOnField, int phrase)throws CorruptIndexException, InterruptedException, IOException, EmptyQueryException{
                              List<SearchReservations> tmpList = new ArrayList<>();
                              SearchReservations searchResTmp= new SearchReservations();
                              SessionFactory sessionFactory2 = new Configuration().configure().buildSessionFactory();
                              Session session2 = sessionFactory2.openSession();
                              FullTextSession fullTextSession2 = Search.getFullTextSession(session2 );
                              fullTextSession2.createIndexer().startAndWait();

                              QueryBuilder b2 = fullTextSession2.getSearchFactory().buildQueryBuilder().forEntity( SearchReservations.class ).get();
                              Query luceneQuery2 = b2.keyword().onField( searchOnField ).boostedTo(1).matching( phrase    ).createQuery();
                              org.hibernate.Query fullTextQuery2 = fullTextSession2.createFullTextQuery( luceneQuery2, SearchReservations.class );

                              if( !fullTextQuery2.list().isEmpty() ){
                                  Iterator it = fullTextQuery2.list().iterator();
                                  while(it.hasNext()){
                                      searchResTmp = (SearchReservations) it.next();
                                      tmpList.add(searchResTmp);

                                  }
                                  
                                  sessionFactory2.close();
                                  ResShowResult.removeAll();
                                  ResShowResult.revalidate();
                                  ResShowResult.setSearch( tmpList );
                                  ResShowResult.revalidate();
                                  return searchResTmp.getGuest();
     
                              } else {
                                      sessionFactory2.close();
                                      if(!reservationField.getText().isEmpty()){
                                           MyDialog dialog = new MyDialog(point, "BŁĄD", "Brak pasujących wyników");
                                           
                                      }

                                        return -1;
                                }

       
   }
  
}
