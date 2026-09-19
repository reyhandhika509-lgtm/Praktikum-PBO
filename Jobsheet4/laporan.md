# laporan Praktikum Pemograman Berbasis Objek 4

<h4>Nama    : Reyhandhika Zikri Prijadi<h4>
<h4>Nim     : 254107020219<h4>
<h4>Kelas   : TI-2G<h4>

## Percobaan 1: Aggregation Satu-ke-Satu (Laptop dan Processor)

### Code Processor.java
```bash
package Jobsheet4.id.ac.polinema.relasiclass.percobaan1;

public class Processor{
    private  String merk;
    private  double cache;

    public Processor (){

    }
    public Processor(String merk, double cache){
        this.merk = merk;
        this.cache = cache;
    }
    public void  setMerk(String merk){
        this.merk = merk;
    }
    public void setCache(double cache){
        this.cache = cache;
    }
    public void info(){
        System.out.printf("Merk Processor = %s\n", merk);
        System.out.printf("Cache Memory = %.2f\n", cache);
    }
}
```
### Code Laptop.java
```bash
package Jobsheet4.id.ac.polinema.relasiclass.percobaan1;

public class Laptop {
    private String merk;
    private Processor proc;
    
    public Laptop(){
    }

    public Laptop(String merk, Processor proc){
        this.merk = merk;
        this.proc = proc;
    }
    public void setMerk(String merk){
        this.merk = merk;
    }
    public String getMerk() {
        return merk;
    }
    public void setProc(Processor proc){
        this.proc = proc;
    }
    public  Processor getProc(){
        return proc;
    }
    public void info(){
        System.out.println("Merk Laptop = " + merk);
        proc.info();
    }
}
```
### Code MainPercobaan1.java
```bash
package Jobsheet4.id.ac.polinema.relasiclass.percobaan1;

public class MainPercobaan1 {
    public static void main(String[] args) {
        Processor p = new Processor("Intel i5", 3);
        Laptop l = new Laptop("Thinkpad",p);
        l.info();

        Processor p1 = new Processor();
        p1.setMerk("Intel i5");
        p1.setCache(4);
        Laptop l1 = new Laptop();
        l1.setMerk("Thinkpad");
        l1.setProc(p1);
        l1.info();

        Laptop l2 = new Laptop("Thinkpad", new Processor("Intel i5",3));
        l2.info();
    }
}
```
### Output:
![alt text](<image/Percobaan 1.png>)

