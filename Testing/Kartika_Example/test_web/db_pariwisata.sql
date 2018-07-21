-- phpMyAdmin SQL Dump
-- version 4.8.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 21, 2018 at 07:59 AM
-- Server version: 10.1.34-MariaDB
-- PHP Version: 7.2.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_pariwisata`
--

-- --------------------------------------------------------

--
-- Table structure for table `alam`
--

CREATE TABLE `alam` (
  `id_alam` int(11) NOT NULL,
  `nama_alam` varchar(50) NOT NULL,
  `alamat_alam` varchar(250) NOT NULL,
  `harga_alam` varchar(50) NOT NULL,
  `jam_alam` time NOT NULL,
  `jamakhir_alam` time NOT NULL,
  `deskripsi_alam` varchar(10000) NOT NULL,
  `fasilitas_alam` varchar(500) NOT NULL,
  `website_alam` varchar(50) NOT NULL,
  `lat_alam` double NOT NULL,
  `long_alam` double NOT NULL,
  `img` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `alam`
--

INSERT INTO `alam` (`id_alam`, `nama_alam`, `alamat_alam`, `harga_alam`, `jam_alam`, `jamakhir_alam`, `deskripsi_alam`, `fasilitas_alam`, `website_alam`, `lat_alam`, `long_alam`, `img`) VALUES
(1, 'Stone Garden Padalarang', 'Citatah, Padalarang, Gunungmasigit, Cipatat, Kabupaten Bandung Barat, Jawa Barat 40554', 'Rp 3.000', '06:00:00', '17:00:00', 'Tidak banyak orang mengetahui keindahan yang disuguhkan oleh pemandangan di atas bukit Stone Garden ini. Apalagi bila wisatawan berkunjung di padang bertabur bebatuan ini pada pagi hari saat matahari muncul atau di senja hari saat matahari tenggelam. Pemandangan yang disuguhkan di tempat wisata di Bandung yang satu ini tampak fenomenal mengundang decak kekaguman pengunjung, setelah menjelajah bebatuan yang terbentuk secara alamiah bekas danau di zaman purba. Tentu tidak disangkal bila dikatakan Taman Batu yang terletak di dataran tinggi di atas bukit ini tidak kalah indahnya dari tempat wisata yang ada di luar negeri. Setelah sedikit treking melewati bebatuan yang menanjak, Anda bisa menapak dan melihat padang rumput tempat bebatuan yang tegak dengan formasi yang begitu artistik. Keindahan pemandangan yang terhampar luas di antara tanah pertanian penduduk serta langit lepas sejauh mata memandang ini tidak kalah bila dibandingkan dengan Grand Canyon di Amerika yang viral itu.', 'Gazebo, Warung, Parkir atas & bawah, Aula Via Pawon, Kamar Mandi, Mushola', '-', 0, 0, 'image.jpg'),
(2, 'Tebing Keraton', 'Lembang, Ciburial, Cimenyan, Ciburial, Cimenyan, Kabupaten Bandung Barat, Jawa Barat 40198', 'Rp 11.000', '08:00:00', '18:00:00', 'Tebing ini langsung populer dikalangan travelers salah satunya berkat media sosial. Menjamurnya foto-foto selfie dengan backround panorama alam yang indah di berbagai media sosial membuat orang penasaran dengan tempat ini. Dengan ketinggian 1200 meter DPL, view yang dihasilkan dari atas tebing ini bagaikan sebuah hamparan karpet hijau dengan pepohonan dan lembah yang menjadi corak utamanya. Matahari yang terbit seakan membuka semua tirai dari lebatnya kabut yang menutupi hamparan pepohonan di sekitar tebing ini.', 'Parkir motor dan mobil, Kamar Mandi, Mushola, Tebing, Tower', 'www.tebingkeraton.com', 0, 0, 'image.jpg'),
(3, 'Kawah Putih', 'Sugihmukti, Pasirjambu, Bandung, West Java', 'Rp 15.000', '07:00:00', '17:00:00', 'Keindahannya menyuguhkan pemandangan yang spektakuler dan lain dari yang lain. Warna air danau kawah ini pun bisa berubah-ubah. Bila cuaca sedang terik, terkadang berwarna biru kehijauan. Kadang warnanya berubah menjadi berwarna coklat susu dan lebih sering berwarna putih saat udara dipenuhi kabut tebal. Pasir dan bebatuan di kawasan danau ini juga berwarna putih, itulah sebabnya danau kawah ini disebut Kawah Putih.', 'Area Parkir, Mushola, Transportasi dari gerbang depan sampai dengan kawah, Pusat Informasi, Restoran dan warung makan, Toile.', 'www.kawahputihciwidey.com', 0, 0, 'image.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `belanja`
--

CREATE TABLE `belanja` (
  `id_belanja` int(11) NOT NULL,
  `nama_belanja` varchar(50) NOT NULL,
  `alamat_belanja` varchar(250) NOT NULL,
  `jam_belanja` time NOT NULL,
  `jamakhir_belanja` time NOT NULL,
  `deskripsi_belanja` varchar(10000) NOT NULL,
  `fasilitas_belanja` varchar(500) NOT NULL,
  `telepon_belanja` varchar(15) NOT NULL,
  `website_belanja` varchar(50) NOT NULL,
  `lat_belanja` double NOT NULL,
  `long_belanja` double NOT NULL,
  `img` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `belanja`
--

INSERT INTO `belanja` (`id_belanja`, `nama_belanja`, `alamat_belanja`, `jam_belanja`, `jamakhir_belanja`, `deskripsi_belanja`, `fasilitas_belanja`, `telepon_belanja`, `website_belanja`, `lat_belanja`, `long_belanja`, `img`) VALUES
(4, 'Pusat Sepatu Cibaduyut', 'Jl. Cibaduyut Raya No.7, Kb. Lega, Bojongloa Kidul, Kota Bandung, Jawa Barat 40235', '09:00:00', '21:00:00', 'Cibaduyut adalah pusat pasar khusus yang menjual kerajinan tangan atau sepatu \'handmade\'. Selain itu sepatu ada juga sandal, jaket dan tas yang juga dijual disini.', 'Toilet, Parkiran motor dan mobil, musholla.', '085722060602 ', '-', 0, 0, 'image.jpg'),
(5, 'BTC Fashion Mall', 'Jalan Dokter Djunjunan No.143-149, Pajajaran, Cicendo, Pajajaran, Cicendo, Kota Bandung, Jawa Barat 40163', '10:00:00', '21:00:00', 'BTC Fashion Mall adalah mall yang menawarkan berbagai macam kebutuhan mulai dari kuliner hingga fashion terbaru. Mall ini terkenal dengan fashionnya karena beberapa fashion yang dijual disini cukup menarik dan juga harganya terjangkau.', 'Parkir motor dan mobil, Kamar Mandi, Mushola, Ruang rokok, ATM.', '(022)6033846', 'www.btcfashionmall.com', 0, 0, 'image.jpg'),
(6, 'Istana BEC', 'Jalan Purnawarman No.5-17, Babakan Ciamis, Sumur Bandung, Kota Bandung, Jawa Barat 40117', '10:00:00', '21:00:00', 'BEC adalah pusat perbelanjaan barang-barang electronic yang ada di Bandung. Biasanya wisatawan dari Bandung berkunjung demi mendapatkan barang electronic yang diinginkan. Selain harganya terjangkau, disini juga menawarkan banyak pilihan produk. Barang electronic yang dijual disini berupa smartphone, laptop, computer, kamera dan beberapa alat electronic lainnya.', 'Parkir motor dan mobil, Kamar Mandi, Mushola, Ruang rokok, ATM.', '(022)4205100', 'www.istanabec.com', 0, 0, 'image.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `galeri_alam`
--

CREATE TABLE `galeri_alam` (
  `id_galeri` int(11) NOT NULL,
  `alam_galeri` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `galeri_alam`
--

INSERT INTO `galeri_alam` (`id_galeri`, `alam_galeri`) VALUES
(1, '1_sg.jpg'),
(1, '2_sg.jpg'),
(1, '3_sg.jpg'),
(1, '4_sg.jpg'),
(1, '5_sg.jpg'),
(1, '6_sg.jpg'),
(1, '7_sg.jpg'),
(1, '8_sg.jpg'),
(1, '9_sg.jpg'),
(1, '10_sg.jpg'),
(2, '1_tb.jpg'),
(2, '2_tb.jpg'),
(2, '3_tb.jpg'),
(2, '4_tb.jpg'),
(2, '5_tb.jpg'),
(2, '6_tb.jpg'),
(2, '7_tb.jpg'),
(2, '8_tb.jpg'),
(2, '9_tb.jpg'),
(2, '10_tb.jpg'),
(3, '1_kw.jpg'),
(3, '2_kw.jpg'),
(3, '3_kw.jpg'),
(3, '4_kw.jpg'),
(3, '5_kw.jpg'),
(3, '6_kw.jpg'),
(3, '7_kw.jpg'),
(3, '8_kw.jpg'),
(3, '9_kw.jpg'),
(3, '10_kw.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `galeri_belanja`
--

CREATE TABLE `galeri_belanja` (
  `id_belanja` int(11) NOT NULL,
  `galeri_belanja` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `galeri_belanja`
--

INSERT INTO `galeri_belanja` (`id_belanja`, `galeri_belanja`) VALUES
(4, '1_cb.jpg'),
(4, '2_cb.jpg'),
(4, '3_cb.jpg'),
(4, '4_cb.jpg'),
(4, '5_cb.jpg'),
(4, '6_cb.jpg'),
(4, '7_cb.jpg'),
(4, '8_cb.jpg'),
(4, '9_cb.jpg'),
(4, '10_cb.jpg'),
(5, '1_btc.jpg'),
(5, '2_btc.jpg'),
(5, '3_btc.jpg'),
(5, '4_btc.jpg'),
(5, '5_btc.jpg'),
(5, '6_btc.jpg'),
(5, '7_btc.jpg'),
(5, '8_btc.jpg'),
(5, '9_btc.jpg'),
(5, '10_btc.jpg'),
(6, '1_bec.jpg'),
(6, '2_bec.jpg'),
(6, '3_bec.jpg'),
(6, '4_bec.jpg'),
(6, '5_bec.jpg'),
(6, '6_bec.jpg'),
(6, '7_bec.jpg'),
(6, '8_bec.jpg'),
(6, '9_bec.jpg'),
(6, '10_bec.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `galeri_kuliner`
--

CREATE TABLE `galeri_kuliner` (
  `id_kuliner` int(11) NOT NULL,
  `galeri_kuliner` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `galeri_kuliner`
--

INSERT INTO `galeri_kuliner` (`id_kuliner`, `galeri_kuliner`) VALUES
(7, '1_seblak.jpg'),
(7, '2_seblak.jpg'),
(7, '3_seblak.jpg'),
(7, '4_seblak.jpg'),
(7, '5_seblak.jpg'),
(7, '6_seblak.jpg'),
(7, '7_seblak.jpg'),
(7, '8_seblak.jpg'),
(7, '9_seblak.jpg'),
(7, '10_seblak.jpg'),
(8, '1_tahu.jpg'),
(8, '2_tahu.jpg'),
(8, '3_tahu.jpg'),
(8, '4_tahu.jpg'),
(8, '5_tahu.jpg'),
(8, '6_tahu.jpg'),
(8, '7_tahu.jpg'),
(8, '8_tahu.jpg'),
(8, '9_tahu.jpg'),
(8, '10_tahu.jpg'),
(9, '1_py..jpg'),
(9, '2_py.jpg'),
(9, '3_py.jpg'),
(9, '4_py.jpg'),
(9, '5_py.jpg'),
(9, '6_py.jpg'),
(9, '7_py.jpg'),
(9, '8_py.jpg'),
(9, '9_py.jpg'),
(10, '10_py.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `kuliner`
--

CREATE TABLE `kuliner` (
  `id_kuliner` int(11) NOT NULL,
  `nama_kuliner` varchar(50) NOT NULL,
  `alamat_kuliner` varchar(250) NOT NULL,
  `harga_kuliner` varchar(50) NOT NULL,
  `jam_kuliner` time NOT NULL,
  `jamakhir_kuliner` time NOT NULL,
  `deskripsi_kuliner` varchar(10000) NOT NULL,
  `telepon_kuliner` varchar(15) NOT NULL,
  `lat_kuliner` double NOT NULL,
  `long_kuliner` double NOT NULL,
  `img` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `kuliner`
--

INSERT INTO `kuliner` (`id_kuliner`, `nama_kuliner`, `alamat_kuliner`, `harga_kuliner`, `jam_kuliner`, `jamakhir_kuliner`, `deskripsi_kuliner`, `telepon_kuliner`, `lat_kuliner`, `long_kuliner`, `img`) VALUES
(7, 'Seblak Basah Deu\' Tjenghar', 'Jl. Purnawarman, Babakan Ciamis, Sumur Bandung, Kota Bandung, Jawa Barat 40117', 'Rp 8.000-Rp 12.000', '10:00:00', '21:00:00', 'Seblak adalah jajanan khas bandung yang mencampurkan bahan dasar kerupuk mentah yang sengaja direndam dengan air panas agar bantan. Kemudian berbagai macam variasi topping lainnya di campurkan seperti makaroni, cilok, bakso, dll.', '085974759395', 0, 0, 'image.jpg'),
(8, 'Tahu Susu Lembang', 'Jl. Raya Lembang No.177, Jayagiri, Lembang, Kabupaten Bandung Barat, Jawa Barat 40266', 'Rp 15.000 /10 tahu', '08:00:00', '19:00:00', 'Sesuai dengan namanya tahu susu lembang diolah dengan cara mencampurkan kedelai dengan susu sehingga rasanya menjadi lebih gurih, lebih lembut, dengan isian yang padat.', '(021) 278-9008', 0, 0, 'image.jpg'),
(9, 'Peuyeum Bandung', 'Jl. Dr. Djunjunan No.135 G, Pajajaran, Cicendo, Kota Bandung, Jawa Barat 40173', 'Rp 12.000', '10:00:00', '21:00:00', 'Sejenis dengan tape, peunyeum cenderung lebih kering sedangkan tape biasanya banyak mengandung air. Penyeum dibuat dari bahan baku singkong.', '081222567890', 0, 0, 'image.jpg');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `alam`
--
ALTER TABLE `alam`
  ADD PRIMARY KEY (`id_alam`);

--
-- Indexes for table `belanja`
--
ALTER TABLE `belanja`
  ADD PRIMARY KEY (`id_belanja`);

--
-- Indexes for table `galeri_alam`
--
ALTER TABLE `galeri_alam`
  ADD KEY `id_galeri` (`id_galeri`);

--
-- Indexes for table `galeri_belanja`
--
ALTER TABLE `galeri_belanja`
  ADD KEY `id_belanja` (`id_belanja`);

--
-- Indexes for table `galeri_kuliner`
--
ALTER TABLE `galeri_kuliner`
  ADD KEY `id_kuliner` (`id_kuliner`);

--
-- Indexes for table `kuliner`
--
ALTER TABLE `kuliner`
  ADD PRIMARY KEY (`id_kuliner`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `alam`
--
ALTER TABLE `alam`
  MODIFY `id_alam` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `belanja`
--
ALTER TABLE `belanja`
  MODIFY `id_belanja` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `kuliner`
--
ALTER TABLE `kuliner`
  MODIFY `id_kuliner` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
