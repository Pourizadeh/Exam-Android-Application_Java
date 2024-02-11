<?php
include "config.php";
mysqli_query($con,"SET CHARSET UTF8");
$sql="SELECT testinfo.* FROM testinfo,sinfo  WHERE testinfo.educode=sinfo.educode "; 
$result=$con->query($sql);
$arraylist=array();
$array=$result->fetch_all(MYSQLI_ASSOC);
echo json_encode($array);


?>