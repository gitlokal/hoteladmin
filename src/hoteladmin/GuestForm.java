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

import java.awt.Point;
import javax.swing.*;
import java.awt.event.*;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Session; 
import org.hibernate.Transaction;



public class GuestForm extends JPanel implements ActionListener {

        private JTextField nameField, lastNameField, streetField, cityField, phoneField;
        private final JLabel name = new JLabel("imię");
        private final JLabel lastName = new JLabel("nazwisko");
        private final JLabel address = new JLabel("adres");
        private final JLabel city = new JLabel("miasto");
        private final JLabel phone = new JLabel("nr tel.");
        private JButton confirmButton;
        private final int textFieldSize=8;
        private Point point = lastName.getLocation();
        private Guest guest = new Guest();
        
        
       
        public GuestForm(String buttonName){
            nameField = new JTextField();
            nameField.setColumns(textFieldSize);
            lastNameField = new JTextField();
            lastNameField.setColumns(textFieldSize);
            streetField = new JTextField();
            streetField.setColumns(textFieldSize);
            cityField = new JTextField();
            cityField.setColumns(textFieldSize);
            phoneField = new JTextField();
            phoneField.setColumns(textFieldSize);
 
            confirmButton= new JButton(buttonName);
            this.add(name);
            this.add(nameField);
            this.add(lastName);
            this.add(lastNameField);
            this.add(address);
            this.add(streetField);
            this.add(phone);
            this.add(phoneField);
            this.add(city);
            this.add(cityField);


            this.add(confirmButton);
            confirmButton.addActionListener(this);
            
            
            
        }
          

            
        @Override
        public void actionPerformed(ActionEvent event){
            if(nameField.getText().isEmpty() || lastNameField.getText().isEmpty() || streetField.getText().isEmpty() || cityField.getText().isEmpty() 
                    || phoneField.getText().isEmpty() ){
                          MyDialog dialog = new MyDialog(point, "BŁĄD", "Uzupelnij wszystkie pola");
              } else {
                            guest.setName( nameField.getText() );
                            guest.setLastName( lastNameField.getText() );
                            guest.setStreet(streetField.getText());
                            guest.setCity( cityField.getText() );
                            guest.setPhone( phoneField.getText() );
                            

                        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
                        Session session = sessionFactory.openSession();
                        Transaction trans = null;
                        trans = session.beginTransaction();
                        session.save(guest);
                        trans.commit();
                        session.close();
                     }
                            
                       
                    
        }
     
}   
