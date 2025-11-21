package com.wecaremeals.dao;

import com.wecaremeals.dto.Ngo;

import java.sql.SQLException;
import java.util.List;

public interface NgoDAO {
    public boolean registerNgo(Ngo ngo) throws SQLException, ClassNotFoundException;
    public Ngo loginNgo(long number,String password) throws SQLException, ClassNotFoundException;

    public List<Ngo> getNgoByAddress(String address) throws SQLException, ClassNotFoundException;

}
