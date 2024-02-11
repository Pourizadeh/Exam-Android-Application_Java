<?php
include "config.php";
mysqli_query($con,"SET CHARSET UTF8");
$sql="SELECT question.* FROM question,testinfo,pinfo,sinfo WHERE question.pid=testinfo.pid AND question.tid=testinfo.tid AND pinfo.pid=testinfo.pid 
AND pinfo.pid=question.pid AND pinfo.educode=testinfo.educode AND sinfo.educode=testinfo.educode AND pinfo.educode=sinfo.educode "; 
$result=$con->query($sql);
$arraylist=array();
$array=$result->fetch_all(MYSQLI_ASSOC);
echo json_encode($array);


?>