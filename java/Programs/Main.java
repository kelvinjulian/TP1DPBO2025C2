import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PetShop petshop = new PetShop();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== Menu PetShop =====");
            System.out.println("1. Tampilkan Produk");
            System.out.println("2. Tambah Produk");
            System.out.println("3. Ubah Produk");
            System.out.println("4. Hapus Produk");
            System.out.println("5. Cari Produk");
            System.out.println("6. Keluar");
            System.out.print("Pilih opsi: ");

            String pilihan = scanner.nextLine();
            switch (pilihan) {
                case "1":
                    petshop.tampilkanProduk();
                    break;
                case "2":
                    petshop.tambahProduk(scanner);
                    break;
                case "3":
                    petshop.ubahProduk(scanner);
                    break;
                case "4":
                    petshop.hapusProduk(scanner);
                    break;
                case "5":
                    petshop.cariProduk(scanner);
                    break;
                case "6":
                    System.out.println("Keluar dari program...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opsi tidak valid! Silakan pilih kembali.");
            }
        }
    }
}
