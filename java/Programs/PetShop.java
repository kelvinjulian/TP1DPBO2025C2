import java.util.ArrayList;
import java.util.Scanner;

public class PetShop {
    static class Product {
        private int id;
        private String nama;
        private String kategori;
        private double harga;

        public Product(int id, String nama, String kategori, double harga) {
            this.id = id;
            this.nama = nama;
            this.kategori = kategori;
            this.harga = harga;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getNama() {
            return nama;
        }

        public void setNama(String nama) {
            this.nama = nama;
        }

        public String getKategori() {
            return kategori;
        }

        public void setKategori(String kategori) {
            this.kategori = kategori;
        }

        public double getHarga() {
            return harga;
        }

        public void setHarga(double harga) {
            this.harga = harga;
        }
    }

    private ArrayList<Product> products;

    public PetShop() {
        products = new ArrayList<>();
        products.add(new Product(1, "Dog Food", "Makanan", 50000));
        products.add(new Product(2, "Cat Food", "Makanan", 45000));
        products.add(new Product(3, "Shampoo Anjing", "Perawatan", 120000));
    }

    public boolean isDuplicateId(int id) {
        return products.stream().anyMatch(p -> p.getId() == id);
    }

    public boolean isDuplicateName(String name) {
        return products.stream().anyMatch(p -> p.getNama().equalsIgnoreCase(name));
    }

    public void tampilkanProduk() {
        if (products.isEmpty()) {
            System.out.println("\nDaftar produk kosong.");
            return;
        }
        System.out.println("\nDaftar Produk PetShop:");
        for (Product p : products) {
            System.out.println("ID: " + p.getId() + ", Nama: " + p.getNama() +
                    ", Kategori: " + p.getKategori() + ", Harga: " + p.getHarga());
        }
    }

    public void tambahProduk(Scanner scanner) {
        System.out.println("\nMasukkan ID, Nama Produk, Kategori Produk, dan Harga Produk (pisahkan dengan koma):");
        String[] data = scanner.nextLine().split(",");
        try {
            int id = Integer.parseInt(data[0].trim());
            String nama = data[1].trim();
            String kategori = data[2].trim();
            double harga = Double.parseDouble(data[3].trim());

            if (isDuplicateId(id)) {
                System.out.println("ERROR: ID sudah ada! Gunakan ID lain.");
                return;
            }
            if (isDuplicateName(nama)) {
                System.out.println("ERROR: Nama produk sudah ada! Gunakan nama lain.");
                return;
            }

            products.add(new Product(id, nama, kategori, harga));
            System.out.println("Produk berhasil ditambahkan!");
        } catch (Exception e) {
            System.out.println("Format input tidak valid. Silakan coba lagi.");
        }
    }

    public void ubahProduk(Scanner scanner) {
        try {
            System.out.print("\nMasukkan ID produk yang ingin diubah: ");
            int id = Integer.parseInt(scanner.nextLine());

            for (Product p : products) {
                if (p.getId() == id) {
                    System.out.println("Masukkan data baru (ID, Nama Produk, Kategori Produk, Harga Produk):");
                    String[] data = scanner.nextLine().split(",");

                    int newId = Integer.parseInt(data[0].trim());
                    String nama = data[1].trim();
                    String kategori = data[2].trim();
                    double harga = Double.parseDouble(data[3].trim());

                    if (newId != id && isDuplicateId(newId)) {
                        System.out.println("ERROR: ID baru sudah digunakan oleh produk lain!");
                        return;
                    }
                    if (!nama.equalsIgnoreCase(p.getNama()) && isDuplicateName(nama)) {
                        System.out.println("ERROR: Nama produk baru sudah ada! Gunakan nama lain.");
                        return;
                    }

                    p.setId(newId);
                    p.setNama(nama);
                    p.setKategori(kategori);
                    p.setHarga(harga);
                    System.out.println("Data produk berhasil diubah.");
                    return;
                }
            }
            System.out.println("Produk dengan ID " + id + " tidak ditemukan.");
        } catch (Exception e) {
            System.out.println("Format input tidak valid.");
        }
    }

    public void hapusProduk(Scanner scanner) {
        try {
            System.out.print("\nMasukkan ID produk yang ingin dihapus: ");
            int id = Integer.parseInt(scanner.nextLine());

            for (int i = 0; i < products.size(); i++) {
                if (products.get(i).getId() == id) {
                    products.remove(i);
                    System.out.println("Produk berhasil dihapus.");
                    return;
                }
            }
            System.out.println("Produk dengan ID " + id + " tidak ditemukan.");
        } catch (Exception e) {
            System.out.println("Format input tidak valid.");
        }
    }

    public void cariProduk(Scanner scanner) {
        System.out.print("\nMasukkan nama produk yang ingin dicari: ");
        String nama = scanner.nextLine().trim();
        boolean found = false;

        for (Product p : products) {
            if (p.getNama().equalsIgnoreCase(nama)) {
                System.out.println("Produk ditemukan: ID: " + p.getId() +
                        ", Nama: " + p.getNama() + ", Kategori: " + p.getKategori() + ", Harga: " + p.getHarga());
                found = true;
            }
        }

        if (!found) {
            System.out.println("Produk dengan nama '" + nama + "' tidak ditemukan.");
        }
    }
}
