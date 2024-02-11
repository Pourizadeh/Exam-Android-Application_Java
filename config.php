<?php
define('host','localhost');
define('username','root');
define('password','');
define('db','mydb');
$con=mysqli_connect(host,username,password,db) or die ('cannot connect to database');
?>