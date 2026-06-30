<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%@ page import="java.util.List" %>
<%@ page import="com.fashionStore.model.User" %>
<%@ page import="com.fashionStore.model.Order" %>

<%
User user = (User)request.getAttribute("user");

List<Order> orders =
(List<Order>)request.getAttribute("orders");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Profile</title>

<style>

*{
    margin:0;
    padding:0;
    box-sizing:border-box;
    font-family:'Poppins',sans-serif;
}

body{
    min-height:100vh;
    background:#fff8e7;
    padding:40px 0;
}

/* Main Container */

.profile-container{
    width:90%;
    max-width:1400px;
    margin:auto;
}

/* Profile Card */

.profile-card{
   	background:#E8E2D3;
    border-radius:25px;
    padding:40px;
    margin-bottom:35px;
    box-shadow:
    0 10px 30px rgba(0,0,0,0.08);
    border:1px solid #f0e6c8;
}

.profile-title{
    text-align:center;
    font-size:52px;
    font-weight:700;
    color:#1f2937;
    margin-bottom:35px;
}

.profile-grid{
    display:grid;
    grid-template-columns:1fr 1fr;
    gap:25px;
}

.profile-field label{
    display:block;
    font-size:18px;
    font-weight:600;
    margin-bottom:8px;
    color:#6b7280;
}

.profile-field input,
.profile-field textarea{
    width:100%;
    padding:16px;
    border:2px solid #ececec;
    border-radius:14px;
    background:#fafafa;
    font-size:16px;
    color:#374151;
}

.profile-field input:focus,
.profile-field textarea:focus{
    outline:none;
    border-color:#c8a64d;
}

.profile-field textarea{
    resize:none;
    height:120px;
}

.full-width{
    grid-column:1 / span 2;
}

/* Buttons */

.profile-buttons{
    display:flex;
    justify-content:center;
    margin-top:35px;
}

.logout-btn{
    text-decoration:none;
    background:linear-gradient(
        135deg,
        #c8a64d,
        #b89334
    );
    color:white;
    padding:15px 40px;
    border-radius:12px;
    font-size:18px;
    font-weight:600;
    transition:0.3s;
}

.logout-btn:hover{
    transform:translateY(-3px);
    box-shadow:
    0 8px 20px rgba(200,166,77,0.4);
}

/* Orders Card */

.orders-card{
    background:#E8E2D3;
    border-radius:25px;
    padding:40px;
    box-shadow:
    0 10px 30px rgba(0,0,0,0.08);
    border:1px solid #f0e6c8;
}

.orders-title{
    text-align:center;
    font-size:42px;
    font-weight:700;
    color:#1f2937;
    margin-bottom:30px;
}

/* Table */

.orders-table{
    width:100%;
    border-collapse:collapse;
    overflow:hidden;
    border-radius:15px;
}

.orders-table th{
    background:#1f2937;
    color:white;
    padding:18px;
    font-size:16px;
    font-weight:600;
}

.orders-table td{
    padding:18px;
    text-align:center;
    border-bottom:1px solid #e5e7eb;
    color:#374151;
}

.orders-table tr:nth-child(even){
    background:#fafafa;
}

.orders-table tr:hover{
    background:#fff8e7;
}

/* Status */

.status{
    padding:8px 15px;
    border-radius:30px;
    font-size:13px;
    font-weight:700;
    text-transform:uppercase;
}

.pending{
    background:#fff3cd;
    color:#856404;
}

.delivered{
    background:#d4edda;
    color:#155724;
}

.cancelled{
    background:#f8d7da;
    color:#721c24;
}

.placed{
    background:#d1fae5;
    color:#065f46;
}

/* No Orders */

.no-orders{
    text-align:center;
    padding:50px;
    font-size:22px;
    color:#6b7280;
}

/* Responsive */

@media(max-width:768px){

    .profile-grid{
        grid-template-columns:1fr;
    }

    .full-width{
        grid-column:auto;
    }

    .profile-title{
        font-size:40px;
    }

    .orders-title{
        font-size:32px;
    }

    .orders-table{
        display:block;
        overflow-x:auto;
    }
}


</style>

</head>
<body>

<div class="profile-container">

    <!-- Profile Section -->

    <div class="profile-card">

        <h1 class="profile-title">
            My Profile
        </h1>

        <div class="profile-grid">

            <div class="profile-field">
                <label>Name</label>
                <input type="text"
                       value="<%= user.getName() %>"
                       readonly>
            </div>

            <div class="profile-field">
                <label>Email</label>
                <input type="text"
                       value="<%= user.getEmail() %>"
                       readonly>
            </div>

            <div class="profile-field">
                <label>Phone</label>
                <input type="text"
                       value="<%= user.getPhone() %>"
                       readonly>
            </div>

            <div class="profile-field">
                <label>Country</label>
                <input type="text"
                       value="<%= user.getCountry() %>"
                       readonly>
            </div>

            <div class="profile-field">
                <label>City</label>
                <input type="text"
                       value="<%= user.getCity() %>"
                       readonly>
            </div>

            <div class="profile-field">
                <label>State</label>
                <input type="text"
                       value="<%= user.getState() %>"
                       readonly>
            </div>

            <div class="profile-field">
                <label>Pincode</label>
                <input type="text"
                       value="<%= user.getPincode() %>"
                       readonly>
            </div>

            <div class="profile-field full-width">
                <label>Address</label>
                <textarea readonly><%= user.getAddress() %></textarea>
            </div>

        </div>

        <div class="profile-buttons">

            <a href="logout"
               class="logout-btn">
               Logout
            </a>

        </div>

    </div>

    <!-- Orders Section -->

    <div class="orders-card">

        <h2 class="orders-title">
            My Orders
        </h2>

        <%
        if(orders != null && !orders.isEmpty()){
        %>

        <table class="orders-table">

            <thead>
                <tr>
                    <th>Order ID</th>
                    <th>Total Amount</th>
                    <th>Payment Mode</th>
                    <th>Status</th>
                    <th>Order Date</th>
                </tr>
            </thead>

            <tbody>

            <%
            for(Order order : orders){
            %>

                <tr>

                    <td>
                        #<%= order.getOrderId() %>
                    </td>

                    <td>
                        ₹ <%= order.getTotalAmount() %>
                    </td>

                    <td>
                        <%= order.getPaymentMode() %>
                    </td>

                    <td>

                    <span class="status">

                    <%= order.getStatus() %>

                    </span>

                    </td>

                    <td>
                        <%= order.getOrderDate() %>
                    </td>

                </tr>

            <%
            }
            %>

            </tbody>

        </table>

        <%
        } else {
        %>

        <div class="no-orders">
            No Orders Placed Yet
        </div>

        <%
        }
        %>

    </div>

</div>

</body>
</html>