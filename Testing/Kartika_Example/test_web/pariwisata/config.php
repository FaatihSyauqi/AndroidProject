 <?php
 define('HOST','localhost');
 define('USER','root');
 define('PASS','');
 define('DB','db_pariwisata');

 $con = mysqli_connect(HOST,USER,PASS,DB) or die('Unable to Connect');
 // Change character set to utf8
mysqli_set_charset($con,"utf8");
?>