## Pertanyaan Percobaan 1
### 1. Di dalam class Processor dan class Laptop, terdapat method setter dan getter untuk masingmasing atributnya. Apakah gunanya method setter dan getter tersebut?
```
Jawaban: 
Setter berfungsi untuk mengisi atau mengubah nilai atribut private dari luar class. 

getter  berfungsi untuk mengambil atau membaca nilai atribut private tersebut.
```
### 2. Di dalam class Processor dan class Laptop, masing-masing terdapat konstruktor default dan konstruktor berparameter. Bagaimanakah beda penggunaan dari kedua jenis konstruktor tersebut?
```
Jawaban:  
Konstruktor default digunakan untuk membuat objek tanpa langsung memberi nilai atribut (nilai diisi belakangan melalui setter). Konstruktor berparameter digunakan untuk membuat objek sekaligus langsung mengisikan nilai awal atributnya saat instansiasi.
```
### 3. Perhatikan class Laptop, di antara 2 atribut yang dimiliki (merk dan proc), atribut manakah yang bertipe object? Baris kode manakah yang menunjukkan bahwa class Laptop memiliki relasi dengan class Processor?
```
Jawaban:  
Atribut bertipe object pada class Laptop adalah proc (bertipe Processor). Baris kode yang menunjukkan relasi tersebut adalah private Processor proc;
```
### 4. Perhatikan pada class Laptop, apakah guna dari sintaks proc.info()?
```
Jawaban:  
Sintaks ini berfungsi sebagai delegasi, yaitu class Laptop menyuruh objek proc untuk memanggil method info() milik class Processor sendiri guna menampilkan detail prosesor.
```
### 5. Pada Langkah 8, objek p dibuat lebih dulu baru diberikan ke constructor Laptop. Pada Langkah 10, objek Processor dibuat langsung di dalam argumen constructor Laptop (tanpa variabel p). Apakah keduanya menghasilkan output yang berbeda? Mengapa?
```
Jawaban:  
Tidak menghasilkan output yang berbeda. Keduanya menghasilkan output yang sama karena pada Langkah 10 objek Processor tetap dibuat dan di-pass sebagai argumen ke constructor Laptop, bedanya hanya ditulis secara inline (anonymous object) tanpa disimpan di variabel acuan
```
### 6. Secara kode, apakah relasi Laptop-Processor pada percobaan ini termasuk Aggregation atau Composition? Tunjukkan baris kode yang menjadi bukti jawabanmu.
```
Jawaban:  
Berjenis Aggregation. Bukti kodenya adalah objek Processor diterima melalui parameter constructor/setter dari luar class Laptop (public Laptop(String merk, Processor proc) atau public void setProc(Processor proc)), bukan dibuat di dalam Laptop.
```
### 7. Andaikan constructor Laptop diubah menjadi seperti berikut, sehingga Processor dibuat sendiri di dalam Laptop, bukan diterima sebagai parameter:
```bash
public Laptop (String merk) {
 this.merk = merk;
 this.proc = new Processor ("Generic", 1);
}
```
### Apakah relasi Laptop-Processor pada versi ini masih Aggregation? Jelaskan alasannya (jawaban ini akan kita buktikan sendiri lewat kode pada Percobaan 5).
```
Jawaban:   
Tidak, relasi tersebut berubah menjadi Composition. Alasannya, instansiasi new Processor("Generic", 1) dilakukan langsung di dalam constructor class Laptop, sehingga siklus hidup Processor terikat penuh pada
```
## Percobaan 2: Aggregation dengan Relasi Ganda (Rental Mobil)
### Code mobil.java
```bash
package Jobsheet4.id.ac.polinema.relasiclass.percobaan2;

public class Mobil {
    private String merk;
    private int biaya;

    public Mobil(){
    }
    public void setMerk(String merk){
        this.merk =merk;
    }
    public String getMerk(){
        return merk;
    }
    public  void setBiaya(int biaya){
        this.biaya = biaya;
    }
    public int getBiaya(){
        return biaya;
    }
    public int hitungBiayaMobil(int hari){
        return biaya * hari;
    }
}

```
### Code Pelanggan.java
```bash
package Jobsheet4.id.ac.polinema.relasiclass.percobaan2;

public class Pelanggan {
    private String nama;
    private Mobil mobil;
    private Sopir sopir;
    private int hari;

    public Pelanggan(){
    }
    public void setNama(String nama){
        this.nama = nama;
    }
    public String getNama(){
        return nama;
    }
    public void setMobil(Mobil mobil){
        this.mobil = mobil;
    }
    public Mobil getMobil(){
        return mobil;
    }
    public void setSopir(Sopir sopir){
        this.sopir = sopir;
    }
    public Sopir getSopir(){
        return sopir;
    }
    public void setHari(int hari){
        this.hari = hari;
    }
    public int getHari(){
        return hari;
    }
    public int hitungBiayaTotal(){
    return mobil.hitungBiayaMobil(hari) + sopir.hitungBiayaSopir(hari);
    }
}
```
### Code Sopir.java
```bash
package Jobsheet4.id.ac.polinema.relasiclass.percobaan2;

public class Sopir {
    private String nama;
    private int biaya;

    public Sopir(){
    }
    public void setNama(String nama){
        this.nama =nama;
    }
    public String getNama(){
        return nama;
    }
    public void setBiaya(int biaya){
        this.biaya = biaya;
    }
    public int getBiaya(){
        return biaya;
    }
    public int hitungBiayaSopir(int hari){
        return biaya * hari;
    }
}

```
### Output:
![alt text](<image/Percobaan 2.png>)


