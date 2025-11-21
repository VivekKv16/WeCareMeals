package com.wecaremeals.dao;

import com.wecaremeals.dto.Donor;
import com.wecaremeals.util.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DonorDAOImpl implements com.wecaremeals.dao.DonorDAO{


    static Connection con=null;

    @Override
    public boolean registerDonor(Donor donor) throws SQLException, ClassNotFoundException {
        con= DbConnection.getConnection();
        String sqry="insert into donor values(?,?,?,?,?)";
        PreparedStatement ps=con.prepareStatement(sqry);
        ps.setInt(1,donor.getDonorId());
        ps.setString(2,donor.getName());
        ps.setLong(3,donor.getPhone());
        ps.setString(4,donor.getPassword());
        ps.setString(5,donor.getAddress());

        int update=ps.executeUpdate();


        if(update>0){
            return true;
        }
        return false;
    }

    @Override
    public Donor loginDonor(long phone, String password) throws SQLException, ClassNotFoundException {
        String sqry="select * from donor where phone=? and password=?";
        con=DbConnection.getConnection();
        Donor donor=null;
        PreparedStatement ps=con.prepareStatement(sqry);
        ps.setLong(1,phone);
        ps.setString(2,password);
        ResultSet rs=ps.executeQuery();
        if(rs.next()){
            donor =new Donor();
            donor.setDonorId(rs.getInt("donorId"));
            donor.setName(rs.getString("name"));
            donor.setPhone(rs.getLong("phone"));
            donor.setPassword(rs.getString("password"));
            donor.setAddress(rs.getString("address"));
        }
        return donor;
    }

    @Override
    public void updateAddress(int donorID, String address) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE donor SET address=? WHERE donorID=?";
        con = DbConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, address);
        ps.setInt(2, donorID);
        ps.executeUpdate();
    }

}
