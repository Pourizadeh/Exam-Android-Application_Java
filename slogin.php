<?php
if($_SERVER['REQUEST_METHOD']=='POST')
{
	include "config.php";
	$semail=$_POST['semail'];
	$spassword=$_POST['spassword'];
	$sql="SELECT * FROM Sinfo WHERE semail='$semail' and spassword='$spassword'";
	$result=mysqli_query($con,$sql);
	$checkL=mysqli_fetch_array($result);
if(isset($checkL)){
echo "Done!";
}
else {
	 echo "You haven't registered yet";
	
}
}
else{
	echo "no information from user side";
}
?>