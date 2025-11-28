package com.wecaremeals.dto;

import java.sql.Timestamp;

public class Donation {

    private int donationId;
    private int donorId;
    private int ngoId;

    private String donorName;
    private String donorAddress;

    private String foodItem;
    private String quantity;
    private Timestamp donationDate;

  

    public int getDonationId() { return donationId; }
    public void setDonationId(int donationId) { this.donationId = donationId; }

    public int getDonorId() { return donorId; }
    public void setDonorId(int donorId) { this.donorId = donorId; }

    public int getNgoId() { return ngoId; }
    public void setNgoId(int ngoId) { this.ngoId = ngoId; }

    public String getDonorName() { return donorName; }
    public void setDonorName(String donorName) { this.donorName = donorName; }

    public String getDonorAddress() { return donorAddress; }
    public void setDonorAddress(String donorAddress) { this.donorAddress = donorAddress; }

    public String getFoodItem() { return foodItem; }
    public void setFoodItem(String foodItem) { this.foodItem = foodItem; }

    public String getQuantity() { return quantity; }
    public void setQuantity(String quantity) { this.quantity = quantity; }

    public Timestamp getDonationDate() { return donationDate; }
    public void setDonationDate(Timestamp donationDate) { this.donationDate = donationDate; }
}
