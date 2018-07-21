<?php
require_once('config.php');
if($_SERVER['REQUEST_METHOD']=='GET') {
  $id = 3;
  $sql = "SELECT * FROM alam where id_alam='$id'";
  $res = mysqli_query($con,$sql);
  $result = array();
  while($row = mysqli_fetch_array($res)){
    array_push($result, array('img'=>$row[11],'deskripsi_alam'=>$row[6],'alamat_alam'=>$row[2],'website_alam'=>$row[8],'jam_alam'=>$row[4], 'jamakhir_alam'=>$row[5],'fasilitas_alam'=>$row[7]));
  }
  echo json_encode(array("value"=>1,"result"=>$result));	
  mysqli_close($con);
}