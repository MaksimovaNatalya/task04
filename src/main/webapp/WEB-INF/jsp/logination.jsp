<html>
<body>

<style>
fieldset{
font-size: 14pt;
}
input {
  position: absolute;
left: 140px;
  }
</style>


<form action="MyController" method="get">
<fieldset>
    <legend>Logination Form</legend>
  <input type="hidden" name ="command" value="logination" />
      User name:
      <input type="text" name ="login" value="" />
  <br/><br/>
      Password:
      <input type="password" name ="password" value="" />
    <br/><br/>
      <input type="submit" value="Log in" />
          <br/><br/>
        Not registered yet? <a href="MyController?command=GO_TO_REGISTRATION_PAGE">Register</a>
   </fieldset>


</form>
</body>
</html>