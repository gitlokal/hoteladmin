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
import java.awt.FlowLayout;
import java.awt.event.*;
import java.awt.BorderLayout;



public class MainFrame extends JFrame implements  ActionListener  {
    private JTabbedPane tabbedPane;
    private  JComponent panel1;
    private GuestForm guest;
    private SearchPanelTmp searchPanelTmp; 
    private ReservationFrom reservationFrom;
    private JButton searchButton = new JButton("Szukaj");
    private JButton newGuest = new JButton("Nowy klient");
    private JButton newReservation = new JButton("Nowa rezerwacja");
    private JPanel buttons;
 
   
   
    public MainFrame(){
                super("Hotel Admin");
                this.setSize(1100,400);
                FlowLayout flowLayout = new FlowLayout(5);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                
                guest = new GuestForm("Dodaj");
                guest.setLayout(flowLayout);
                
                searchPanelTmp= new SearchPanelTmp(); 
                searchPanelTmp.setLayout(flowLayout);
                newReservation.setLayout(flowLayout); 
                
                reservationFrom= new ReservationFrom();
                this.setLayout(new BorderLayout());
                
                buttons = new JPanel();
                buttons.add(searchButton);
                buttons.add(newGuest);
                buttons.add(newReservation);
                this.add(buttons, BorderLayout.PAGE_START);

                
               
                setVisible(true);
                searchButton.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e){
                        guest.setVisible(false);
                        reservationFrom.setVisible(false);
                        add(searchPanelTmp);
                        
                        searchPanelTmp.setVisible(true);
                        searchPanelTmp.revalidate();

                    }
                
                });
                
                newGuest.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e){
                        searchPanelTmp.setVisible(false);
                        reservationFrom.setVisible(false);
                        add(guest);
                        guest.setVisible(true);
                        guest.revalidate();

                    }
                
                });
                
                newReservation.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e){
                        searchPanelTmp.setVisible(false);
                        guest.setVisible(false);
                        add(reservationFrom);
                        reservationFrom.setVisible(true);
                        reservationFrom.revalidate();

                    }
                
                });
    }
    
    
    public void actionPerformed(ActionEvent klik){
     
        
    }
}
