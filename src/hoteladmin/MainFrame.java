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
public class MainFrame extends JFrame {
    
    public MainFrame(){
                super("Hotel Admin");
                setSize(650,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                setLayout(new FlowLayout());
                setVisible(true);
    }
}
