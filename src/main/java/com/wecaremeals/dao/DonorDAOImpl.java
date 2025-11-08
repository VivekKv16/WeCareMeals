package com.wecaremeals.dao;

import com.wecaremeals.dto.Donor;
import com.wecaremeals.util.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
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

        System.out.println(donor.getName());
        if(update>0){
            System.out.println("entered successfully");

            return true;
        }

        return false;
    }
}
