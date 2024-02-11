<?php
if($_SERVER['REQUEST_METHOD']=='POST')
{
	include "config.php";
	$pemail=$_POST['pemail'];
	$ppassword=$_POST['ppassword'];
	$sql="SELECT * FROM Pinfo WHERE pemail='$pemail' and ppassword='$ppassword'";
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
	echo "no information from userside ";
}
?>