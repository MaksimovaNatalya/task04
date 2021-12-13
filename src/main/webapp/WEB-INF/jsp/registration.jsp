<html>
<body>
<h1>Registration</h1>

<br/>

<form action="MyController" method="get">
 <input type="hidden" name ="command" value="registration" />
    Name
    <input type="text" name ="name" value="" />
<br/>
<br/>
    Surname
    <input type="text" name ="surname" value="" />
<br/>
<br/>
 Login
    <input type="text" name ="login" value="" />
<br/>
<br/>
    Password
    <input type="password" name ="password" value="" />
<br/>
<br/>
    Confirm password
    <input type="password" name ="Confirm password" value="" />
<br/>
<br/>
<input type="submit" value="Register" />
<br/>
<a href="MyController?command=GO_TO_MAIN_PAGE">Main page</a>
</form>
</body>
</html>