## Pertanyaan Percobaan 2
### 1. Perhatikan class Pelanggan. Pada baris program manakah yang menunjukkan bahwa class Pelanggan memiliki relasi dengan class Mobil dan class Sopir?
```
Jawaban:  
Baris private Mobil mobil; dan private Sopir sopir;
```
### 2. Perhatikan method hitungBiayaSopir pada class Sopir, serta method hitungBiayaMobil pada class Mobil. Mengapa method tersebut harus memiliki argument hari, padahal hari sendiri adalah atribut milik Pelanggan, bukan milik Mobil atau Sopir?
```
Jawaban:  
Karena atribut hari (durasi sewa) berada pada class Pelanggan, bukan milik class Mobil maupun Sopir. Oleh karena itu, nilai hari harus dikirimkan lewat parameter agar biaya per hari bisa dikalikan dengan lama sewa.
```
### 3. Perhatikan kode dari class Pelanggan. Untuk apakah perintah mobil.hitungBiayaMobil(hari) dan sopir.hitungBiayaSopir(hari)?
```
Jawaban:
Untuk memanggil dan menyerahkan perhitungan biaya sewa mobil serta biaya sopir ke objeknya masing-masing berdasarkan jumlah hari sewa.
```
### 4. Perhatikan class MainPercobaan2. Untuk apakah sintaks p.setMobil(m) dan p.setSopir(s)?
```
Jawaban:
Untuk memasukkan (meng-inject) referensi objek m (Mobil) dan s (Sopir) ke dalam atribut mobil dan sopir pada objek p (Pelanggan).
```
### 5. Untuk apakah proses p.hitungBiayaTotal()?
```
Jawaban:
Menghitung total biaya keseluruhan yang harus dibayar pelanggan dengan mengembalikan penjumlahan dari biaya mobil dan biaya sopir.
```
### 6. Pada Langkah 7, p.getMobil().getMerk() memanggil dua method sekaligus secara berantai. Jelaskan urutan eksekusinya: objek apa yang dikembalikan p.getMobil(), dan objek apa yang kemudian dipanggil .getMerk()-nya?

Jawaban:
- p.getMobil() dieksekusi terlebih dahulu dan mengembalikan objek Mobil yang terhubung dengan pelanggan p.  

- Method .getMerk() kemudian dipanggil pada objek Mobil yang dikembalikan tersebut untuk mengambil nama merknya.

### 7. Andaikan p.setMobil(m) tidak pernah dipanggil lalu p.hitungBiayaTotal() dijalankan, error apa yang akan muncul? Jelaskan mengapa error itu terjadi, dikaitkan dengan konsep referensi objek yang sudah kita pelajari sebelumnya. 
```
Jawaban:
Akan terjadi error NullPointerException. Penyebabnya karena atribut mobil pada Pelanggan masih bernilai null (belum menunjuk ke objek mana pun di memori), sehingga program menolak saat dipanggil method mobil.hitungBiayaMobil(hari)
```

## Percobaan 3: Aggregation dengan Dua Role ke Kelas yang Sama (Kereta Api)

