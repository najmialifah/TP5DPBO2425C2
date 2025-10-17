## 🧩 Tugas Praktikum 5 DPBO 2024/2025

Saya **Najmi Alifah Hilmiya** dengan **NIM 2410393** mengerjakan **Tugas Praktikum 5** dalam mata kuliah *Desain Pemrograman Berorientasi Objek* untuk keberkahan-Nya, maka saya tidak melakukan kecurangan seperti yang telah dispesifikasikan.  
**Aamiin.**

Aplikasi ini digunakan untuk mengelola data menu pada sebuah **kafe** dengan fitur CRUD (*Create, Read, Update, Delete*) yang ditampilkan melalui **antarmuka grafis (GUI)** berbasis Java Swing.

---

## 🧠 Desain Program
Desain program terdiri dari dua kelas utama, yaitu `Product.java` dan `ProductMenu.java`.

### 📘 `Product.java`
Kelas ini berfungsi sebagai **model data**, yang menyimpan informasi setiap menu kafe seperti:
- Kode menu  
- Nama menu  
- Harga  
- Kategori  
- Merek (*atribut tambahan*)

Atribut `merek` merupakan **fitur bonus** menggunakan komponen `JComboBox`, sehingga pengguna dapat memilih brand menu dengan cara yang lebih interaktif.

### 💻 `ProductMenu.java`
Kelas ini merupakan **kelas utama GUI** yang mengatur tampilan dan logika aplikasi.  
Komponen utama yang digunakan meliputi:
- `JTextField` → input teks (ID, Nama, Harga)  
- `JComboBox` → pilihan kategori & merek  
- `JButton` → aksi utama (Add, Update, Delete, Cancel)  
- `JTable` → menampilkan daftar menu  

Tampilan program menggunakan tema modern **Nimbus Look and Feel**.  
Selain itu, disediakan **data awal bertema kafe** seperti kopi, dessert, dan makanan ringan agar tabel tidak kosong saat pertama kali dijalankan.

---

## 🔄 Penjelasan Alur Program
Ketika program dijalankan, pengguna akan melihat tampilan utama berisi tabel daftar menu kafe dan form input di bagian atas.  

Fitur-fitur utama:
1. **Tambah Data (Add)**  
   - Isi seluruh form (ID, nama, harga, kategori, dan merek)  
   - Tekan tombol **Add** untuk menyimpan ke database  
   - Data baru otomatis muncul di tabel  

2. **Lihat Data (Read)**  
   - Semua data pada tabel `menu_kafe` langsung ditampilkan di `JTable` ketika aplikasi dibuka  

3. **Ubah Data (Update)**  
   - Klik salah satu baris di tabel  
   - Data akan muncul di form input  
   - Tombol “Add” berubah menjadi **“Update”**  
   - Setelah diubah dan disimpan, tabel langsung diperbarui  

4. **Hapus Data (Delete)**  
   - Pilih data dari tabel, tekan **Delete**  
   - Muncul dialog konfirmasi penghapusan  
   - Jika menekan “Yes”, data akan dihapus  

5. **Bersihkan Form (Cancel)**  
   - Tombol **Cancel** berfungsi untuk mengosongkan form input dan mengembalikan tombol ke kondisi semula  

Setiap aksi disertai **popup notifikasi (JOptionPane)** agar pengguna mendapat umpan balik visual secara langsung.

---

## 📸 Dokumentasi Program (CRUD)
Berikut hasil tampilan saat program dijalankan:
https://youtu.be/A_M55YiMFQI
