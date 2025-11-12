package com.wecaremeals.dao;

import com.wecaremeals.dto.Ngo;

import java.sql.SQLException;

public interface NgoDAO {
    boolean registerNgo(Ngo ngo) throws SQLException, ClassNotFoundException;

}
