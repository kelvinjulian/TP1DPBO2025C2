
<?php
class PetShop {
    private $conn;
    private $nama;
    private $kategori;
    private $harga;
    private $gambar;

    public function __construct($host, $user, $password, $dbname) {
        $this->conn = new mysqli($host, $user, $password, $dbname);
        if ($this->conn->connect_error) {
            die("Connection failed: " . $this->conn->connect_error);
        }
    }

    public function __destruct() {
        $this->conn->close();
    }

    public function setNama($nama) {
        $this->nama = $nama;
    }
    public function getNama() {
        return $this->nama;
    }

    public function setKategori($kategori) {
        $this->kategori = $kategori;
    }
    public function getKategori() {
        return $this->kategori;
    }

    public function setHarga($harga) {
        $this->harga = $harga;
    }
    public function getHarga() {
        return $this->harga;
    }

    public function setGambar($gambar) {
        if ($gambar) {
            $this->gambar = basename($gambar["name"]);
            move_uploaded_file($gambar["tmp_name"], "uploads/" . $this->gambar);
        }
    }
    public function getGambar() {
        return $this->gambar;
    }

    public function tampilkanProduk() {
        $sql = "SELECT * FROM produk";
        $result = $this->conn->query($sql);
        
        if ($result->num_rows > 0) {
            echo "<h2>Daftar Produk PetShop</h2>";
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
            echo "<p>Daftar produk kosong.</p>";
        }
    }

    public function tambahProduk() {
        $sql = "INSERT INTO produk (nama, kategori, harga, gambar) VALUES (?, ?, ?, ?)";
        $stmt = $this->conn->prepare($sql);
        $stmt->bind_param("ssds", $this->nama, $this->kategori, $this->harga, $this->gambar);
        $stmt->execute();
        echo "Produk berhasil ditambahkan!";
    }

    public function hapusProduk($id) {
        $sql = "DELETE FROM produk WHERE id = ?";
        $stmt = $this->conn->prepare($sql);
        $stmt->bind_param("i", $id);
        $stmt->execute();
        echo "Produk berhasil dihapus.";
    }

    public function ubahProduk($id, $nama, $kategori, $harga, $gambar) {
        $sql = "UPDATE produk SET nama=?, kategori=?, harga=?, gambar=? WHERE id=?";
        $stmt = $this->conn->prepare($sql);
        $stmt->bind_param("ssdsi", $nama, $kategori, $harga, $gambar, $id);
        $stmt->execute();
        echo "Produk berhasil diubah.";
    }

    public function getProdukById($id) {
        $sql = "SELECT * FROM produk WHERE id = ?";
        $stmt = $this->conn->prepare($sql);
        $stmt->bind_param("i", $id);
        $stmt->execute();
        return $stmt->get_result()->fetch_assoc();
    }

    public function cariProduk($keyword) {
        $sql = "SELECT * FROM produk WHERE nama LIKE ?";
        $stmt = $this->conn->prepare($sql);
        $search = "%" . $keyword . "%";
        $stmt->bind_param("s", $search);
        $stmt->execute();
        return $stmt->get_result();
    }
}
?>