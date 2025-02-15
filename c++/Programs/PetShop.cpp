#include <iostream>
#include <vector>
#include <sstream>
using namespace std;

class PetShop {
private:
    // Menyimpan data produk menggunakan 4 vector paralel
    vector<int> ids;
    vector<string> names;
    vector<string> categories;
    vector<float> prices;

    // Setter dan Getter untuk masing-masing atribut produk berdasarkan index
    int getProductId(int index) const {
        return ids[index];
    }
    void setProductId(int index, int id) {
        ids[index] = id;
    }

    string getProductName(int index) const {
        return names[index];
    }
    void setProductName(int index, const string &name) {
        names[index] = name;
    }

    string getProductCategory(int index) const {
        return categories[index];
    }
    void setProductCategory(int index, const string &category) {
        categories[index] = category;
    }

    float getProductPrice(int index) const {
        return prices[index];
    }
    void setProductPrice(int index, float price) {
        prices[index] = price;
    }

    // Fungsi untuk mengecek apakah ID sudah ada
    bool isDuplicateID(int id) {
        for (int x : ids) {
            if (x == id) {
                return true;
            }
        }
        return false;
    }

    // Fungsi untuk mengecek apakah Nama Produk sudah ada
    bool isDuplicateName(const string &name) {
        for (const auto &n : names) {
            if (n == name) {
                return true;
            }
        }
        return false;
    }

public:
    PetShop() {
        // Menambahkan produk awal
        ids.push_back(1);
        names.push_back("Dog Food");
        categories.push_back("Makanan");
        prices.push_back(50000);

        ids.push_back(2);
        names.push_back("Cat Food");
        categories.push_back("Makanan");
        prices.push_back(45000);

        ids.push_back(3);
        names.push_back("Shampoo Anjing");
        categories.push_back("Perawatan");
        prices.push_back(120000);
    }

    void tampilkanProduk() {
        if (ids.empty()) {
            cout << "\nDaftar produk kosong." << endl;
            return;
        }

        cout << "\nDaftar Produk PetShop:\n";
        for (size_t i = 0; i < ids.size(); i++) {
            cout << "ID: " << getProductId(i)
                 << ", Nama: " << getProductName(i)
                 << ", Kategori: " << getProductCategory(i)
                 << ", Harga: " << getProductPrice(i)
                 << endl;
        }
    }

    void tambahProduk() {
        cout << "\nMasukkan ID, Nama Produk, Kategori Produk, dan Harga Produk:\n";

        string input;
        cin.ignore();
        getline(cin, input);

        stringstream ss(input);
        string idStr, nama, kategori, hargaStr;

        if (getline(ss, idStr, ',') &&
            getline(ss >> ws, nama, ',') &&
            getline(ss >> ws, kategori, ',') &&
            getline(ss >> ws, hargaStr)) {

            int id = stoi(idStr);
            float harga = stof(hargaStr);

            // Cek apakah ID atau Nama sudah ada
            if (isDuplicateID(id)) {
                cout << "ERROR: ID sudah ada! Gunakan ID lain.\n";
                return;
            }
            if (isDuplicateName(nama)) {
                cout << "ERROR: Nama produk sudah ada! Gunakan nama lain.\n";
                return;
            }

            ids.push_back(id);
            names.push_back(nama);
            categories.push_back(kategori);
            prices.push_back(harga);
            cout << "Produk berhasil ditambahkan!\n";
        } else {
            cout << "Format input tidak valid. Silakan coba lagi.\n";
        }
    }

    void ubahProduk() {
        int id;
        cout << "\nMasukkan ID produk yang ingin diubah: ";
        cin >> id;
        cin.ignore();

        int index = -1;
        for (size_t i = 0; i < ids.size(); i++) {
            if (getProductId(i) == id) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            cout << "Produk dengan ID " << id << " tidak ditemukan.\n";
            return;
        }

        cout << "Masukkan data baru (ID, Nama Produk, Kategori Produk, Harga Produk):\n";
        string input;
        getline(cin, input);

        stringstream ss(input);
        string idStr, nama, kategori, hargaStr;

        if (getline(ss, idStr, ',') &&
            getline(ss >> ws, nama, ',') &&
            getline(ss >> ws, kategori, ',') &&
            getline(ss >> ws, hargaStr)) {

            int newId = stoi(idStr);
            float newHarga = stof(hargaStr);

            // Pastikan ID baru tidak bentrok dengan produk lain (kecuali produk yang sama)
            if (newId != id && isDuplicateID(newId)) {
                cout << "ERROR: ID baru sudah digunakan oleh produk lain!\n";
                return;
            }

            // Pastikan Nama baru tidak bentrok dengan produk lain (kecuali produk yang sama)
            if (nama != getProductName(index) && isDuplicateName(nama)) {
                cout << "ERROR: Nama produk baru sudah ada! Gunakan nama lain.\n";
                return;
            }

            // Update produk menggunakan setter
            setProductId(index, newId);
            setProductName(index, nama);
            setProductCategory(index, kategori);
            setProductPrice(index, newHarga);

            cout << "Data produk berhasil diubah.\n";
        } else {
            cout << "Format input tidak valid.\n";
        }
    }

    void hapusProduk() {
        int id;
        cout << "\nMasukkan ID produk yang ingin dihapus: ";
        cin >> id;

        int index = -1;
        for (size_t i = 0; i < ids.size(); i++) {
            if (getProductId(i) == id) {
                index = i;
                break;
            }
        }

        if (index != -1) {
            ids.erase(ids.begin() + index);
            names.erase(names.begin() + index);
            categories.erase(categories.begin() + index);
            prices.erase(prices.begin() + index);
            cout << "Produk berhasil dihapus.\n";
        } else {
            cout << "Produk dengan ID " << id << " tidak ditemukan.\n";
        }
    }

    void cariProduk() {
        cout << "\nMasukkan nama produk yang ingin dicari: ";
        string nama;
        cin.ignore();
        getline(cin, nama);

        bool found = false;
        for (size_t i = 0; i < names.size(); i++) {
            if (getProductName(i) == nama) {
                cout << "Produk ditemukan: ID: " << getProductId(i)
                     << ", Nama: " << getProductName(i)
                     << ", Kategori: " << getProductCategory(i)
                     << ", Harga: " << getProductPrice(i)
                     << endl;
                found = true;
            }
        }

        if (!found) {
            cout << "Produk dengan nama '" << nama << "' tidak ditemukan.\n";
        }
    }
};