### Code Pegawai.java
```bash
package Jobsheet4.id.ac.polinema.relasiclass.percobaan3;

public class Pegawai {
    private  String nip;
    private String nama;
    
    public Pegawai(String nip, String nama){
        this.nip = nip;
        this. nama = nama;
    }
    public void setNip(String nip){
        this.nip = nip;
    }
    public String getNip(){
        return  nip;
    }
    public void setNama(String nama){
        this.nama = nama;
    }
    public String getNama(){
        return nama;
    }
    public String info(){
        String info = "";
        info += "Nip: " + this.nip + "\n";
        info += "Nama: " + this.nama + "\n";
        return info;
    }
}

```
### KeretaApi.java
```bash
package Jobsheet4.id.ac.polinema.relasiclass.percobaan3;

public class KeretaApi {
    private String nama;
    private String kelas;
    private Pegawai masinis;
    private Pegawai asisten;
    
    public KeretaApi(String nama, String kelas, Pegawai masinis){
        this.nama = nama;
        this.kelas = kelas;
        this.masinis = masinis;
    }
    public KeretaApi ( String nama, String kelas, Pegawai masinis, Pegawai asisten){
        this.nama = nama;
        this.kelas = kelas;
        this.masinis = masinis;
        this.asisten = asisten;
    }
    public void setMasinis(Pegawai masinis){
        this.masinis = masinis;
    }
    public  Pegawai getMasinis(){
        return masinis;
    }
    public void setAsisten(Pegawai asisten){
        this.asisten = asisten;
    }
    public Pegawai getAsisten(){
        return asisten;
    }
    public String info(){
        String info = "";
        info += "Nama: " + this.nama + "\n";
        info += "Kelas: " + this.kelas + "\n";
        info += "Masinis: " + this.masinis.info() + "\n";
        if (this.asisten != null) {
            info += "Asisten: " + this.asisten.info() + "\n";
        }
        return info;
    }
}
```
### Code MainPercobaan3.java
```bash
package Jobsheet4.id.ac.polinema.relasiclass.percobaan3;

public class MainPercobaan3 {
    public static void main(String[] args) {
    
    Pegawai masinis = new Pegawai("1234", "Spongebob Squarepants");
    Pegawai asisten = new Pegawai("4567", "Patrick Star");
    KeretaApi keretaApi = new KeretaApi("Gaya Baru", "Bisnis", masinis, asisten);
    System.out.println(keretaApi.info());
    
    }
}

```
### Output:
![alt text](<image/Percobaan 3.png>)
### Code MainPertanyaan.java
```bash
package Jobsheet4.id.ac.polinema.relasiclass.percobaan3;

public class MainPertanyaan {
    public static void main(String[] args) {
        Pegawai masinis = new Pegawai("1234", "Spongebob Squarepants");
        KeretaApi keretaApi = new KeretaApi("Gaya Baru", "Bisnis", masinis);
        System.out.println(keretaApi.info());
    }
    
}

```
### Output: 
![alt text](<image/Percobaan 3.png>)

