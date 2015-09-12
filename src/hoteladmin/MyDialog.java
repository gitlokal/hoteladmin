/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hoteladmin;
import java.awt.BorderLayout;  
import java.awt.Point;
import javax.swing.JDialog;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.JLabel;


/**
 *
 * @author lokal
 */
public class MyDialog extends JDialog {
    JButton button = new JButton("Ok");
      
    public MyDialog( Point point, String title, String message){
        this.setTitle(title);

        JPanel messagePane = new JPanel();
        JPanel buttonPane = new JPanel();
        messagePane.add(new JLabel(message));
        getContentPane().add(messagePane);
        buttonPane.add(button);
        getRootPane().setDefaultButton(button);
        
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLocation(point.x+400, point.y+200);

        button.addActionListener(new ActionListener() {
            
              @Override
              public void actionPerformed(ActionEvent e)
              {
                
                 setVisible(false);
                 dispose();

             }
         } );
        

        getContentPane().add(buttonPane, BorderLayout.PAGE_END);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setModal(true);
        pack();
        setVisible(true);

        
    }

}





