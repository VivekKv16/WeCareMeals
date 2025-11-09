package com.wecaremeals.dao;

import com.wecaremeals.dto.Donor;

import java.sql.SQLException;

public interface DonorDAO {
    boolean registerDonor(Donor donor) throws SQLException, ClassNotFoundException;
    Donor loginDonor(long phone,String password) throws SQLException, ClassNotFoundException;
}
