/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hoteladmin;
import java.awt.BorderLayout;
import java.util.List;
import javax.swing.JTable;
import javax.swing.JPanel;

import javax.swing.table.DefaultTableModel;


/**
 *
 * @author lokal
 */
public class ShowResult extends JPanel {
      String[] columnNames = {"First Name","Last Name","address", "city", "phone"};
      String[] columnNamesRes = { "nr rezerwacji", "rezerwacja od", "rezerwacja do", "pokój nr", "usługi", "rachunek", "nr klienta"};
            private Object[][] data;
            private Object[] resData;
            private Object[] resData2;
            private JTable table;
            private JTable table2;
            private DefaultTableModel model= new DefaultTableModel(){
                    @Override
                    public boolean isCellEditable(int row, int column){
                         return false;
                    }
            };

            public ShowResult(){
                this.setLayout(new BorderLayout());
            }
            
            public void setSearch(List<SearchReservations> tmpList){
                    model.setColumnIdentifiers( columnNamesRes );
                    model.fireTableDataChanged();
                    table = new JTable( model );
                    table.setLayout( new BorderLayout() );
                    model.setRowCount(0);
                    
                    for(SearchReservations it : tmpList){
                            resData = new Object[]{ it.getId(), it.getResFrom(), it.getResTo(), it.getRoomNr(), 
                                                        it.getServices(), it.getBill(), it.getGuest() };
                          
                            model.addRow(resData);

                    }
                    table.setRowHeight(25);
                    table.getColumnModel().getColumn( 1 ).setPreferredWidth(150);
                    table.getColumnModel().getColumn( 2).setPreferredWidth(150);
                    table.getColumnModel().getColumn( 4 ).setPreferredWidth(150);

                    this.add(table.getTableHeader(), BorderLayout.PAGE_START);
                    table.getTableHeader().setReorderingAllowed(false);
                    table.setCellSelectionEnabled(true);
                    add(table);
                    
       }
   

            public void setSearch( SearchGuest searchGuest ) {
                    data = new Object[][]{ { searchGuest.getName(), searchGuest.getLastName(), searchGuest.getStreet(), searchGuest.getCity(), searchGuest.getPhone() } };
                    table2 = new JTable();
                    model.setDataVector( data, columnNames );  
                    model.fireTableDataChanged();
                    table2.setModel( model );
                    table2.setRowHeight( 25 );

                    table2.getColumnModel().getColumn( 0 ).setPreferredWidth(150);
                    table2.getColumnModel().getColumn( 1 ).setPreferredWidth(150);
                    table2.getColumnModel().getColumn( 2 ).setPreferredWidth(150);
                    table2.getColumnModel().getColumn( 3 ).setPreferredWidth(150);
                    table2.getColumnModel().getColumn( 4 ).setPreferredWidth(150);
                    this.add(table2.getTableHeader(), BorderLayout.PAGE_START); 

                    add(table2);
                    table2.getTableHeader().setReorderingAllowed(false);
                    table2.setCellSelectionEnabled(true);

            }
              
}
