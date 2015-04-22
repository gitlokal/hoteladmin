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
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MenuBar extends JFrame {
 
  
  private JMenuBar menuBar;
  private JMenu menu;
  
 
 
    
   public MenuBar(String menuTitle, String menuItem){
       super();
       menuBar= new JMenuBar();
       menu= new JMenu(menuTitle);
        menu.setMnemonic(KeyEvent.VK_A);
        menu.getAccessibleContext().setAccessibleDescription(menuItem);
        menuBar.add(menu);
        this.setJMenuBar(menuBar);
        setVisible(true);
   }
 
   
}
