<%@ page import="java.io.PrintWriter" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<body>

<style>
    body {
        background: #B0E0E6;
    }
    .header-logo{
        width:200px;
        float:left;

        position:relative;
        z-index:1;

    }
    .header-logo-src{
        width:200px;
        height:55px;
        float:left;

        position:relative;
        z-index:1;

    }

    .log-in {
        float:right;
    }

    img{
        width:100%;
        height:110%;
        position:relative;
        z-index:1;
    }

    ul {
        list-style-type: none;
        margin: 0;
        padding: 0;
        overflow: hidden;

        font-size: 18pt;
    }

    li {
        float: left;
    }

    li a, .dropbtn {
        display: inline-block;
        color: black;
        text-align: center;
        padding: 14px 40px;
        text-decoration: none;
    }

    li a:hover, .dropdown:hover .dropbtn {
        background-color: 	#B0C4DE;
    }

    li.dropdown {
        display: inline-block;
    }

    .dropdown-content {
        display: none;
        position: absolute;
        background-color: 	#AFEEEE;
        min-width: 90px;
        box-shadow: 0px 8px 16px 0px rgba(0, 134, 254, 0.42);
        z-index: 1;
    }

    .dropdown-content a {
        color: black;
        padding: 12px 32px;
        text-decoration: none;
        display: block;
        text-align: center;
        z-index: 1;
    }

    .dropdown-content a:hover {background-color: #B0C4DE;}

    .dropdown:hover .dropdown-content {
        display: block;
    }

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



    <a class="header-logo-link" href="Controller?command=GO_TO_INDEX_PAGE">
        <img class="header-logo-src" src="/hotel-logo.jpg"  alt="Logo" >
    </a>

<ul>
    <li class="log-in">
        <a href="Controller?command=GO_TO_AUTHORIZATION_PAGE">Log in</a>
    </li>
    <li class="dropdown">
        <a  href="javascript:void(0)" class="dropbtn">About us</a>
        <div class="dropdown-content">
            <a href="Controller?command=GO_TO_INFO_PAGE">Info</a>
            <a href="Controller?command=GO_TO_CONTACTS_PAGE">Contacts</a>
        </div>
    <li><a href="Controller?command=GO_TO_ROOMS_PAGE">Rooms</a></li>
    <li><a href="Controller?command=GO_TO_BOOKING_PAGE">Book a room</a></li>

</ul>

<br>


<form action="Controller" method="post">
    <input type="hidden" name="command" value="logination">
    <div>
 <fieldset>
     <font color="red" size="3"> <c:if test="${param.message!=null}">
         <c:out value="${param.message}" />
     </c:if>
     </font>
<legend><h1>Authorization Form</h1></legend>
 <br/>
     <br/>
<label for="login">Login</label>
 <br/>
    <input type="text" id="login" name="login" placeholder="Your login..">
 <br/>
<label for="password">Password</label>
 <br/>
    <input type="password" id="password" name="password" placeholder="Your password..">
 <br/>
 <input type="submit" value="Log in" />
 <br/><br/>
Not registered yet? <a href="Controller?command=GO_TO_REGISTRATION_PAGE">Register</a>
   </fieldset>
</div>

</form>
</body>
</html>