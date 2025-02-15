import java.util.ArrayList;
import java.util.Scanner;

public class PetShop {
    // Data produk disimpan dalam empat ArrayList paralel
    private ArrayList<Integer> ids;
    private ArrayList<String> names;
    private ArrayList<String> categories;
    private ArrayList<Double> prices;

    // Konstruktor (tidak menggunakan array literal)
    public PetShop() {
        ids = new ArrayList<>();
        names = new ArrayList<>();
        categories = new ArrayList<>();
        prices = new ArrayList<>();

        // Menambahkan produk awal dengan metode add()
        ids.add(1);
        names.add("Dog Food");
        categories.add("Makanan");
        prices.add(50000.0);

        ids.add(2);
        names.add("Cat Food");
        categories.add("Makanan");
        prices.add(45000.0);

        ids.add(3);
        names.add("Shampoo Anjing");
        categories.add("Perawatan");
        prices.add(120000.0);
    }

    // Setter dan Getter untuk produk berdasarkan indeks
    public int getProductId(int index) {
        return ids.get(index);
    }

    public void setProductId(int index, int id) {
        ids.set(index, id);
    }

    public String getProductName(int index) {
        return names.get(index);
    }

    public void setProductName(int index, String name) {
        names.set(index, name);
    }

    public String getProductCategory(int index) {
        return categories.get(index);
    }

    public void setProductCategory(int index, String category) {
        categories.set(index, category);
    }

    public double getProductPrice(int index) {
        return prices.get(index);
    }

    public void setProductPrice(int index, double price) {
        prices.set(index, price);
    }

    // Mengecek apakah ID sudah ada
    public boolean isDuplicateId(int id) {
        return ids.contains(id);
    }

    // Mengecek apakah Nama sudah ada (case-insensitive)
    public boolean isDuplicateName(String name) {
        for (String n : names) {
            if (n.equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }

    public void tampilkanProduk() {
        if (ids.isEmpty()) {
            System.out.println("\nDaftar produk kosong.");
            return;
        }
        System.out.println("\nDaftar Produk PetShop:");
        for (int i = 0; i < ids.size(); i++) {
            System.out.println("ID: " + getProductId(i)
                    + ", Nama: " + getProductName(i)
                    + ", Kategori: " + getProductCategory(i)
                    + ", Harga: " + getProductPrice(i));
        }
    }

    public void tambahProduk(Scanner scanner) {
        System.out.println("\nMasukkan ID, Nama Produk, Kategori Produk, dan Harga Produk (pisahkan dengan koma):");
        String input = scanner.nextLine();
        String[] data = input.split(",");
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

            ids.add(id);
            names.add(nama);
            categories.add(kategori);
            prices.add(harga);
            System.out.println("Produk berhasil ditambahkan!");
        } catch (Exception e) {
            System.out.println("Format input tidak valid. Silakan coba lagi.");
        }
    }

    public void ubahProduk(Scanner scanner) {
        try {
            System.out.print("\nMasukkan ID produk yang ingin diubah: ");
            int id = Integer.parseInt(scanner.nextLine());
            int index = -1;
            for (int i = 0; i < ids.size(); i++) {
                if (getProductId(i) == id) {
                    index = i;
                    break;
                }
            }
            if (index == -1) {
                System.out.println("Produk dengan ID " + id + " tidak ditemukan.");
                return;
            }

            System.out.println("Masukkan data baru (ID, Nama Produk, Kategori Produk, Harga Produk):");
            String input = scanner.nextLine();
            String[] data = input.split(",");
            int newId = Integer.parseInt(data[0].trim());
            String nama = data[1].trim();
            String kategori = data[2].trim();
            double harga = Double.parseDouble(data[3].trim());

            if (newId != id && isDuplicateId(newId)) {
                System.out.println("ERROR: ID baru sudah digunakan oleh produk lain!");
                return;
            }
            if (!nama.equalsIgnoreCase(getProductName(index)) && isDuplicateName(nama)) {
                System.out.println("ERROR: Nama produk baru sudah ada! Gunakan nama lain.");
                return;
            }

            // Update produk melalui setter
            setProductId(index, newId);
            setProductName(index, nama);
            setProductCategory(index, kategori);
            setProductPrice(index, harga);
            System.out.println("Data produk berhasil diubah.");
        } catch (Exception e) {
            System.out.println("Format input tidak valid.");
        }
    }

    public void hapusProduk(Scanner scanner) {
        try {
            System.out.print("\nMasukkan ID produk yang ingin dihapus: ");
            int id = Integer.parseInt(scanner.nextLine());
            int index = -1;
            for (int i = 0; i < ids.size(); i++) {
                if (getProductId(i) == id) {
                    index = i;
                    break;
                }
            }
            if (index != -1) {
                ids.remove(index);
                names.remove(index);
                categories.remove(index);
                prices.remove(index);
                System.out.println("Produk berhasil dihapus.");
            } else {
                System.out.println("Produk dengan ID " + id + " tidak ditemukan.");
            }
        } catch (Exception e) {
            System.out.println("Format input tidak valid.");
        }
    }

    public void cariProduk(Scanner scanner) {
        System.out.print("\nMasukkan nama produk yang ingin dicari: ");
        String nama = scanner.nextLine().trim();
        boolean found = false;
        for (int i = 0; i < names.size(); i++) {
            if (names.get(i).equalsIgnoreCase(nama)) {
                System.out.println("Produk ditemukan: ID: " + getProductId(i)
                        + ", Nama: " + getProductName(i)
                        + ", Kategori: " + getProductCategory(i)
                        + ", Harga: " + getProductPrice(i));
                found = true;
            }
        }
        if (!found) {
            System.out.println("Produk dengan nama '" + nama + "' tidak ditemukan.");
        }
    }
    
}
