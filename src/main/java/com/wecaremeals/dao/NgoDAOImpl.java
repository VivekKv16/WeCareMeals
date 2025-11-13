package com.wecaremeals.dao;

import com.wecaremeals.dto.Ngo;
import com.wecaremeals.util.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

    @Override
    public Ngo loginNgo(long phone, String password) throws SQLException, ClassNotFoundException {
        con=DbConnection.getConnection();
        String sqry ="select * from ngo where phone=? and password=?";
        Ngo ngo= null;
        PreparedStatement ps = con.prepareStatement(sqry);
        ps.setLong(1,phone);
        ps.setString(2,password);

        ResultSet rs =ps.executeQuery();
        if(rs.next()){
            ngo= new Ngo();
            ngo.setNgoId(rs.getInt("ngoId"));
            ngo.setName(rs.getString("name"));
            ngo.setPhone(rs.getLong("phone"));
            ngo.setPassword(rs.getString("password"));
            ngo.setEmail(rs.getString("email"));
            ngo.setAddress(rs.getString("address"));
        }

        return ngo;
    }
}