## Pertanyaan Percobaan 3
### 1. Di dalam method info() pada class KeretaApi, baris this.masinis.info() dan this.asisten.info() digunakan untuk apa?
```
Jawaban:
Untuk memanggil method info() dari class Pegawai guna mengambil data teks identitas milik masinis dan asisten.
```
### 2. Apa hasil output dari MainPertanyaan sebelum diperbaiki (Langkah 8)? Mengapa hal tersebut dapat terjadi?
```
Jawaban:
Program berhenti dan menghasilkan error NullPointerException. Terjadi karena constructor 3-parameter tidak mengisi atribut asisten (sehingga nilainya null), lalu method this.asisten.info() tetap dipanggil.
```
### 3. Kaitkan dengan materi referensi objek: apa isi variabel asisten di dalam objek KeretaApi yang dibuat lewat constructor 3-parameter, sebelum guard clause ditambahkan?
```
Jawaban:
Bernilai null (kosong / belum merujuk ke objek Pegawai mana pun).
```
### 4. Setelah guard clause ditambahkan (Langkah 9), apakah objek masinis juga perlu dicek dengan cara yang sama? Perhatikan kedua constructor KeretaApi, apakah mungkin masinis bernilai null? Jelaskan.
```
Jawaban:
Tidak perlu. Karena pada kedua constructor KeretaApi, parameter masinis wajib diisi saat pembuatan objek, sehingga atribut masinis dipastikan tidak akan pernah bernilai
```
### 5. Kelas Pegawai dipakai lewat dua atribut berbeda (masinis dan asisten) pada KeretaApi. Apakah ini membuat KeretaApi punya dua objek Pegawai yang berbeda, atau satu objek Pegawai yang dipakai dua kali? Jelaskan berdasarkan kode pada Langkah 6. 
```
Jawaban:
Membuat dua objek Pegawai yang berbeda. Buktinya pada Langkah 6 dilakukan dua kali pembuatan objek baru (new Pegawai(...)) secara terpisah untuk variabel masinis dan asisten.
```
## Percobaan 4: Array of Object dan Multiplicity (Gerbong, Kursi, dan Penumpang)
### Code Penumpang.java
```bash
package Jobsheet4.id.ac.polinema.relasiclass.percobaan4;

public class Penumpang {
    private String ktp;
    private String nama;

    public Penumpang(String ktp, String nama) {
        this.ktp = ktp;
        this.nama = nama;
     }

    public String getKtp() {
    return ktp;
    }

    public String getNama() {
    return nama;
    }

    public String info() {
    String info = "";
    info += "Ktp: " + ktp + "\n";
    info += "Nama: " + nama + "\n";
    return info;

    }

}
```
### Code Kursi.java
```bash
package Jobsheet4.id.ac.polinema.relasiclass.percobaan4;

public class Kursi {
    private String nomor;
    private Penumpang penumpang;

    public Kursi(String nomor) {
     this.nomor = nomor;
     }

     public void setPenumpang(Penumpang penumpang) {
     this.penumpang = penumpang;
     }

     public Penumpang getPenumpang() {
     return penumpang;
     }

     public String info() {
     String info = "";
     info += "Nomor: " + nomor + "\n";
     if (this.penumpang != null) {
     info += "Penumpang: " + penumpang.info() + "\n";
     }
    return info;
     }
}

```
### Code Gerbong.java
```bash
package Jobsheet4.id.ac.polinema.relasiclass.percobaan4;

public class Gerbong {
    private String kode;
    private Kursi[] arrayKursi;

    public Gerbong(String kode, int jumlah) {
     this.kode = kode;
     this.arrayKursi = new Kursi[jumlah];
     this.initKursi();
     }

     private void initKursi() {
     for (int i = 0; i < arrayKursi.length; i++) {
     this.arrayKursi[i] = new Kursi(String.valueOf(i + 1));
     }
    
    }
    public void setPenumpang(Penumpang penumpang, int nomor) {
     this.arrayKursi[nomor - 1].setPenumpang(penumpang);
    }

    public String info() {
     String info = "";
     info += "Kode: " + kode + "\n";
     for (Kursi kursi : arrayKursi) {
     info += kursi.info();
     }
     return info;
    }
}

```
### Code MainPercobaan
```bash
package Jobsheet4.id.ac.polinema.relasiclass.percobaan4;

public class MainPercobaan4 {
    public static void main(String[] args) {
        Penumpang p = new Penumpang("12345", "Mr. Krab");
        Gerbong gerbong = new Gerbong("A", 10);
        gerbong.setPenumpang(p, 1);
        System.out.println(gerbong.info());
    }
}

```
### Output:
![alt text](<image/Percobaan 4.png>)
## Pertanyaan Percobaan 4
### 1. Pada main program dalam class MainPercobaan4, berapakah jumlah kursi dalam Gerbong A?
```
Jawaban:
Terdapat 10 kursi (sesuai penentuan kapasitas new Gerbong("A", 10))
```
### 2. Perhatikan potongan kode if (this.penumpang != null) { ... } pada method info() dalam class Kursi. Apa maksud kode tersebut?
```
Jawaban:
Berfungsi sebagai guard clause untuk mengecek apakah kursi tersebut diisi penumpang. Jika ada isinya (!= null), info penumpang dicetak; jika kosong, info penumpang dilewati agar tidak terjadi NullPointerException.
```
### 3. Mengapa pada method setPenumpang() dalam class Gerbong, nilai nomor dikurangi dengan angka1?
```
Jawaban: 
Karena nomor kursi manusia dimulai dari angka 1, sedangkan indeks array pada Java dimulai dari indeks 0 (sehingga kursi nomor 1 menempati array indeks 0).
```
### 4. Instansiasi objek baru budi dengan tipe Penumpang, kemudian masukkan objek baru tersebut pada gerbong dengan gerbong.setPenumpang(budi, 1), menimpa Mr. Krab yang sudah duduk disana. Apakah yang terjadi? Apakah Java memberi peringatan/error?
```
Jawaban:
Objek budi akan langsung menggantikan objek Mr. Krab pada kursi nomor 1. Java tidak mengeluarkan peringatan/error karena variabel acuan penumpang pada objek Kursi langsung tertimpa
```
### 5. Modifikasi program sehingga tidak diperkenankan menduduki kursi yang sudah ada penumpang lain(tambahkan pengecekan pada Gerbong.setPenumpang() sebelum baris arrayKursi[nomor -1].setPenumpang(...) dijalankan).
```
Jawaban: 
public void setPenumpang(Penumpang penumpang, int nomor) {
    if (this.arrayKursi[nomor - 1].getPenumpang() == null) {
        this.arrayKursi[nomor - 1].setPenumpang(penumpang);
    } else {
        System.out.println("Kursi nomor " + nomor + " sudah terisi!");
    }
}
```
### 6. Bandingkan tiga bentuk relasi has-a yang sudah kita praktikkan: Laptop-Processor (Percobaan 1, 1-1), KeretaApi-Pegawai (Percobaan 3, dua relasi 1-1 bernama), dan Gerbong-Kursi (Percobaan 4, 1..*). Untuk kasus seperti apa kita akan memilih array, dan untuk kasus seperti apa kita akan memilih atribut bernama satu-satu?
```
Jawaban:
- Atribut bernama satu-satu: Dipakai ketika jumlah objek bagian (part) sudah pasti/tetap dan masing-masing objek memiliki peran (role) spesifik yang berbeda dan unik (contoh: masinis dan asisten pada class KeretaApi, atau proc pada class Laptop).   

- Array: Dipakai ketika jumlah objek bagian bersifat banyak, dinamis, atau berupa kumpulan dengan peran yang seragam tanpa perlu membedakan nama khusus tiap objeknya (contoh: kumpulan arrayKursi pada Gerbong).
```

