# main.py
from PetShop import PetShop

if __name__ == "__main__":
    petshop = PetShop()
    while True:
        print("\n===== Menu PetShop =====")
        print("1. Tampilkan Produk")
        print("2. Tambah Produk")
        print("3. Ubah Produk")
        print("4. Hapus Produk")
        print("5. Cari Produk")
        print("6. Keluar")
        pilihan = input("Pilih opsi: ")
        
        if pilihan == "1":
            petshop.tampilkan_produk()
        elif pilihan == "2":
            petshop.tambah_produk()
        elif pilihan == "3":
            petshop.ubah_produk()
        elif pilihan == "4":
            petshop.hapus_produk()
        elif pilihan == "5":
            petshop.cari_produk()
        elif pilihan == "6":
            print("Keluar dari program...")
            break
        else:
            print("Opsi tidak valid! Silakan pilih kembali.")
