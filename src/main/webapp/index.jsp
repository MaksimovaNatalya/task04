<html>
<head>
<style>

.header-logo{
width:200px;
float:left;
padding-left:15px;
padding-right:15px;
position:relative;
z-index:1;
height:100%
}

ul {
  list-style-type: none;
  margin: 0;
  padding: 0;
  overflow: hidden;
  background-color: #696969;
  font-size: 18pt;
}

li {
  float: right;
}

li a, .dropbtn {
  display: inline-block;
  color: white;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
}

li a:hover, .dropdown:hover .dropbtn {
  background-color: #2F4F4F;
}

li.dropdown {
  display: inline-block;
}

.dropdown-content {
  display: none;
  position: absolute;
  background-color: #f9f9f9;
  min-width: 160px;
  box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
  z-index: 1;
}

.dropdown-content a {
  color: black;
  padding: 12px 16px;
  text-decoration: none;
  display: block;
  text-align: left;
}

.dropdown-content a:hover {background-color: #f1f1f1;}

.dropdown:hover .dropdown-content {
  display: block;
}
</style>
</head>
<body>

  <div class="header-logo">
            <a class="header-logo-link" href="/">
                <img class="header-logo-src" src="../webapps/task4/images/logo.png" alt="Logo">
            </a>
        </div>
<ul>

  <li class="dropdown">
      <a  href="javascript:void(0)" class="dropbtn">Login</a>
      <div class="dropdown-content">
        <a href="MyController?command=GO_TO_LOGINATION_PAGE">Login</a>
        <a href="MyController?command=GO_TO_REGISTRATION_PAGE">Register</a>
      </div>
      <li><a href="#news">SPA</a></li>
      <li><a href="#news">Restaurant</a></li>
      <li><a href="#news">Book a room</a></li>
      <li><a href="#home">About us</a></li>
</ul>



</body>
</html>

