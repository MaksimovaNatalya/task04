<html>
<body>
<h1>Authorization</h1>

<h2>Login</h2>
<form action="MyController" method="get">
 <input type="hidden" name ="command" value="logination" />
    Login
    <input type="text" name ="login" value="" />
<br/>
    Password
    <input type="password" name ="password" value="" />
<br/>
    <input type="submit" value="Log in" />
</form>

<br/>
<h2>Registration</h2>
<form action="MyController" method="get">
 <input type="hidden" name ="command" value="registration" />
    Name
    <input type="text" name ="name" value="" />
<br/>
    Surname
    <input type="text" name ="surname" value="" />
<br/>
 Login
    <input type="text" name ="login" value="" />
<br/>
    Password
    <input type="password" name ="password" value="" />
<br/>
    Confirm password
    <input type="password" name ="Confirm password" value="" />
<br/>
<input type="submit" value="Register" />
</form>
</body>
</html>
