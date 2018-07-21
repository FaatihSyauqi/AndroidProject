<?php
require_once('config.php');
if($_SERVER['REQUEST_METHOD']=='GET') {
  $sql = "SELECT * FROM galeri_kuliner";
  $res = mysqli_query($con,$sql);
  $result = array();
  while($row = mysqli_fetch_array($res)){
    array_push($result, array('id_kuliner'=>$row[0],'alam_kuliner'=>$row[1]));
  }
  echo json_encode(array("result"=>$result));	
  mysqli_close($con);
}