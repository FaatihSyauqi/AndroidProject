<?php
require_once('config.php');
if($_SERVER['REQUEST_METHOD']=='GET') {
  $sql = "SELECT * FROM kuliner ORDER BY nama_kuliner ASC";
  $res = mysqli_query($con,$sql);
  $result = array();
  while($row = mysqli_fetch_array($res)){
    array_push($result, array('id_kuliner'=>$row[0], 'nama_kuliner'=>$row[1], 'alamat_kuliner'=>$row[2], 'harga_kuliner'=>$row[3], 'jam_kuliner'=>$row[4], 'jamakhir_kuliner'=>$row[5], 'deskripsi_kuliner'=>$row[6], 'fasilitas_kuliner'=>$row[7], 'img'=>$row[8]));
  }
  echo json_encode(array("result"=>$result));	
  mysqli_close($con);
}