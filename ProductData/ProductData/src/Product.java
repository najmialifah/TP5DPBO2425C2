public class Product {
    // Menambahkan atribut untuk menyimpan data produk
    private String id;        // Menyimpan kode atau ID produk
    private String nama;      // Menyimpan nama produk
    private double harga;     // Menyimpan harga produk
    private String kategori;  // Menyimpan kategori produk (misalnya: Minuman, Makanan, Dessert)
    private String merek;     // Menyimpan merek atau brand produk (atribut tambahan / bonus)

    // Membuat constructor lengkap dengan atribut merek
    // Constructor ini dipanggil saat membuat objek produk baru dengan semua informasi lengkap
    public Product(String id, String nama, double harga, String kategori, String merek) {
        this.id = id;
        this.nama = nama;
        this.harga = harga;
        this.kategori = kategori;
        this.merek = merek;
    }

    // Menambahkan constructor lama tanpa merek (opsional)
    // Tujuannya agar program lama tetap bisa berjalan walaupun belum menggunakan atribut merek
    public Product(String id, String nama, double harga, String kategori) {
        this(id, nama, harga, kategori, "-"); // Merek diisi "-" secara default
    }

    // Bagian berikut berisi metode setter
    // Setter digunakan untuk mengubah nilai atribut setelah objek dibuat

    public void setId(String id) {
        this.id = id; // Mengubah nilai ID produk
    }

    public void setNama(String nama) {
        this.nama = nama; // Mengubah nama produk
    }

    public void setHarga(double harga) {
        this.harga = harga; // Mengubah harga produk
    }

    public void setKategori(String kategori) {
        this.kategori = kategori; // Mengubah kategori produk
    }

    public void setMerek(String merek) {
        this.merek = merek; // Mengubah merek produk
    }

    // Bagian berikut berisi metode getter
    // Getter digunakan untuk mengambil nilai atribut dari objek

    public String getId() {
        return this.id; // Mengambil ID produk
    }

    public String getNama() {
        return this.nama; // Mengambil nama produk
    }

    public double getHarga() {
        return this.harga; // Mengambil harga produk
    }

    public String getKategori() {
        return this.kategori; // Mengambil kategori produk
    }

    public String getMerek() {
        return this.merek; // Mengambil merek produk
    }
}