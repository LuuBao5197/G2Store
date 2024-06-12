/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package group2.g2store;

import java.sql.*;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author VICTUS
 */
public class KhachhangController implements Initializable {

    @FXML
    private Button btnHome;
    @FXML
    private TableColumn<?, ?> colCustomerId;
    @FXML
    private TableColumn<?, ?> colCustomerName;
    @FXML
    private TableColumn<?, ?> colCustomerPhone;
    @FXML
    private TableColumn<?, ?> colCustomerDob;
    @FXML
    private TableColumn<?, ?> colCustomerPoint;
    @FXML
    private TableView<?> tvCustomer;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleHome(MouseEvent event) {
    }
    
    public ObservableList getCustomers()
    {
        
        //tao ds chua cac Product
        ObservableList<Customer> list = FXCollections.observableArrayList();
        //tao doi tuong
        ConnectDB con = new ConnectDB();
        Connection cn = con.getConnect();
        
        //viet cau lenh truy van
        String query = "SELECT * FROM Customer";
        
        //thuc thi
        Statement st;
        ResultSet rs;
        
        try {
            st = cn.createStatement();
            rs = st.executeQuery(query);
            Customer c;
            while(rs.next())
            {
                String customerId = rs.getString("CustomerId");
                String customerName = rs.getString("CustomerName");
                float customerPhone = rs.getFloat("CustomerPhone");
                float Dob = rs.getFloat("Dob");
                float Point = rs.getFloat("Point");
                
                
                //tao doi tuong Customer
                c = new Customer(customerId, customerName, customerPhone, Dob, Point);
                //System.out.println(p);
                
                
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductController.class.getName()).log(Level.SEVERE, null, ex);
        }
         
        return list;
    }

    public void showProducts()
    {
        ObservableList<Customer> cList = getCustomers();
        
        //show ds ra tableview
        colCustomerId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colCustomerName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colCustomerPhone.setCellValueFactory(new PropertyValueFactory<>("price"));
        colCustomerDob.setCellValueFactory(new PropertyValueFactory<>("image"));
        colCustomerPoint.setCellValueFactory(new PropertyValueFactory<>("image"));
        
        //tvCustomer.setItems(cList);
    }
    
   
    
    private void executeSQL(String query)
    {
        ConnectDB con = new ConnectDB();
        Connection cn = con.getConnect();
        
        Statement st;
        try {
            st = cn.createStatement();
            
            //thuc thi
            st.executeUpdate(query);
            
            //load du lieu
            showProducts();
        } catch (SQLException ex) {
            System.out.println("loi: " + ex.getMessage());
        }
    }
}
