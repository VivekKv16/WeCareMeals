package com.wecaremeals.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.wecaremeals.dto.Donation;
import com.wecaremeals.util.DbConnection;

public class DonationDAOImpl implements DonationDAO {

    @Override
    public List<Donation> getDonationsForNgo(int ngoId) {
        List<Donation> list = new ArrayList<>();

        String sql =
            "SELECT fd.donationID, fd.donorID, fd.foodItem, fd.quantity, fd.donationDate, " +
            "       fd.ngoID, d.name AS donorName, d.address AS donorAddress " +
            "FROM food_donations fd " +
            "JOIN donor d ON fd.donorID = d.donorID " +
            "WHERE fd.ngoID = ? " +
            "ORDER BY fd.donationID DESC";

        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, ngoId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Donation d = new Donation();
                d.setDonationId(rs.getInt("donationID"));
                d.setDonorId(rs.getInt("donorID"));
                d.setNgoId(rs.getInt("ngoID"));
                d.setFoodItem(rs.getString("foodItem"));
                d.setQuantity(rs.getString("quantity"));
                d.setDonationDate(rs.getTimestamp("donationDate"));
                d.setDonorName(rs.getString("donorName"));
                d.setDonorAddress(rs.getString("donorAddress"));

                list.add(d);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}
