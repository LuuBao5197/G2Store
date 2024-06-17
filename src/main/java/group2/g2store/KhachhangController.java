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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author VICTUS
 */
public class KhachhangController implements Initializable {

    @FXML
    private Button btnHome;
    @FXML
    private TableColumn<Customer, String> colCustomerId;
    @FXML
    private TableColumn<Customer, String> colCustomerName;
    @FXML
    private TableColumn<Customer, String> colCustomerPhone;
    @FXML
    private TableColumn<Customer, String> colCustomerDob;
    @FXML
    private TableColumn<Customer, Integer> colCustomerPoint;
    @FXML
    private TableView<Customer> tvCustomer;
    ConnectDB con;
     Connection cn;
    @FXML
    private AnchorPane viewCustomer;
    @FXML
    private AnchorPane formAddCustomer;
    @FXML
    private Button btnAddCustomer;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        con = new ConnectDB();
         cn = con.getConnect();
         showCustomers();
        
    }    

    @FXML
    private void handleHome(MouseEvent event) {
    }
    
    public ObservableList getCustomers()
    {
        
        //tao ds chua cac Product
        ObservableList<Customer> list = FXCollections.observableArrayList();
        //tao doi tuong
         list.clear();
        
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
                String customerPhone = rs.getString("CustomerPhone");
                String Dob = rs.getString("Dob");
                int Point = rs.getInt("Point");
                
                
                //tao doi tuong Customer
                c = new Customer(customerId, customerName, customerPhone, Dob, Point);
                //System.out.println(p);
                list.add(c);
                
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductController.class.getName()).log(Level.SEVERE, null, ex);
        }
         
        return list;
    }

    public void showCustomers()
    {
        ObservableList<Customer> cList = getCustomers();
        
        //show ds ra tableview
        colCustomerId.setCellValueFactory(new PropertyValueFactory<>("CustomerId"));
        colCustomerName.setCellValueFactory(new PropertyValueFactory<>("CustomerName"));
        colCustomerPhone.setCellValueFactory(new PropertyValueFactory<>("CustomerPhone"));
        colCustomerDob.setCellValueFactory(new PropertyValueFactory<>("Dob"));
        colCustomerPoint.setCellValueFactory(new PropertyValueFactory<>("Point"));
        
        tvCustomer.setItems(cList);
    }
    
   
    
    private void executeSQL(String query)
    {
        Statement st;
        try {
            st = cn.createStatement();
            
            //thuc thi
            st.executeUpdate(query);
            
            //load du lieu
            showCustomers();
        } catch (SQLException ex) {
            System.out.println("loi: " + ex.getMessage());
        }
    }

    @FXML
    private void showAddCustomer(ActionEvent event) {
        formAddCustomer.setVisible(true);
        viewCustomer.setVisible(false);
    }
}
