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
public class MainFrame extends JFrame implements  ActionListener  {
    private JTabbedPane tabbedPane;
    private  JComponent panel1;
    private GuestForm guest;
    private SearchPanel searchPanel;
   
    public MainFrame(){
                super("Hotel Admin");
                this.setSize(1100,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                guest = new GuestForm("zatwierdz");
                searchPanel= new SearchPanel(); 
                searchPanel.setLayout(new FlowLayout( FlowLayout.LEADING));
                add(searchPanel);
                setVisible(true);
                   
                
    }
    
    
    public void actionPerformed(ActionEvent klik){
        
    }
}
