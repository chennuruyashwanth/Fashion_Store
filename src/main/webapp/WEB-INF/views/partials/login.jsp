<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>

<link rel="stylesheet" href="assets/css/styles.css">
<link rel="stylesheet" href="assets/css/auth.css">

</head>
<body>

<div class="auth-container">

    <div class="auth-card">

        <h2>Login</h2>
        
        <%
		String error =
		(String)request.getAttribute("error");
		
		if(error != null){
		%>
		
		<p style="color:red;
		          text-align:center;
		          margin-bottom:15px;">
		    <%= error %>
		</p>
		
		<%
		}
		%>

        <form action="login" method="post">

            <input type="email"
                   name="email"
                   placeholder="Email"
                   required>

            <input type="password"
                   name="password"
                   placeholder="Password"
                   required>

            <button type="submit">
                Login
            </button>

        </form>

        <p>
            New User?
            <a href="register">
                Create Account
            </a>
        </p>

    </div>

</div>

</body>
</html>