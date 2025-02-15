<?php
require 'PetShop.php';
$shop = new PetShop("localhost", "root", "", "db_petshop");

if (isset($_GET['id'])) {
    $produk = $shop->getProdukById($_GET['id']);
}

if ($_SERVER['REQUEST_METHOD'] == 'POST' && isset($_POST['ubah'])) {
    $shop->ubahProduk($_POST['id'], $_POST['nama'], $_POST['kategori'], $_POST['harga'], $_FILES['gambar']['name']);
    header("Location: main.php");
}
?>

<!DOCTYPE html>
<html>
<head>
    <title>Ubah Produk</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <h2>Ubah Produk</h2>

    <?php if (!empty($produk['gambar'])): ?>
    <div class="image-container">
        <img src="uploads/<?php echo $produk['gambar']; ?>" alt="Gambar Produk">
    </div>
    <?php endif; ?>

    <form method="post" enctype="multipart/form-data">
        <input type="hidden" name="id" value="<?php echo $produk['id']; ?>">
        Nama: <input type="text" name="nama" value="<?php echo $produk['nama']; ?>" required><br>
        Kategori: <input type="text" name="kategori" value="<?php echo $produk['kategori']; ?>" required><br>
        Harga: <input type="number" name="harga" value="<?php echo $produk['harga']; ?>" required><br>
        Gambar: <input type="file" name="gambar"><br>
        <input type="submit" name="ubah" value="Ubah Produk">
    </form>
    <a href="main.php">Kembali</a>
</body>
</html>