### 7. Terapkan kriteria kode (siapa yang memanggil new) pada dua relasi has-a di Percobaan ini: GerbongKursi dan Kursi-Penumpang. Manakah yang Aggregation dan manakah yang Composition? Tunjukkan baris kode yang menjadi bukti untuk masing-masing.
```
Jawaban:
1. Gerbong – Kursi (Composition):  
- Alasan: Objek Kursi diinstansiasi (new) secara internal di dalam class Gerbong sendiri melalui method initKursi(), sehingga keberadaan Kursi terikat penuh pada Gerbong.   

- Bukti Kode: this.arrayKursi[i] = new Kursi(String.valueOf(i + 1)); (di dalam class Gerbong).  

2. Kursi – Penumpang (Aggregation):
- Alasan: Objek Penumpang tidak dibuat di dalam class Kursi, melainkan dibuat di luar (MainPercobaan4) lalu dimasukkan ke Kursi melalui setter.   
- Bukti Kode: Penumpang p = new Penumpang("12345", "Mr. Krab"); (dibuat di MainPercobaan4) dan this.penumpang = penumpang; (pada method setPenumpang di class Kursi). 
```
## Percobaan 5: Composition (Mobil dan Mesin)
### Code Mesin.java
```bash
package Jobsheet4.id.ac.polinema.relasiclass.percobaan5;

public class Mesin {
    private String tipe;

    public Mesin(){
        this.tipe = "4-silinder";
    }

    public String getTipe(){
        return tipe;
    }
    
}

```
### Code Mobil.java
```bash
package Jobsheet4.id.ac.polinema.relasiclass.percobaan5;

public class Mobil {
       private String merek;
    private Mesin mesin;

    public Mobil(String merek){
        this.merek = merek;
        this.mesin = new Mesin();
    }

    public void tampilkanInfo(){
        System.out.println("Mobil: " + merek);
        System.out.println("Mesin : " + mesin.getTipe());
    }
}

```
### Code MainPercobaan4.java
```bash
package Jobsheet4.id.ac.polinema.relasiclass.percobaan5;

public class MainPercobaan5 {
    public static void main(String[] args) {
         Mobil mobil = new Mobil("Avanza");
        mobil.tampilkanInfo();
    }
    
}

```
### Output:
![alt text](<image/Percobaan 5.png>)

## Percobaan 6: Dependency / Uses-A (Laptop Mencetak Dokumen ke Printer)

### Code Printer.java
```bash
package Jobsheet4.id.ac.polinema.relasiclass.percobaan6;

public class Printer {
    private String merek;

    public Printer(String merek){
        this.merek = merek;
    }

    public void cetak(String namaFile){
        System.out.println("[" + merek + "] Mencetak " + namaFile + "...");
        System.out.println("[" + merek + "] Selesai.");
    }
}

```
### Code Laptop.java
```bash
package Jobsheet4.id.ac.polinema.relasiclass.percobaan6;

public class Laptop {
    private String merek;

    public Laptop(String merek){
        this.merek = merek;
    }

    public void cetakDokumen(Printer printer, String namaFile){
        System.out.println(merek + " mengirim dokumen ke printer...");
        printer.cetak(namaFile);
    }
}

```
### Code MainPercobaan4.java
```bash
package Jobsheet4.id.ac.polinema.relasiclass.percobaan6;

public class MainPercobaan6 {
     public static void main(String[] args) {
        Laptop laptop = new Laptop("Thinkpad");
        Printer printer = new Printer("Epson L3110");
        laptop.cetakDokumen(printer, "Laporan.pdf");
    }
}

```
### Output :
![alt text](<image/Percobaan 6.png>)

