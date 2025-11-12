package com.wecaremeals.dao;

import com.wecaremeals.dto.Ngo;
import com.wecaremeals.util.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class NgoDAOImpl implements NgoDAO {


    Connection con= null;
    @Override
    public boolean registerNgo(Ngo ngo) throws SQLException, ClassNotFoundException {
        con= DbConnection.getConnection();
        String sqry="insert into ngo values(?,?,?,?,?,?)";
        PreparedStatement ps= con.prepareStatement(sqry);
        ps.setInt(1, ngo.getNgoId());
        ps.setString(2, ngo.getName());
        ps.setLong(3,ngo.getPhone());
        ps.setString(4,ngo.getPassword());
        ps.setString(5, ngo.getEmail());
        ps.setString(6,ngo.getAddress());

        int update = ps.executeUpdate();
        if(update>0){
            return true;
        }
        return false;

    }
}
