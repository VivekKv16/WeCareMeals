package com.wecaremeals.dao;

import com.wecaremeals.dto.Ngo;

import java.sql.SQLException;

public interface NgoDAO {
    public boolean registerNgo(Ngo ngo) throws SQLException, ClassNotFoundException;

    public Ngo loginNgo(long number,String password) throws SQLException, ClassNotFoundException;

}
