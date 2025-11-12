package com.wecaremeals.dto;

public class Ngo {
    private int ngoId;
    private String name;
    private long phone;
    private String password;
    private String email;
    private String address;

    public Ngo() {

    }

    public Ngo(int ngoId, String name, long phone, String password, String email, String address) {
        this.ngoId = ngoId;
        this.name = name;
        this.phone = phone;
        this.password = password;
        this.email = email;
        this.address = address;
    }

    public int getNgoId() {
        return ngoId;
    }

    public void setNgoId(int ngoId) {
        this.ngoId = ngoId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
