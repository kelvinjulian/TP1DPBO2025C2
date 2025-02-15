class PetShop:
    def __init__(self):
        # Data produk disimpan dalam empat list paralel
        self.ids = []
        self.names = []
        self.categories = []
        self.hargas = []
        
        # Menambahkan produk awal menggunakan append (tanpa list literal)
        self.ids.append(1)
        self.names.append("Dog Food")
        self.categories.append("Makanan")
        self.hargas.append(50000)
        
        self.ids.append(2)
        self.names.append("Cat Food")
        self.categories.append("Makanan")
        self.hargas.append(45000)
        
        self.ids.append(3)
        self.names.append("Shampoo Anjing")
        self.categories.append("Perawatan")
        self.hargas.append(120000)
    
    # Setter dan Getter untuk tiap atribut produk berdasarkan index
    def get_product_id(self, index):
        return self.ids[index]
    
    def set_product_id(self, index, id):
        self.ids[index] = id
    
    def get_product_name(self, index):
        return self.names[index]
    
    def set_product_name(self, index, name):
        self.names[index] = name
    
    def get_product_category(self, index):
        return self.categories[index]
    
    def set_product_category(self, index, category):
        self.categories[index] = category
    
    def get_product_harga(self, index):
        return self.hargas[index]
    
    def set_product_harga(self, index, harga):
        self.hargas[index] = harga
    
    # Mengecek apakah ID sudah ada
    def is_duplicate_id(self, id):
        return id in self.ids
    
    # Mengecek apakah nama produk sudah ada (case-insensitive)
    def is_duplicate_name(self, name):
        return any(n.lower() == name.lower() for n in self.names)
    
    def tampilkan_produk(self):
        if not self.ids:
            print("\nDaftar produk kosong.")
            return
        print("\nDaftar Produk PetShop:")
        for i in range(len(self.ids)):
            print(f"ID: {self.get_product_id(i)}, Nama: {self.get_product_name(i)}, "
                  f"Kategori: {self.get_product_category(i)}, Harga: {self.get_product_harga(i)}")
    
    def tambah_produk(self):
        print("\nMasukkan ID, Nama Produk, Kategori Produk, dan Harga Produk (pisahkan dengan koma):")
        try:
            data = input().split(",")
            id = int(data[0].strip())
            nama = data[1].strip()
            kategori = data[2].strip()
            harga = float(data[3].strip())
            
            if self.is_duplicate_id(id):
                print("ERROR: ID sudah ada! Gunakan ID lain.")
                return
            if self.is_duplicate_name(nama):
                print("ERROR: Nama produk sudah ada! Gunakan nama lain.")
                return
            
            self.ids.append(id)
            self.names.append(nama)
            self.categories.append(kategori)
            self.hargas.append(harga)
            print("Produk berhasil ditambahkan!")
        except Exception as e:
            print("Format input tidak valid. Silakan coba lagi.")
    
    def ubah_produk(self):
        try:
            id = int(input("\nMasukkan ID produk yang ingin diubah: "))
            index = -1
            for i in range(len(self.ids)):
                if self.get_product_id(i) == id:
                    index = i
                    break
            if index == -1:
                print(f"Produk dengan ID {id} tidak ditemukan.")
                return
            
            print("Masukkan data baru (ID, Nama Produk, Kategori Produk, Harga Produk):")
            data = input().split(",")
            new_id = int(data[0].strip())
            nama = data[1].strip()
            kategori = data[2].strip()
            harga = float(data[3].strip())
            
            if new_id != id and self.is_duplicate_id(new_id):
                print("ERROR: ID baru sudah digunakan oleh produk lain!")
                return
            if nama.lower() != self.get_product_name(index).lower() and self.is_duplicate_name(nama):
                print("ERROR: Nama produk baru sudah ada! Gunakan nama lain.")
                return
            
            self.set_product_id(index, new_id)
            self.set_product_name(index, nama)
            self.set_product_category(index, kategori)
            self.set_product_harga(index, harga)
            print("Data produk berhasil diubah.")
        except Exception as e:
            print("Format input tidak valid.")
    
    def hapus_produk(self):
        try:
            id = int(input("\nMasukkan ID produk yang ingin dihapus: "))
            index = -1
            for i in range(len(self.ids)):
                if self.get_product_id(i) == id:
                    index = i
                    break
            if index != -1:
                del self.ids[index]
                del self.names[index]
                del self.categories[index]
                del self.hargas[index]
                print("Produk berhasil dihapus.")
            else:
                print(f"Produk dengan ID {id} tidak ditemukan.")
        except Exception as e:
            print("Format input tidak valid.")
    
    def cari_produk(self):
        nama = input("\nMasukkan nama produk yang ingin dicari: ").strip()
        found = False
        for i in range(len(self.ids)):
            if self.get_product_name(i).lower() == nama.lower():
                print(f"Produk ditemukan: ID: {self.get_product_id(i)}, Nama: {self.get_product_name(i)}, "
                      f"Kategori: {self.get_product_category(i)}, Harga: {self.get_product_harga(i)}")
                found = True
        if not found:
            print(f"Produk dengan nama '{nama}' tidak ditemukan.")


