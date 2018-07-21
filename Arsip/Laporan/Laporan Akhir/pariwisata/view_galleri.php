<?php
require_once('config.php');
if($_SERVER['REQUEST_METHOD']=='GET') {
  $sql = "SELECT * FROM galeri WHERE id";
  $res = mysqli_query($con,$sql);
  $result = array();
  while($row = mysqli_fetch_array($res)){
    array_push($result, array('id'=>$row[0],'gambar_galeri'=>$row[1]));
  }
  echo json_encode(array("result"=>$result));	
  mysqli_close($con);
}