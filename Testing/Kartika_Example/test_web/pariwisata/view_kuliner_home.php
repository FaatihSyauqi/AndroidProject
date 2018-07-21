<?php
require_once('config.php');
if($_SERVER['REQUEST_METHOD']=='GET') {
  $sql = "SELECT * FROM kuliner ORDER BY nama_kuliner ASC";
  $res = mysqli_query($con,$sql);
  $result = array();
  while($row = mysqli_fetch_array($res)){
    array_push($result, array('img'=>$row[10],'nama_kuliner'=>$row[1]));
  }
  echo json_encode(array("value"=>1,"result"=>$result));	
  mysqli_close($con);
}