## Pertanyaan Percobaan 6
### 1. Apakah class Laptop pada percobaan ini memiliki atribut bertipe Printer? Bandingkan dengan Percobaan 1, di mana Processor disimpan sebagai atribut Laptop.
```
Jawaban:
Tidak ada. Pada Percobaan 6, Printer hanya muncul sebagai parameter pada method cetakDokumen(...) dan tidak disimpan sebagai atribut kelas seperti Processor pada Percobaan 1.
```
### 2. Setelah method cetakDokumen() selesai dijalankan, apakah Laptop masih menyimpan referensi ke objek printer yang tadi dipakai? Jelaskan berdasarkan baris kode class Laptop.
```
Jawaban:
Tidak. Parameter printer hanya aktif selama method cetakDokumen() dieksekusi. Tidak ada baris kode seperti this.printer = printer; yang menyimpan referensi tersebut ke atribut kelas Laptop.
```

### 3. Mengapa relasi Laptop-Printer pada percobaan ini disebut Dependency (uses-a), bukan Aggregation, meskipun sama-sama melibatkan dua objek yang saling berinteraksi?
```
Jawaban:
Karena Laptop tidak menyimpan objek Printer sebagai atribut kelas (tidak ada relasi kepemilikan has-a), melainkan hanya meminjam/menggunakan objek Printer sesaat saat method dipanggil.
```
### 4. Coba ubah kode Laptop supaya Printer disimpan sebagai atribut (mis. private Printer printerDefault, diisi lewat constructor atau setter, lalu dipakai kembali di cetakDokumen() tanpa parameter Printer). Apakah relasi ini sekarang berubah dari Dependency menjadi Aggregation? Jelaskan.
```
Jawaban:
Ya, relasi berubah menjadi Aggregation karena Laptop kini menyimpan dan memiliki acuan objek Printer pada atribut kelasnya.
```
### 5. Lengkapi tabel berikut dengan kata-katamu sendiri (boleh dijawab di laporan): untuk masing-masing dari Aggregation, Composition, dan Dependency, sebutkan (a) apakah objek part disimpan sebagai atribut atau tidak, dan (b) siapa yang memanggil new untuk membuat objek part tersebut. 
```
Jawaban:
- Aggregation: (a) Ya, disimpan sebagai atribut. (b) Dipanggil oleh kode di luar class whole (misal: Main/Caller).   

- Composition: (a) Ya, disimpan sebagai atribut. (b) Dipanggil oleh internal class whole sendiri.  

- Dependency: (a) Tidak disimpan sebagai atribut. (b) Dipanggil oleh kode di luar class (Main/Caller) yang mengirimkan objeknya saat pemanggilan method.   
```

### Code Rak.java
package Jobsheet4.TugasMandiri;

public class Rak {
    private String kodeRak;

    public Rak(String kodeRak) {
        this.kodeRak = kodeRak;
    }

    public String getKodeRak() {
        return kodeRak;
    }

