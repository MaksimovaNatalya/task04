<html>
<body>

<style>

input[type=text], select {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
}

input[type=password], select {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
}

input[type=submit] {
  width: 100%;
  background-color: #6495ED;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

input[type=submit]:hover {
  background-color: #4682B4;
}

div {
  border-radius: 5px;
  background-color: #f2f2f2;
  padding: 20px;
}
</style>

<form action="MyController" method="post">
    <input type="hidden" name="command" value="logination">
    <div>
 <fieldset>
<legend><h1>Logination Form</h1></legend>
<label for="username">User name</label>
 <br/>
    <input type="text" id="username" name="username" placeholder="Your user name..">
 <br/>
<label for="password">Password</label>
 <br/>
    <input type="password" id="password" name="password" placeholder="Your password..">
 <br/>
 <input type="submit" value="Log in" />
 <br/><br/>
Not registered yet? <a href="MyController?command=GO_TO_REGISTRATION_PAGE">Register</a>
   </fieldset>
</div>

</form>
</body>
</html>