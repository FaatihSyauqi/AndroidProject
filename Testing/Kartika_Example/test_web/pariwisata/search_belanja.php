<?php
require_once('config.php');
if($_SERVER['REQUEST_METHOD']=='GET') {
  $sql = "SELECT * FROM belanja where nama LIKE '%$search%' ORDER BY nama ASC";
  $res = mysqli_query($con,$sql);
  $result = array();
  while($row = mysqli_fetch_array($res)){
    array_push($result, array('nama_belanja'=>$row[1], 'alamat_belanja'=>$row[2], 'jam_belanja'=>$row[3], 'jamakhir_belanja'=>$row[4], 'deskripsi_belanja'=>$row[5], 'fasilitas_belanja'=>$row[6], 'telepon_belanja'=>$row[7], 'website_belanja'=>$row[8]));
  }
  echo json_encode(array("value"=>1,"result"=>$result));	
  mysqli_close($con);
}