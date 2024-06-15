/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package group2.g2store;

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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author VICTUS
 */
public class NhacungcapController implements Initializable {

    @FXML
    private Button btnHome;
    @FXML
    private TableView<Suppiler> tvSuppiler;
    @FXML
    private TableColumn<Suppiler, Integer> colSuppilerCode;
    @FXML
    private TableColumn<Suppiler, String> colSuppilerName;
    @FXML
    private TableColumn<Suppiler, String> colSuppilerAddress;
    @FXML
    private TableColumn<Suppiler, String> colSuppilerEmail;
    @FXML
    private TableColumn<Suppiler, String> colSuppilerPhonnumber;
    ConnectDB con;
     Connection cn;
    @FXML
    private TextField tfSuppilerCode;
    @FXML
    private TextField tfSuppilerName;
    @FXML
    private TextField tfSuppilerAddress;
    @FXML
    private TextField tfSuppilerEmail;
    @FXML
    private TextField tfSuppilerPhone;
    @FXML
    private Button btSuppilerAdd;
    @FXML
    private Button btSuppilerUpdate;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        con = new ConnectDB();
         cn = con.getConnect();
         showSuppilers();
    }    

    @FXML
    private void handleHome(MouseEvent event) {
    }
    

    public ObservableList getSuppilers()
    {
        
        //tao ds chua cac Product
        ObservableList<Suppiler> list = FXCollections.observableArrayList();
        //tao doi tuong
         list.clear();
        
        //viet cau lenh truy van
        String query = "SELECT * FROM Suppiler";
        
        //thuc thi
        Statement st;
        ResultSet rs;
        
        try {
            st = cn.createStatement();
            rs = st.executeQuery(query);
            Suppiler s;
            while(rs.next())
            {
                int SuppilerCode = rs.getInt("SuppilerCode");
                String SuppilerName = rs.getString("SuppilerName");
                String email = rs.getString("email");
                String address = rs.getString("address");
                String phoneNumber = rs.getString("phoneNumber");
                
                
                
                //tao doi tuong Suppiler
                s = new Suppiler(SuppilerCode, SuppilerName, email, address, phoneNumber);
                //System.out.println(s);
                list.add(s);
                
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductController.class.getName()).log(Level.SEVERE, null, ex);
        }
         
        return list;
    }

    public void showSuppilers()
    {
        ObservableList<Suppiler> sList = getSuppilers();
        
        //show ds ra tableview
        colSuppilerCode.setCellValueFactory(new PropertyValueFactory<>("SuppilerCode"));
        colSuppilerName.setCellValueFactory(new PropertyValueFactory<>("SuppilerName"));
        colSuppilerAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colSuppilerEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colSuppilerPhonnumber.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        
        tvSuppiler.setItems(sList);
    }
    
   
    
    private void executeSQL(String query)
    {
        Statement st;
        try {
            st = cn.createStatement();
            
            //thuc thi
            st.executeUpdate(query);
            
            //load du lieu
            showSuppilers();
        } catch (SQLException ex) {
            System.out.println("loi: " + ex.getMessage());
        }
    }
    private void addSuppiler(ActionEvent event) {
        //get gtri cua cua field
        int SuppilerCode  = Integer.parseInt(tfSuppilerCode.getText());
        String SuppilerName  = tfSuppilerName.getText();
        String address  = tfSuppilerAddress.getText();
        String email  = tfSuppilerEmail.getText();
        String phoneNumber  = tfSuppilerPhone.getText();
        
        String sql = "INSERT INTO Suppiler "
                + "VALUES('" + SuppilerCode + "'," +  "'" + SuppilerName + "'," + address + ",'" + email + " ,'" + phoneNumber + "')";
        
        //System.out.println(sql);
        executeSQL(sql);

    }

    private void onSelectSuppiler(MouseEvent event) {
        Suppiler s  = tvSuppiler.getSelectionModel().getSelectedItem();
        
        //xuat du lieu
        tfSuppilerCode.setText("" + s.getSuppilerCode());
        tfSuppilerName.setText(s.getSuppilerName());
        tfSuppilerAddress.setText(""+ s.getAddress());
        tfSuppilerEmail.setText(""+ s.getEmail());
        tfSuppilerPhone.setText(s.getPhoneNumber());
    }

    private void updateSuppiler(ActionEvent event) {
        //get gtri cua cua field
        int SuppilerCode  = Integer.parseInt(tfSuppilerCode.getText());
        String SuppilerName  = tfSuppilerName.getText();
        String address  = tfSuppilerAddress.getText();
        String email  = tfSuppilerEmail.getText();
        String phoneNumber  = tfSuppilerPhone.getText();
        
        String sql = "UPDATE Suppiler SET "
                + "name='" + SuppilerName + "',"
                + "price=" + address + ","
                + "email=" + email + ","
                + "phoneNumber='" + phoneNumber + "'"
                + "WHERE SuppilerCode='" + SuppilerCode + "'";
        
        //System.out.println(sql);
        executeSQL(sql);
        
        //load lai du lieu
        showSuppilers();
    }

    private void deleteSuppiler(ActionEvent event) {
        //get gtri cua cua field
        int SuppilerCode  = Integer.parseInt(tfSuppilerCode.getText());
        String SuppilerName  = tfSuppilerName.getText();
        String address  = tfSuppilerAddress.getText();
        String email  = tfSuppilerEmail.getText();
        String phoneNumber  = tfSuppilerPhone.getText();
        
        String sql = "DELETE FROM Suppiler  "
                + "WHERE SuppilerCode='" + SuppilerCode + "'";
        
        //System.out.println(sql);
        executeSQL(sql);
        
        //xoa du lieu
        reset();
        
        //load lai du lieu
        showSuppilers();
    }
    
    private void reset()
    {
        tfSuppilerCode.setText("");
        tfSuppilerName.setText("");
        tfSuppilerAddress.setText("");
        tfSuppilerEmail.setText("");
        tfSuppilerPhone.setText("");
    }
}
