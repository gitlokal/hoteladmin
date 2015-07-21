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

import javax.swing.*;
import java.awt.GridLayout;
import java.awt.event.*;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Session; 
import org.hibernate.Transaction;



public class GuestForm extends JPanel implements ActionListener {

        protected JTextField nameField, lastNameField, streetField, cityField, phoneField;
        protected final JLabel name = new JLabel("imię");
        protected final JLabel lastName = new JLabel("nazwisko");
        protected final JLabel address = new JLabel("adres");
        protected final JLabel city = new JLabel("miasto");
        protected final JLabel phone = new JLabel("nr tel.");
        protected JButton confirmButton;
        
        private Guest guest = new Guest();
            
        public GuestForm(String buttonName){
            nameField = new JTextField();
            lastNameField = new JTextField();
            streetField = new JTextField();
            cityField = new JTextField();
            phoneField = new JTextField();
            confirmButton= new JButton(buttonName);
            setSize(600,500);
            setLayout(new GridLayout(8,8));
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
                    guest.setName( nameField.getText() );
                    guest.setLastName( lastNameField.getText() );
                    guest.setStreet(streetField.getText());
                    guest.setCity( cityField.getText() );
                    guest.setPhone( phoneField.getText() );
                    
//                    SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
//                    Session session = sessionFactory.openSession();
//                    session.beginTransaction();
//                    session.save(guest);
//                    session.getTransaction().commit();
//                    session.close();
//                    System.out.println(guest.getName());
                    SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
                    Session session = sessionFactory.openSession();
                    Transaction trans = null;
                    trans = session.beginTransaction();
                    session.save(guest);
                    trans.commit();
                    session.close();
        }
     
}   
