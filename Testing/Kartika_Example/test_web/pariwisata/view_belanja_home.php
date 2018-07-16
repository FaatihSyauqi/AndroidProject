<?php
require_once('config.php');
if($_SERVER['REQUEST_METHOD']=='GET'){
  $sql = "SELECT * FROM belanja ORDER BY nama_belanja ASC";
  $res = mysqli_query($con,$sql);
  $result = array();
  while($row = mysqli_fetch_array($res)){
    array_push($result, array('img'=>$row[9],'nama_belanja'=>$row[1]));
  }
  echo json_encode(array("value"=>1,"result"=>$result));	
  mysqli_close($con);
}