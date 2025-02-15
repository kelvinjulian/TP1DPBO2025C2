# TP1DPBO2025C2 dan Latihan Modul

# Janji
Saya Kelvin Julian Putra dengan NIM 2205101 mengerjakan Tugas Praktikum 1 dalam mata kuliah Desain dan Pemrograman Berorientasi Objek untuk keberkahanNya maka saya tidak melakukan kecurangan seperti yang telah dispesifikasikan. Aamiin

# PetShop

PetShop adalah program yang menggunakan konsep Object-Oriented Programming (OOP) untuk mengelola daftar produk di sebuah petshop. Program ini memungkinkan pengguna untuk menambahkan, mengubah, menghapus, mencari, dan menampilkan daftar produk.

## Struktur OOP
Program ini dibangun menggunakan pendekatan OOP dengan kelas dan objek sebagai berikut:

### **1. Kelas `PetShop`**
Kelas `PetShop` berfungsi sebagai pengelola produk dalam sistem. Kelas ini memiliki atribut dan metode berikut:

#### **Atribut:**
- `vector<Product> products` → Menyimpan daftar produk dalam bentuk **vector**.

#### **Metode Publik:**
- `PetShop()` → Konstruktor yang menginisialisasi daftar produk awal.
- `void tampilkanProduk()` → Menampilkan semua produk yang tersedia.
- `void tambahProduk()` → Menambahkan produk baru ke dalam daftar.
- `void ubahProduk()` → Mengubah informasi produk berdasarkan ID.
- `void hapusProduk()` → Menghapus produk berdasarkan ID.
- `void cariProduk()` → Mencari produk berdasarkan nama.

#### **Metode Privat:**
- `bool isDuplicateID(int id)` → Mengecek apakah ID produk sudah ada dalam daftar.
- `bool isDuplicateName(const string& name)` → Mengecek apakah nama produk sudah ada dalam daftar.

### **2. Struktur `Product` (Nested Struct)**
Kelas `PetShop` memiliki **struktur `Product`** yang merepresentasikan produk dalam sistem.

#### **Atribut Produk:**
- `int id` → ID unik produk.
- `string nama` → Nama produk.
- `string kategori` → Kategori produk.
- `float harga` → Harga produk.

#### **Metode Produk:**
- Konstruktor `Product(int id, string nama, string kategori, float harga)` → Menginisialisasi produk.
- Getter dan setter untuk setiap atribut (`getId()`, `setId()`, `getNama()`, dll.).

## **Fitur Utama**
1. **Menampilkan Produk** → Menampilkan semua produk yang tersedia.
2. **Menambahkan Produk** → Memasukkan produk baru dengan ID unik.
3. **Mengubah Produk** → Mengedit detail produk berdasarkan ID.
4. **Menghapus Produk** → Menghapus produk dari daftar berdasarkan ID.
5. **Mencari Produk** → Mencari produk berdasarkan nama.
## Screenshot

Berikut adalah beberapa tampilan dari program:

### 1. Menampilkan Produk

![Tampilkan Produk](https://github.com/kelvinjulian/LM1DPBO2025C2/blob/main/c%2B%2B/Screenshots/Tampilkan%20Produk.png)

### 2. Menambah Produk

![Tambah Produk](https://github.com/kelvinjulian/LM1DPBO2025C2/blob/main/c%2B%2B/Screenshots/Tambah%20Produk.png)

### 3. Mengubah Produk

![Ubah Produk](https://github.com/kelvinjulian/LM1DPBO2025C2/blob/main/c%2B%2B/Screenshots/Ubah%20Produk.png)

### 4. Menghapus Produk

![Hapus Produk](https://github.com/kelvinjulian/LM1DPBO2025C2/blob/main/c%2B%2B/Screenshots/Hapus%20Produk.png)

### 5. Mencari Produk

![Cari Produk](https://github.com/kelvinjulian/LM1DPBO2025C2/blob/main/c%2B%2B/Screenshots/Cari%20Produk.png)

### 6. Keluar dari Program

![Keluar](https://github.com/kelvinjulian/LM1DPBO2025C2/blob/main/c%2B%2B/Screenshots/Keluar.png)

### 7. Error Duplikat

![Error Duplikat](https://github.com/kelvinjulian/LM1DPBO2025C2/blob/main/c%2B%2B/Screenshots/Error%20Duplikat.png)

## Screenrecord (PHP)
(https://drive.google.com/file/d/1XAYyEMAkhgbrZY1IXFX52MYn12cWOrqz/view?usp=sharing)

## Class Diagram

![Class Diagram](https://github.com/kelvinjulian/TP1DPBO2025C2/blob/main/Class%20Diagram.drawio.png)