    public void info() {
        System.out.println("Rak: " + kodeRak);
    }
}
## Tugas mandiri:
### Code Buku.java
```bash
package Jobsheet4.TugasMandiri;

public class Buku {
    private String judul;
    private String penulis;

    public Buku(String judul, String penulis) {
        this.judul = judul;
        this.penulis = penulis;
    }

    public String getJudul() {
        return judul;
    }

    public String getPenulis() {
        return penulis;
    }

    public void info() {
        System.out.println("Judul  : " + judul);
        System.out.println("Penulis: " + penulis);
    }
}
```
### Code Perpustakaan.java
```bash
package Jobsheet4.TugasMandiri;

public class Perpustakaan {
    private String nama;

    // COMPOSITION
    // Rak dibuat langsung oleh Perpustakaan
    private Rak rak;

    // AGGREGATION
    // Buku diberikan dari luar
    private Buku buku;

    public Perpustakaan(String nama, Buku buku) {
        this.nama = nama;
        this.buku = buku;

        // Composition
        this.rak = new Rak("R01");
    }

    public void info() {
        System.out.println("=== PERPUSTAKAAN ===");
        System.out.println("Nama: " + nama);

        System.out.println("\nData Rak:");
        rak.info();

        System.out.println("\nData Buku:");
        buku.info();
    }
    
}
```
### Code Anggota.java
```bash
package Jobsheet4.TugasMandiri;

public class Anggota {
     private String nama;

    public Anggota(String nama) {
        this.nama = nama;
    }
    // DEPENDENCY
    // Buku hanya digunakan sebagai parameter method
    // dan tidak disimpan sebagai atribut
    public void pinjamBuku(Buku buku) {
        System.out.println("\n=== PEMINJAMAN ===");
        System.out.println(nama + " meminjam buku:");
        System.out.println("Judul: " + buku.getJudul());
    }
}
```
## Jawab Pertanyaan
### 1. Rancang satu studi kasus sendiri (bebas topiknya, misalnya perpustakaan, klinik, toko online, dsb.), gambarkan diagram kelasnya, lalu implementasikan ke dalam program. Studi kasus wajib melibatkan minimal 4 class (class yang berisi main tidak dihitung) dan wajib mencakup ketiganya: minimal satu relasi Aggregation, satu Composition, dan satu Dependency. Tandai pada laporanmu, bagian mana dari kode yang merupakan masing-masing jenis relasi tersebut, dan sertakan alasannya.

Jawaban:
- Composition (Perpustakaan - Rak)

Bagian Kode: Di class Perpustakaan.java, baris private Rak rak; dan this.rak = new Rak("R01"); di dalam constructor Perpustakaan.

Alasan: Objek Rak dibuat langsung di dalam constructor class Perpustakaan menggunakan perintah new Rak("R01") tanpa menerima objek dari luar. Siklus hidup Rak terikat sepenuhnya dengan Perpustakaan (jika objek Perpustakaan dihapus/dihancurkan, maka objek Rak ikut hancur).

- Aggregation (Perpustakaan - Buku)

Bagian Kode: Di class Perpustakaan.java, baris private Buku buku; dan parameter Buku buku pada constructor public Perpustakaan(String nama, Buku buku) yang diisikan lewat this.buku = buku;.

Alasan: Objek Buku diciptakan di luar class Perpustakaan lalu dimasukkan melalui parameter constructor. Objek Buku dapat berdiri sendiri; jika objek Perpustakaan dihapus, objek Buku tidak ikut hancur dan masih tetap ada di memori.

- Dependency (Anggota - Buku)

Bagian Kode: Di class Anggota.java, method public void pinjamBuku(Buku buku).

Alasan: Class Anggota tidak menyimpan Buku sebagai atribut kelas. Objek Buku hanya dipinjam/digunakan sementara (uses-a) sebagai parameter pada pemanggilan method pinjamBuku(), dan referensinya langsung terlepas setelah method selesai berjalan.


### 2. Jawab singkat (3-5 kalimat): dalam merancang sistem barumu sendiri, bagaimana kita memutuskan sebuah relasi antar class seharusnya Aggregation, Composition, atau Dependency? Sebutkan pertanyaan kunci yang kita ajukan ke diri sendiri saat memutuskan.

Jawaban:
1. Apakah objek ini perlu disimpan sebagai atribut kelas, atau hanya dipinjam sesaat saat method tertentu dipanggil? (Jika hanya dipinjam sesaat lewat parameter, maka relasinya Dependency).

2. Jika disimpan sebagai atribut, apakah objek ini diciptakan secara internal di dalam class utama? (Jika dibuat sendiri pakai new di dalam kelas dan hancur bersama class utama, maka relasinya Composition).

3. Apakah objek ini dibuat di luar class utama dan bisa tetap hidup meskipun class utama dihapus? (Jika ya dan dimasukkan via constructor/setter, maka relasinya Aggregation).
