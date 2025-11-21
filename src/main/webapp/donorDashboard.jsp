<%@ page import="com.wecaremeals.dto.Donor" %>
<%@ page import="java.util.List" %>
<%@ page import="com.wecaremeals.dto.Ngo" %>
<%@ page session="true" %>

<%
    Donor donor = (Donor) session.getAttribute("donor");

    if (donor == null) {
        response.sendRedirect("donorLogin.html");
        return;
    }

    String donorName = donor.getName();
    int donorID = donor.getDonorId();

    // Address from session OR donor object
    String address = (String) session.getAttribute("address");
    if (address == null) {
        address = donor.getAddress();  // fallback
    }

    boolean hasAddress = (address != null && !address.trim().isEmpty());
%>

<!DOCTYPE html>
<html>
<head>
    <title>Donor Dashboard</title>
    <style>
        body { font-family: Arial; background: #f3f6ff; }
        .box {
            width: 50%; margin: 60px auto; background: white;
            padding: 30px; border-radius: 12px;
            box-shadow: 0 0 10px rgba(0,0,0,0.2);
        }
        input { width: 100%; padding: 10px; margin: 10px 0; }
        button { background:#28a745; border:none; color:white; padding:10px 20px; cursor:pointer; }
        .address-bar { background:#333; color:white; padding:15px; text-align:center; }
    </style>
</head>
<body>

<!-- Address Section -->
<div class="address-bar">

    <% if (!hasAddress) { %>
        <form action="donorAddress" method="post">
            <input type="text" name="address" placeholder="Enter your address" required>
            <button type="submit">Save</button>
        </form>

    <% } else { %>
        <form action="donorAddress" method="post">
            <span><b>Address:</b> <%= address %></span>
            <button type="submit">Edit</button>
        </form>
    <% } %>

</div>

<div class="box">
    <h2>Welcome, <%= donorName %></h2>

    <form action="donateFood" method="post">

        <input type="hidden" name="donorID" value="<%= donorID %>">

        <h3>Select NGO near you:</h3>
        <select name="ngoID" required>
            <%
                List<Ngo> ngoList = (List<Ngo>) request.getAttribute("ngoList");
                if (ngoList != null) {
                    for (Ngo ngo : ngoList) {
            %>
                <option value="<%= ngo.getNgoId() %>">
                    <%= ngo.getName() %> - <%= ngo.getAddress() %>
                </option>
            <%
                    }
                }
            %>
        </select>

        <h3>Food Items</h3>

        <div id="items">
            <div>
                <input type="text" name="foodItem" placeholder="Food item" required>
                <input type="text" name="quantity" placeholder="Quantity" required>
            </div>
        </div>

        <button type="button" onclick="addItem()">+ Add More</button>

        <br><br>
        <button type="submit">Donate Food</button>
    </form>

    <script>
        function addItem() {
            let div = document.createElement("div");
            div.innerHTML = `
                <input type="text" name="foodItem" placeholder="Food item" required>
                <input type="text" name="quantity" placeholder="Quantity" required>
            `;
            document.getElementById("items").appendChild(div);
        }
    </script>


</div>

</body>
</html>
