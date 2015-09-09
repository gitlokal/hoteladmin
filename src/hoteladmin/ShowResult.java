/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hoteladmin;
import javax.swing.JTable;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author lokal
 */
public class ShowResult extends JPanel {
      String[] columnNames = {"First Name","Last Name","address", "city", "phone"};
            private SearchGuest search;
            private Object[][] data;
            private JTable table=new JTable();
            private DefaultTableModel model;
 
            public ShowResult(){

                
            }
            public ShowResult(String name, String lastName, String address, String city, String phone){
 
                data =  new Object[][]{ { name, lastName,  address,  city,  phone } };
                table = new JTable(data, columnNames);
                table.setRowHeight(25);
                this.setLayout(new BorderLayout());
                this.add(table.getTableHeader(), BorderLayout.PAGE_START);
                add(table);
            }

    public void setSearch(SearchGuest search1) {
       
        this.search = search1;
        data = new Object[][]{ { search.getName(), search.getLastName(), search.getStreet(), search.getCity(), search.getPhone() } };
        model = new DefaultTableModel(data, columnNames){
            
                @Override
                public boolean isCellEditable(int row, int column){
                     return false;
                }
        };
        
        table = new JTable(model);
        table.setModel(model);
        table.setRowHeight(25);
        
        this.setLayout(new BorderLayout());
        this.add(table.getTableHeader(), BorderLayout.PAGE_START); 
        
         add(table);
         table.getTableHeader().setReorderingAllowed(false);
         //table.setRowSelectionAllowed(false); needed?
         table.setCellSelectionEnabled(true);

    }
              
            
}
