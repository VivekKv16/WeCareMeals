<%@page import="com.wecaremeals.dto.Ngo"%>
<%@page import="com.wecaremeals.dto.Donation"%>
<%@page import="java.util.List"%>
<%@ page session="true" %>

<%
    Ngo ngo = (Ngo) session.getAttribute("ngo");
    if (ngo == null) {
        response.sendRedirect("ngoLogin.html");
        return;
    }

    String ngoName = ngo.getName();
    String ngoAddress = ngo.getAddress();

    List<Donation> donationList = (List<Donation>) request.getAttribute("donationList");
%>
<!DOCTYPE html>
<html>
<head>
    <title>NGO Dashboard - WeCareMeals</title>
    <style>
        /* keep your previous styles… */
        .no-data { text-align:center; padding:15px; color:#666; }
        table { width:100%; border-collapse:collapse; margin-top:10px; }
        th, td { border:1px solid #ccc; padding:8px 10px; text-align:left; font-size:14px; }
        th { background:#f1f1f1; }
    </style>
</head>
<body>
<div class="topbar">
    <div class="title">WeCareMeals - NGO Dashboard</div>
    <div class="right">
        <span><b><%= ngoName %></b></span>
        <span><%= ngoAddress %></span>
        |
        <a href="ngoLogout">Logout</a>
    </div>
</div>

<div class="container">
    <div class="card">
        <h2>Incoming Donations</h2>

        <% if (donationList == null || donationList.isEmpty()) { %>
            <div class="no-data">No donations assigned to your NGO yet.</div>
        <% } else { %>
            <table>
                <thead>
                    <tr>
                        <th>Donation ID</th>
                        <th>Donor Name</th>
                        <th>Donor Address</th>
                        <th>Food Item</th>
                        <th>Quantity</th>
                        <th>Donation Date</th>
                    </tr>
                </thead>
                <tbody>
                <% for (Donation d : donationList) { %>
                    <tr>
                        <td><%= d.getDonationId() %></td>
                        <td><%= d.getDonorName() %></td>
                        <td><%= d.getDonorAddress() %></td>
                        <td><%= d.getFoodItem() %></td>
                        <td><%= d.getQuantity() %></td>
                        <td><%= d.getDonationDate() %></td>
                    </tr>
                <% } %>
                </tbody>
            </table>
        <% } %>
    </div>
</div>
</body>
</html>
