<?php
require 'PetShop.php';
$shop = new PetShop("localhost", "root", "", "db_petshop");

if ($_SERVER['REQUEST_METHOD'] == 'POST' && isset($_POST['tambah'])) {
    $shop->setNama($_POST['nama']);
    $shop->setKategori($_POST['kategori']);
    $shop->setHarga($_POST['harga']);
    $shop->setGambar($_FILES['gambar']);
    $shop->tambahProduk();
}
if ($_SERVER['REQUEST_METHOD'] == 'POST' && isset($_POST['hapus'])) {
    $shop->hapusProduk($_POST['id']);
}
if ($_SERVER['REQUEST_METHOD'] == 'POST' && isset($_POST['ubah'])) {
    $shop->ubahProduk($_POST['id'], $_POST['nama'], $_POST['kategori'], $_POST['harga'], $_FILES['gambar']['name']);
}
?>

<!DOCTYPE html>
<html>
<head>
    <title>PetShop</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <form method="post">
        <input type="text" name="keyword" placeholder="Cari produk...">
        <input type="submit" name="cari" value="Cari">
    </form>

    <?php 
    if (isset($_POST['cari'])) {
        $result = $shop->cariProduk($_POST['keyword']);
        
        echo "<h2>Hasil Pencarian</h2>";
        
        if ($result->num_rows > 0) {
            echo "<h2>Hasil Pencarian</h2>";
            echo "<table border='1'><tr><th>ID</th><th>Nama</th><th>Kategori</th><th>Harga</th><th>Gambar</th><th>Aksi</th></tr>";
            while ($row = $result->fetch_assoc()) {
                echo "<tr><td>{$row['id']}</td><td>{$row['nama']}</td><td>{$row['kategori']}</td><td>{$row['harga']}</td>";
                echo "<td><img src='uploads/{$row['gambar']}' width='100'></td>";
                echo "<td>
                    <form method='post' style='display:inline;'>
                        <input type='hidden' name='id' value='{$row['id']}'>
                        <input type='submit' name='hapus' value='Hapus'>
                    </form>
                    <a href='ubah.php?id={$row['id']}'>Ubah</a>
                </td></tr>";
            }
            echo "</table>";
        } else {
            echo "<p>Produk tidak ditemukan.</p>";
        }
    }
    ?>

    <h2>Daftar Produk</h2>
    <?php $shop->tampilkanProduk(); ?>

    <h2>Tambah Produk</h2>
    <form method="post" enctype="multipart/form-data">
        Nama: <input type="text" name="nama" required><br>
        Kategori: <input type="text" name="kategori" required><br>
        Harga: <input type="number" name="harga" required><br>
        Gambar: <input type="file" name="gambar" required><br>
        <input type="submit" name="tambah" value="Tambah Produk">
    </form>
</body>
</html>
