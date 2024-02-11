<?php
if($_SERVER['REQUEST_METHOD']=='POST'){
	include "config.php";
	$sname=$_POST['sname'];
	$slastname=$_POST['slastname'];
	$semail=$_POST['semail'];
	$spassword=$_POST['spassword'];
	$educode=$_POST['educode'];
	$exist="SELECT * FROM Sinfo WHERE semail='$semail'";
	$finaly=mysqli_query($con,$exist);
	$check=mysqli_fetch_array($finaly);
	if(isset($check)){
		echo"This email has been taken";
	}
		else {
	
	$sqlinsert="INSERT INTO Sinfo(sname,slastname,semail,spassword,educode)VALUES('$sname','$slastname','$semail','$spassword','$educode')";
		mysqli_query($con,"SET CHARSET UTF8");
	if(mysqli_query($con,$sqlinsert)){
		echo"You have registered successfully
                welcome!";
			
		}
		}
}
else{
	echo"no information from user side";
}
?>