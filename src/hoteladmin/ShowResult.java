/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hoteladmin;
import javax.swing.JTable;
/**
 *
 * @author lokal
 */
public class ShowResult extends GuestForm {
      String[] columnNames = {"First Name",
                        "Last Name",
                        "address",
                        "city",
                        "phone"};
    
            private Object[][] data;
            JTable table;
            public ShowResult(String name, String lastName, String address, String city, String phone){
                super("tralal");
//                this.nameField.setText(name);
//                this.lastNameField.setText(lastName);
//                this.streetField.setText(address);
//                this.phoneField.setText(phone);
//                this.cityField.setText(city);
                
                data =  new Object[][]{ {name, lastName,  address,  city,  phone}};
                table = new JTable(data, columnNames);
                add(table);
            }
              
  
}
