<?php
require_once('config.php');
if($_SERVER['REQUEST_METHOD']=='GET') {
$id = 3;
  $sql = "SELECT * FROM galeri_alam where id_galeri='$id'";
  $res = mysqli_query($con,$sql);

  $result = array();
  while($row = mysqli_fetch_array($res)){
    array_push($result, array('alam_galeri'=>$row[1]));
  }
  echo json_encode(array("result"=>$result));	
  mysqli_close($con);
}