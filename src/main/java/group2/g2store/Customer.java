/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package group2.g2store;

/**
 *
 * @author VICTUS
 */
public class Customer {
    private String customerId, customerName;
    private float customerPhone, Dob, Point;

    public Customer() {
    }

    public Customer(String customerId, String customerName, float customerPhone, float Dob, float Point) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerPhone = customerPhone;
        this.Dob = Dob;
        this.Point = Point;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public float getCustomerPhone() {
        return customerPhone;
    }

    public float getDob() {
        return Dob;
    }

    public float getPoint() {
        return Point;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setCustomerPhone(float customerPhone) {
        this.customerPhone = customerPhone;
    }

    public void setDob(float Dob) {
        this.Dob = Dob;
    }

    public void setPoint(float Point) {
        this.Point = Point;
    }

    @Override
    public String toString() {
        return "Customer{" + "customerId=" + customerId + ", customerName=" + customerName + ", customerPhone=" + customerPhone + ", Dob=" + Dob + ", Point=" + Point + '}';
    }
    
    
}
