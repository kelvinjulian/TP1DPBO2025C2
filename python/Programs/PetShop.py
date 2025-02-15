# PetShop.py
class PetShop:
    class Product:
        def __init__(self, id, nama, kategori, harga):
            self.id = id
            self.nama = nama
            self.kategori = kategori
            self.harga = harga
        
        def get_id(self):
            return self.id
        
        def set_id(self, id):
            self.id = id
        
        def get_nama(self):
            return self.nama
        
        def set_nama(self, nama):
            self.nama = nama
        
        def get_kategori(self):
            return self.kategori
        
        def set_kategori(self, kategori):
            self.kategori = kategori
        
        def get_harga(self):
            return self.harga
        
        def set_harga(self, harga):
            self.harga = harga
    
    def __init__(self):
        self.products = [
            self.Product(1, "Dog Food", "Makanan", 50000),
            self.Product(2, "Cat Food", "Makanan", 45000),
            self.Product(3, "Shampoo Anjing", "Perawatan", 120000)
        ]
    
    def is_duplicate_id(self, id):
        return any(p.get_id() == id for p in self.products)
    
    def is_duplicate_name(self, name):
        return any(p.get_nama().lower() == name.lower() for p in self.products)
    
    def tampilkan_produk(self):
        if not self.products:
            print("\nDaftar produk kosong.")
            return
        print("\nDaftar Produk PetShop:")
        for p in self.products:
            print(f"ID: {p.get_id()}, Nama: {p.get_nama()}, Kategori: {p.get_kategori()}, Harga: {p.get_harga()}")
    
    def tambah_produk(self):
        print("\nMasukkan ID, Nama Produk, Kategori Produk, dan Harga Produk:")
        try:
            data = input().split(",")
            id, nama, kategori, harga = int(data[0].strip()), data[1].strip(), data[2].strip(), float(data[3].strip())
            
            if self.is_duplicate_id(id):
                print("ERROR: ID sudah ada! Gunakan ID lain.")
                return
            if self.is_duplicate_name(nama):
                print("ERROR: Nama produk sudah ada! Gunakan nama lain.")
                return
            
            self.products.append(self.Product(id, nama, kategori, harga))
            print("Produk berhasil ditambahkan!")
        except:
            print("Format input tidak valid. Silakan coba lagi.")
    
    def ubah_produk(self):
        try:
            id = int(input("\nMasukkan ID produk yang ingin diubah: "))
            for p in self.products:
                if p.get_id() == id:
                    print("Masukkan data baru (ID, Nama Produk, Kategori Produk, Harga Produk):")
                    data = input().split(",")
                    new_id, nama, kategori, harga = int(data[0].strip()), data[1].strip(), data[2].strip(), float(data[3].strip())
                    
                    if new_id != id and self.is_duplicate_id(new_id):
                        print("ERROR: ID baru sudah digunakan oleh produk lain!")
                        return
                    if nama != p.get_nama() and self.is_duplicate_name(nama):
                        print("ERROR: Nama produk baru sudah ada! Gunakan nama lain.")
                        return
                    
                    p.set_id(new_id)
                    p.set_nama(nama)
                    p.set_kategori(kategori)
                    p.set_harga(harga)
                    print("Data produk berhasil diubah.")
                    return
            print(f"Produk dengan ID {id} tidak ditemukan.")
        except:
            print("Format input tidak valid.")
    
    def hapus_produk(self):
        try:
            id = int(input("\nMasukkan ID produk yang ingin dihapus: "))
            for i, p in enumerate(self.products):
                if p.get_id() == id:
                    del self.products[i]
                    print("Produk berhasil dihapus.")
                    return
            print(f"Produk dengan ID {id} tidak ditemukan.")
        except:
            print("Format input tidak valid.")
    
    def cari_produk(self):
        nama = input("\nMasukkan nama produk yang ingin dicari: ").strip()
        found = [p for p in self.products if p.get_nama().lower() == nama.lower()]
        if found:
            for p in found:
                print(f"Produk ditemukan: ID: {p.get_id()}, Nama: {p.get_nama()}, Kategori: {p.get_kategori()}, Harga: {p.get_harga()}")
        else:
            print(f"Produk dengan nama '{nama}' tidak ditemukan.")