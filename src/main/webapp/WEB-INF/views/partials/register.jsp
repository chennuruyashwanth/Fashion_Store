<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register</title>

<link rel="stylesheet" href="assets/css/styles.css">
<link rel="stylesheet" href="assets/css/auth.css">

</head>
<body>

<div class="auth-container">

    <div class="auth-card">

        <h2>Create Account</h2>

		<form action="register" method="post">
        
            <input type="text"
                   name="name"
                   placeholder="Full Name"
                   required>

            <input type="email"
                   name="email"
                   placeholder="Email"
                   required>

            <input type="password"
                   name="password"
                   placeholder="Password"
                   required>

            <input type="text"
                   name="phone"
                   placeholder="Phone Number"
                   required>

            <textarea name="address"
                      placeholder="Address"></textarea>

            <input type="text"
                   name="city"
                   placeholder="City">

            <input type="text"
                   name="state"
                   placeholder="State">

            <input type="text"
                   name="pincode"
                   placeholder="Pincode">

            <input type="text"
                   name="country"
                   placeholder="Country">

            <button type="submit">
                Register
            </button>
           

        </form>

        <p>
            Already have an account?
            <a href="login">Login</a>
        </p>

    </div>

</div>

</body>
</html>