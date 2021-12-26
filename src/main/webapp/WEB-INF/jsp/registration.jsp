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


<form action="MyController" method="get">
<div>
<fieldset>
    <legend><h1>Registration Form</h1></legend>

 <label for="fname">First Name</label>
 <br/>
    <input type="text" id="fname" name="firstname" placeholder="Your name..">
 <br/>
    <label for="lname">Last Name</label>
     <br/>
    <input type="text" id="lname" name="lastname" placeholder="Your last name..">
 <br/>
   <label for="uname">User Name</label>
    <br/>
       <input type="text" id="uname" name="username" placeholder="Your user name..">
 <br/>
    <label for="country">Country</label>
        <select id="country" name="country">
         <br/>
          <option value="australia">Australia</option>
          <option value="canada">Canada</option>
          <option value="usa">USA</option>
        </select>
 <br/>
 <label for="password">Password</label>
     <br/>
        <input type="password" id="password" name="password" placeholder="">
    <br/>
    <label for="password">Confirm password</label>
         <br/>
            <input type="password" id="password" name="password" placeholder="">
        <br/>
    <br/><br/>
    <input type="submit" value="Register" />
    <br/>
<a href="MyController?command=GO_TO_MAIN_PAGE">Main page</a>
</fieldset>
</div>

</form>
</body>
</html>
