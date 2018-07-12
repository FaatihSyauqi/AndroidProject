<?php
require_once('config.php');
if($_SERVER['REQUEST_METHOD']=='GET') {
  $sql = "SELECT * FROM alam ORDER BY nama_alam ASC";
  $res = mysqli_query($con,$sql);
  $result = array();
  while($row = mysqli_fetch_array($res)){
    array_push($result, array('nama_alam'=>$row[1], 'alamat_alam'=>$row[2], 'harga_alam'=>$row[3], 'jam_alam'=>$row[4], 'jamakhir_alam'=>$row[5], 'deskripsi_alam'=>$row[6], 'fasilitas_alam'=>$row[7], 'website_alam'=>$row[8], 'img'=>$row[9]));
  }
  echo json_encode(array("value"=>1,"result"=>$result));	
  mysqli_close($con);
}