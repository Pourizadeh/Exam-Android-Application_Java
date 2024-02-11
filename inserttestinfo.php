<?php
if($_SERVER['REQUEST_METHOD']=='POST'){
	include "config.php";
	$tid=$_POST['tid'];
	$title=$_POST['title'];
	$examdate=$_POST['examdate'];
	$endtime=$_POST['endtime'];
	$timetaking=$_POST['taketime'];
	$pid=$_POST['pid'];
	$teachername=$_POST['teachername'];
	$university=$_POST['university'];
	$educode=$_POST['educode'];
	/*inja ehtemalan bayad ye seri queri dashtebashim baraye gozashtane foreignkey ha tooye
	jadvale aslishoon ke primary key hasttan.tekrari ham ke
	nabayad zakhire beshe chon kilide asli bayad yekta bashe*/
	$sqlinsert="INSERT INTO testinfo(tid,title,examdate,endtime,taketime,pid,teachername,university,educode)VALUES('$tid','$title','$examdate','$endtime','$timetaking'
	,'$pid','$teachername','$university','$educode')";
	//$insert="INSERT INTO question (pid,tid) VALUES ('$pid','$tid')";
		mysqli_query($con,"SET CHARSET UTF8");
	if(mysqli_query($con,$sqlinsert) ){
		echo"Inserted Successfully";
			
		}
		}
else{
	echo"no information from user side";
}
?>