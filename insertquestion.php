<?php
if($_SERVER['REQUEST_METHOD']=='POST'){
	include "config.php";
	$question=$_POST['question'];
	$choice1=$_POST['choice1'];
	$choice2=$_POST['choice2'];
	$choice3=$_POST['choice3'];
	$choice4=$_POST['choice4'];
	$answer=$_POST['answer'];
	$pid=$_POST['pid'];
	$tid=$_POST['tid'];
	$sqlinsert="INSERT INTO question(question,choice1,choice2,choice3,choice4,answer,pid,tid)VALUES('$question',
	'$choice1','$choice2','$choice3','$choice4','$answer','$pid','$tid')";
		mysqli_query($con,"SET CHARSET UTF8");
	if(mysqli_query($con,$sqlinsert)){
		echo"Inserted Successfully";
			
		}
		
}
else{
	echo"not any information from user side";
}
?>