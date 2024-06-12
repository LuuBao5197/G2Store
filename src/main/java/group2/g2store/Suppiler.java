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
    private String SuppilerCode, SuppilerName, email;
    private float address, phoneNumber;

    public Suppiler() {
    }

    public Suppiler(String SuppilerCode, String SuppilerName, String email, float address, float phoneNumber) {
        this.SuppilerCode = SuppilerCode;
        this.SuppilerName = SuppilerName;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public String getSuppilerCode() {
        return SuppilerCode;
    }

    public String getSuppilerName() {
        return SuppilerName;
    }

    public String getEmail() {
        return email;
    }

    public float getAddress() {
        return address;
    }

    public float getPhoneNumber() {
        return phoneNumber;
    }

    public void setSuppilerCode(String SuppilerCode) {
        this.SuppilerCode = SuppilerCode;
    }

    public void setSuppilerName(String SuppilerName) {
        this.SuppilerName = SuppilerName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(float address) {
        this.address = address;
    }

    public void setPhoneNumber(float phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Suppiler{" + "SuppilerCode=" + SuppilerCode + ", SuppilerName=" + SuppilerName + ", email=" + email + ", address=" + address + ", phoneNumber=" + phoneNumber + '}';
    }
    
    
}
