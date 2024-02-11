<?php
if($_SERVER['REQUEST_METHOD']=='POST'){
	include "config.php";
	$pid=$_POST['pid'];
	$pname=$_POST['pname'];
	$plastname=$_POST['plastname'];
	$pemail=$_POST['pemail'];
	$ppassword=$_POST['ppassword'];
	$educode=$_POST['educode'];
	$exist="SELECT * FROM Pinfo WHERE pemail='$pemail'";
	$finaly=mysqli_query($con,$exist);
	$check=mysqli_fetch_array($finaly);
	if(isset($check)){
		echo"This email has been taken";
	}
		else {
	
	$sqlinsert="INSERT INTO Pinfo(pid,pname,plastname,pemail,ppassword,educode)VALUES('$pid','$pname','$plastname','$pemail','$ppassword','$educode')";
		mysqli_query($con,"SET CHARSET UTF8");
	if(mysqli_query($con,$sqlinsert)){
		echo"You have registered successfully
                welcome!";
			
		}
		}
}
else{
	echo"اطلاعاتی از کاربر دریافت نشد";
}
?>