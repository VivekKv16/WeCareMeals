package com.wecaremeals.dto;

public class Donor {
    private int donorId;
    private String name;
    private long phone;
    private String password;
    private String address;

    public Donor() {

    }

    public Donor(int donorId, String name, long phone, String password, String address) {
        this.donorId = donorId;
        this.name = name;
        this.phone = phone;
        this.password = password;
        this.address = address;
    }

    public int getDonorId() {
        return donorId;
    }

    public void setDonorId(int donorId) {
        this.donorId = donorId;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
