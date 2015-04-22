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
public class MainFrame extends JFrame {
     private JMenuBar menuBar;
     private JMenu menuGuest, menuReserv, menuRooms;
    public MainFrame(){
                super("Hotel Admin");
                menuBar= new JMenuBar();
                menuGuest= new JMenu("Goście");
                menuReserv = new JMenu("Rezerwacje");
                menuRooms = new JMenu("Pokoje");
                
                setSize(650,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                setLayout(new FlowLayout());
                
                menuGuest.setMnemonic(KeyEvent.VK_A);
                menuReserv.setMnemonic(KeyEvent.VK_A);
                menuRooms.setMnemonic(KeyEvent.VK_A);
                
                menuBar.add(menuGuest);
                menuBar.add(menuRooms);
                menuBar.add(menuReserv)
                        ;
                this.setJMenuBar(menuBar);
                 setVisible(true);
                
    }
    
}
