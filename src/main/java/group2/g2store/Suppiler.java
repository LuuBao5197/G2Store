/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package group2.g2store;

/**
 *
 * @author VICTUS
 */
public class Suppiler {
    private Integer SuppilerCode;
    private String  SuppilerName, email, address, phoneNumber;

    public Suppiler() {
    }

    public Suppiler(Integer SuppilerCode, String SuppilerName, String email, String address, String phoneNumber) {
        this.SuppilerCode = SuppilerCode;
        this.SuppilerName = SuppilerName;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public Integer getSuppilerCode() {
        return SuppilerCode;
    }

    public String getSuppilerName() {
        return SuppilerName;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setSuppilerCode(Integer SuppilerCode) {
        this.SuppilerCode = SuppilerCode;
    }

    public void setSuppilerName(String SuppilerName) {
        this.SuppilerName = SuppilerName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Suppiler{" + "SuppilerCode=" + SuppilerCode + ", SuppilerName=" + SuppilerName + ", email=" + email + ", address=" + address + ", phoneNumber=" + phoneNumber + '}';
    }

    
    
}
