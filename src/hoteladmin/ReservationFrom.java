/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hoteladmin;

import com.toedter.calendar.JDateChooser;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;




/**
 *
 * @author lokal
 */
import java.util.Date;
public class ReservationFrom extends JPanel implements ActionListener {
        DateFormat format = new SimpleDateFormat("dd.MM.YY");
        //DateFormatter formatter = new DateFormatter(format);
    
        Date date = new Date();
        JDateChooser datechooser = new JDateChooser();
        JDateChooser datechooser2 = new JDateChooser();

        

        private final JTextField   roomNrField, servicesField, billField, guestField;
        private final JLabel resFrom = new JLabel("Od dnia");
        private final JLabel resTo = new JLabel("Do dnia");
        private final JLabel roomNr = new JLabel("Nr pokoju");
        private final JLabel services = new JLabel("usługi");
        private final JLabel bill = new JLabel("rachunek");
        private final JLabel guest = new JLabel("numer klienta");
        private final JButton confirmButton= new JButton("Wprowadz");
        private final int textFieldSize=8;
        private final Point point = roomNr.getLocation();
        private Reservations reservations = new Reservations();
        
        public ReservationFrom(){   
            
               datechooser.setDate(date);
               datechooser.setDateFormatString("dd.MM.YY");
               datechooser2.getDateEditor().addPropertyChangeListener(datechooser2);
               datechooser2.setDateFormatString("dd.MM.YY");
                
                roomNrField= new JTextField();
                roomNrField.setColumns(textFieldSize);
                
                servicesField = new JTextField();
                servicesField.setColumns(textFieldSize);
                
                billField = new JTextField();
                billField.setColumns(textFieldSize);
                
                guestField = new JTextField();
                guestField.setColumns(textFieldSize);
                
                add(resFrom);
                add(datechooser);
                add(resTo);
                add(datechooser2);
                add(roomNr);
                add(roomNrField);
                add(services);
                add(servicesField);
                add(bill);
                add(billField);
                add(guest);
                add(guestField);
                add(confirmButton);
                confirmButton.addActionListener(this);
                    
              
  


                
        
        }
        
        private void setting() throws ParseException {
                      
                        reservations.setRes_from( datechooser.getDate() );
                        reservations.setRes_to(  datechooser2.getDate() );
                        reservations.setRoom_nr( Integer.parseInt( roomNrField.getText() ) );
                        reservations.setServices( servicesField.getText() );
                        reservations.setGuest( Integer.parseInt( guestField.getText() ) );
                        System.out.println( reservations.getRes_to() );
                        System.out.println( datechooser2.getDate() );
            
        }
        @Override
        public void actionPerformed(ActionEvent event){
            if(  roomNrField.getText().isEmpty() || servicesField.getText().isEmpty() 
                    || billField.getText().isEmpty() || guestField.getText().isEmpty() ){
                          MyDialog dialog = new MyDialog(point, "BŁĄD", "Uzupelnij wszystkie pola");
              } else {
                           try{
                               setting();
                                 
                           }catch(ParseException PE){
                               MyDialog dialog = new MyDialog(point, "BŁĄD", "Parse Exception text do date");
                           }
                            

                        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
                        Session session = sessionFactory.openSession();
                        Transaction trans = null;
                        trans = session.beginTransaction();
                        session.save(reservations);
                        trans.commit();
                        session.close();
                     }
                            
                       
                    
        }
}
