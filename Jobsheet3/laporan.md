# laporan Praktikum Pemograman Berbasis Objek 2

<h4>Nama    : Reyhandhika Zikri Prijadi<h4>
<h4>Nim     : 254107020219<h4>
<h4>Kelas   : TI-2G<h4>

## 2.1 Enkapsulasi
Pada modul pertama telah dijabarkan definisi dari enkapsulasi sebagai berikut:
Enkapsulasi disebut juga dengan information-hiding. Dalam berinteraksi dengan objek, seringkali kita
tidak perlu mengetahui kompleksitas yang ada didalamnya. Hal ini akan lebih mudah dipahami jika
kita membayangkan atau menganalisa objek yang ada disekitar kita, misalnya objek sepeda, ketika
kita mengganti gear pada sepeda, kita tinggal menekan tuas gear yang ada di grip setang sepeda saja.
Kita tidak perlu mengetahui bagaimana cara gear berpindah secara teknis. Contoh objek lain misalnya
mesin penghisap debu (vacuum cleaner), ketika kita mencolokkan kabel vacum cleaner dan
menyalakan saklarnya maka mesin tersebut siap digunakan untuk menghisap debu. Dalam proses
tersebut kita tidak mengetahui proses rumit yang terjadi ketika mengubah listrik menjadi tenaga dari
vacuum cleaner. Dalam contoh diatas vacum cleaner dan sepeda telah menerapkan enkapsulasi atau
disebut juga information-hiding atau data hiding karena menyembunyikan detail proses suatu objek
dari pengguna

## 2.2 Konstruktor
Konstruktor mirip dengan method cara deklarasinya akan tetapi tidak memiliki tipe return. Dan
konstruktor dieksekusi ketika instan dari objek dibuat. Jadi setiap kali sebuah objek dibuat dengan
keyword new() maka konstruktor akan dieksekusi. Cara untuk membuat konstruktor adalah sebagai
berikut:
1. Nama konstruktor harus sama dengan nama class
2. Konstruktor tidak memiliki tipe data return
3. Konstruktor tidak boleh menggunakan modifier abstract, static, final, dan synchronized

Secara umum, konstruktor dideklarasikan dengan modifier `public` untuk menjamin bahwa kelas
tersebut dapat diinstansiasi secara bebas oleh kelas driver atau komponen eksternal lain di dalam
sistem. Namun, dalam arsitektur pemrograman berorientasi objek tingkat lanjut, penggunaan
modifier lain diizinkan untuk memenuhi kebutuhan desain spesifik:
1. Private Constructor: Digunakan untuk menutup total akses instansiasi dari luar kelas. Pola ini
umumnya diterapkan pada implementasi Singleton Pattern (memastikan hanya ada satu
objek yang hidup di memori) atau pada Utility Class yang hanya berisi sekumpulan method
statis (seperti kelas `Math` bawaan Java), sehingga pembuatan objek kelas tersebut menjadi
tidak relevan.
2. Default/Protected Constructor: Digunakan ketika instansiasi objek ingin dibatasi hanya untuk
kelas-kelas dalam satu package yang sama, atau hanya boleh diinisialisasi oleh kelas
turunannya (subclass) dalam koridor pewarisan (inheritance).

## 2.3 Akses Modifier
Terdapat 2 tipe modifier di java yaitu : akses modifier dan non-access modifier. Dalam hal ini kita akan
fokus pada akses modifier yang berguna untuk mengatur akses method, class, dan constructor.
Terdapat 4 akses modifier yaitu:
1. private – hanya dapat diakses di dalam kelas yang sama
2. default – hanya dapat diakses di dalam package yang sama
3. protected – dapat diakses di luar package menggunakan subclass (membuat inheritance)
4. public – dapat diakses dari mana saja

## 2.4 Getter dan Setter
Getter adalah public method dan memiliki tipe data return, yang berfungsi untuk mendapatkan nilai
dari atribut private. Sedangkan setter adalah public method yang tidak memiliki tipe data return, yang
berfungsi untuk memanipulasi nilai dari atribut private

## 3.1 Percobaan 1 - Enkapsulasi
### Code Motor.java
```bash
package Jobsheet3.MotorEncapsulation;

public class motor {
    public  int kecepatan = 0;
    public  boolean kontakOn = false;

    public void kurangiKecepatan(){
        if (kontakOn == true){
            kecepatan -= 5;
        } 
        else{
            System.out.println("Kecepatan Tidak Bisa berkurang karena Mesin OFF! \n");
        }
    }

    public void printStatus(){
        if (kontakOn == true){
            System.out.println("Kontak On");
        } 
        else{
            System.out.println("Kontak OFF");
        }
        System.out.println("Kecepatan " + kecepatan+"\n");
    }
    
}

```
### Code MotorDemo.java
```bash
package Jobsheet3.MotorEncapsulation;

public class motorDemo {
    public static void main(String[] args) {
        motor motor = new motor();
        motor.printStatus();
        motor.kecepatan = 50;
        motor.printStatus();
    }
```
### Hasil
![alt text](<image/percobaan 1.png>)
## 3.2 Percobaan 2 - Access Modifier
Pada percobaan ini akan digunakan access modifier untuk memperbaiki cara kerja class Motor pada
percobaan ke-1

### Code Motor.java
```bash
package Jobsheet3.MotorEncapsulation;

public class motor {
    private  int kecepatan = 0;
    private  boolean kontakOn = false;

    public void nyalakanMesin(){
        kontakOn = true;
    }
    public void matikanMesin(){
        kontakOn = false;
        kecepatan = 0;
    }
    public  void tambahKecepatan(){
        if (kontakOn == true){
            kecepatan += 5;
        } 
        else{
            System.out.println("Kecepatan tidak bisa bertambah karena Mesin OFF! \n");
        }
    }
    public void kurangiKecepatan(){
        if (kontakOn == true){
            kecepatan -= 5;
        } 
        else{
            System.out.println("Kecepatan Tidak Bisa berkurang karena Mesin OFF! \n");
        }
    }

    public void printStatus(){
        if (kontakOn == true){
            System.out.println("Kontak On");
        } 
        else{
            System.out.println("Kontak OFF");
        }
        System.out.println("Kecepatan " + kecepatan+"\n");
    }
    
}


```

### Code MotorDemo.java
```bash
package Jobsheet3.MotorEncapsulation;

public class motorDemo {
    public static void main(String[] args) {
        motor motor = new motor();
        motor.printStatus();
        motor.tambahKecepatan(); 

        motor.nyalakanMesin();
        motor.printStatus();

        motor.tambahKecepatan();
        motor.printStatus();

        motor.tambahKecepatan();
        motor.printStatus();

        motor.tambahKecepatan();
        motor.printStatus();

        motor.matikanMesin();
        motor.printStatus();
    }
    
}

```
### Hasil
![alt text](<image/percobaan 2.png>)

## 3.3 Pertanyaan
### 1. Pada class TestMobil, saat kita menambah kecepatan untuk pertama kalinya, mengapa muncul peringatan “Kecepatan tidak bisa bertambah karena Mesin Off!”?

Karena kondisi mesin atau kontak masih dalam keadaan OFF. Method untuk menambah kecepatan hanya dapat bekerja apabila mesin sudah dinyalakan. Hal ini merupakan penerapan enkapsulasi agar perubahan kecepatan tidak dapat dilakukan secara sembarangan.

### 2. Mengapa atribut kecepatan dan kontakOn diset private?
Atribut kecepatan dan kontakOn diset sebagai private agar tidak dapat diakses atau diubah secara langsung dari luar class. Perubahan nilai atribut harus dilakukan melalui method yang telah disediakan sehingga data dan kondisi objek dapat dikontrol dengan baik.

### 3. Ubah class Motor sehingga kecepatan maksimalnya adalah 100!
Kecepatan maksimal dapat dibatasi dengan menambahkan kondisi pada method tambahKecepatan(). Jika kecepatan sudah mencapai 100, maka kecepatan tidak dapat ditambahkan lagi.

## 3.4 Percobaan 3 - Getter dan Setter
Misalkan di sebuah sistem informasi koperasi, terdapat class Anggota. Anggota memiliki atribut nama, alamat dan simpanan, dan method setter, getter dan setor dan pinjam. Semua atribut pada anggota tidak boleh diubah sembarangan, melainkan hanya dapat diubah melalui method setter, getter, setor dan tarik. Khusus untuk atribut simpanan tidak terdapat setter karena simpanan akan bertambah ketika melakukan transaksi setor dan akan berkurang ketika melakukan peminjaman/tarik

### Code Anggota.java
``` bash
package Jobsheet3.KoperasiGetterSetter;

public class Anggota {
    private String nama;
    private String alamat;
    private float simpanan;     

    public void setNama(String nama){
        this.nama = nama;
    }

    public void setAlamat(String alamat){
        this.alamat = alamat;
    }

    public String getNama(){
        return nama;
    }

    public String getAlamat(){
        return alamat;
    }

    public float getSimpanan(){
        return simpanan;
    }

    public void setor(float uang){
        simpanan += uang;
    }

    public void pinjam(float uang){
        simpanan -= uang;
    }
}

```
### Code KoperasiDemo.java
``` bash
package Jobsheet3.KoperasiGetterSetter;

public class KoperasiDemo {
    public static void main(String[] args) {
        Anggota anggota1 = new Anggota();
        anggota1.setNama("Iwan Setiawan");
        anggota1.setAlamat("Jalan Sukarno Hatta no 10");
        anggota1.setor(100000);
        System.out.println("Simpanan " + anggota1.getNama() + " : Rp" + anggota1.getSimpanan());
        
        anggota1.pinjam(5000);
        System.out.println("Simpanan " + anggota1.getNama() + " : Rp" + anggota1.getSimpanan());
    }
}

```
### Hasil
![alt text](<image/percobaan 3.png>)

Dapat dilihat pada hasil percobaan diatas, untuk mengubah simpanan tidak dilakukan secara langsung
dengan mengubah atribut simpanan, melainkan melalui method setor() dan pinjam(). Untuk menampilkan nama pun harus melalui method getNama(), dan untuk menampilkan simpanan melalui getSimpanan(). 

## 3.5 Percobaan 4 - Konstruktor, Instansiasi 
### Code Anggota
```bash
package Jobsheet3.KoperasiGetterSetter;

public class Anggota {
    private String nama;
    private String alamat;
    private float simpanan;

    Anggota(String nama, String alamat){
        this.nama = nama;
        this.alamat = alamat;
        this.simpanan = 0;
    }

    public void setNama(String nama){
        this.nama = nama;
    }

    public void setAlamat(String alamat){
        this.alamat = alamat;
    }

    public String getNama(){
        return nama;
    }

    public String getAlamat(){
        return alamat;
    }

    public float getSimpanan(){
        return simpanan;
    }

    public void setor(float uang){
        simpanan += uang;
    }

    public void pinjam(float uang){
        simpanan -= uang;
    }
}

```
### Code KoperasiDemo
```bash
package Jobsheet3.KoperasiGetterSetter;

public class KoperasiDemo {
    public static void main(String[] args) {
        Anggota anggota1 = new Anggota("Iwan","Jalan Mawar");
        System.out.println("Simpanan " +anggota1.getNama()+ " : Rp " + anggota1.getSimpanan());

        anggota1.setNama("Iwan Setiawan");
        anggota1.setAlamat("Jalan Sukarno Hatta no 10");
        anggota1.setor(100000);
        System.out.println("Simpanan " + anggota1.getNama() + " : Rp" + anggota1.getSimpanan());
        
        anggota1.pinjam(5000);
        System.out.println("Simpanan " + anggota1.getNama() + " : Rp" + anggota1.getSimpanan());
    }
}

```
### Hasil
![alt text](<image/percobaan 4.png>)

## 3.6 Pertanyaan – Percobaan 3 dan 4
### 1. Apa yang dimaksud getter dan setter?
Getter adalah method yang digunakan untuk mengambil atau mendapatkan nilai atribut, terutama atribut yang bersifat private.

Setter adalah method yang digunakan untuk mengubah atau memberikan nilai pada atribut private.

### 2. Apa kegunaan dari method getSimpanan()?
Method getSimpanan() digunakan untuk mengambil atau menampilkan nilai simpanan dari objek Anggota tanpa mengakses atribut simpanan secara langsung.

### 3. Method apa yang digunakan untuk menambah saldo?

Method yang digunakan untuk menambah saldo atau simpanan adalah method:

setor() 
### 4. Apa yang dimaksud konstruktor?
Konstruktor adalah method khusus dalam sebuah class yang digunakan untuk melakukan inisialisasi objek. Konstruktor akan dijalankan secara otomatis ketika sebuah objek dibuat menggunakan keyword new.

### 5. Sebutkan aturan dalam membuat konstruktor?
#### Aturan dalam membuat konstruktor adalah:

- Nama konstruktor harus sama dengan nama class.  
- Konstruktor tidak memiliki tipe data return.  
- Konstruktor dijalankan secara otomatis ketika objek dibuat.  
- Konstruktor tidak boleh menggunakan modifier abstract, static, final, dan synchronized.

### 6. Apakah boleh konstruktor bertipe private?
Boleh. Konstruktor dapat menggunakan access modifier private. Konstruktor private digunakan untuk membatasi pembuatan objek dari luar class.

### 7. Kapan menggunakan konstruktor dengan passing parameter?
Konstruktor dengan passing parameter digunakan ketika sebuah objek membutuhkan nilai awal yang spesifik saat pertama kali dibuat.

Contohnya, objek Anggota membutuhkan nilai nama dan alamat ketika objek dibuat.

### 8. Apa perbedaan inisialisasi atribut dan instansiasi atribut?
Inisialisasi atribut adalah proses memberikan nilai awal kepada sebuah atribut.

Sedangkan instansiasi adalah proses membuat objek dari sebuah class menggunakan keyword new.

Jadi, inisialisasi berkaitan dengan pemberian nilai, sedangkan instansiasi berkaitan dengan pembuatan objek.

### 9. Apa perbedaan inisialisasi method dan instansiasi method? 
Method sebenarnya tidak diinstansiasi secara terpisah seperti objek. Method dideklarasikan di dalam class dan dapat digunakan setelah objek dari class tersebut dibuat.

Pemanggilan method dilakukan menggunakan objek, contohnya:
```bash
Anggota anggota1 = new Anggota("Reyhandhika", "Sidoarjo");
anggota1.setor(100000);
```
Pada contoh tersebut, anggota1 adalah objek yang diinstansiasi, sedangkan setor() adalah method yang dipanggil melalui objek tersebut.

## 4. Kesimpulan
Dari percobaan diatas, telah dipelajari konsep dari enkapsulasi, konstruktor, access modifier yang terdiri dari 4 jenis yaitu public, protected, default dan private. Konsep atribut dan method class yang ada di dalam blok code class dan konsep instansiasi atribut atau method. Cara penggunaan getter dan setter beserta fungsi dari getter dan setter. Dan juga telah dipelajari atau memahami notasi UML

## 5. Tugas
### 1. Cobalah program dibawah ini dan tuliskan hasil outputnya

### Code EncapDemo.java
```bash
package Jobsheet3.tugas;

public class EncapDemo {
    private String name;
    private int age;
    
    public String getName(){
        return  name;
    }
    public void setName(String newName){
        name = newName;
    }
    public int getAge(){
        return  age;
    }
    public void setAge(int newAge){
        if(newAge > 30){
            age = 30;
        }
        else{

        }
        age = newAge;
    }
}

```
### Code EncapTest.java
```bash
package Jobsheet3.tugas;

public class EncapTest {
public static void main(String[] args) {
    
    EncapDemo encap = new EncapDemo();
    encap.setName("james");
    encap.setAge(35);

    System.out.println("Namee : " + encap.getName());
    System.out.println("Age : "+ encap.getAge());
    }
}
```
### Hasil 
![alt text](<image/percobaan 4.png>)

### 2. Pada program diatas, pada class EncapTest kita mengeset age dengan nilai 35, namun pada saat ditampilkan ke layar nilainya 30, jelaskan mengapa.

Hal tersebut terjadi karena pada method setAge() terdapat validasi atau batasan nilai umur. Ketika nilai age diisi dengan 35, nilai tersebut tidak langsung diterima begitu saja, tetapi diperiksa terlebih dahulu oleh method setter. Jika program membatasi nilai umur maksimal 30, maka nilai 35 akan diganti atau dibatasi menjadi 30. Hal ini merupakan salah satu penerapan enkapsulasi, yaitu mengontrol perubahan nilai atribut melalui method setter.

### 3. Ubah program agar atribut age memiliki nilai maksimal 30 dan minimal 18
``` bash
package Jobsheet3.tugas;

public class EncapDemo {
    private String name;
    private int age;
    
    public String getName(){
        return  name;
    }
    public void setName(String newName){
        name = newName;
    }
    public int getAge(){
        return  age;
    }
    public void setAge(int newAge){
        if(newAge > 30){
            age = 30;
        }
        \\ menambahkan atribut age memiliki nilai maksimal 30 dan minimal 18
        else if (age < 18){
            age = 18;
        }else{
            age = newAge;
        }
    }
}

```
Pada method setAge():

Jika umur lebih dari 30, maka nilainya menjadi 30.  
Jika umur kurang dari 18, maka nilainya menjadi 18.  
Jika umur berada di antara 18–30, maka nilai umur digunakan sesuai input.

### 4. Pada sebuah sistem manajemen pergudangan kargo ekspedisi, terdapat class Kontainer yang memiliki atribut antara lain nomorResi, namaPemilik, kapasitasMaksimal (dalam kg), dan beratMuatanSaatIni. Kontainer dapat menerima tambahan muatan barang dengan batasan kapasitas maksimal yang telah ditentukan. Kontainer juga dapat diturunkan muatannya (bongkar muat). Ketika barang diturunkan, maka jumlah muatan saat ini akan berkurang sesuai dengan nominal berat yang dikeluarkan Buatlah class Kontainer tersebut, berikan atribut (private), method getter, dan konstruktor sesuai dengan kebutuhan arsitektur enkapsulasi. Uji dengan kelas driver TestLogistik berikut ini untuk memeriksa apakah manajemen state kelas Anda telah berjalan dengan benar:

### Code Kontainer.java
```bash
package Jobsheet3.tugas;

public class Kontainer {
    private String nomorResi;
    private String namaPemilik;
    private double kapasitasMaksimal;
    private double beratMuatanSaatIni = 0;

    public Kontainer(String nomorResi, String namaPemilik, double kapasitasMaksimal) {
        this.nomorResi = nomorResi;
        this.namaPemilik = namaPemilik;
        this.kapasitasMaksimal = kapasitasMaksimal;
        this.beratMuatanSaatIni = 0;
    }

    public String getNomorResi() {
        return nomorResi;
    }

    public String getNamaPemilik() {
        return namaPemilik;
    }

    public double getKapasitasMaksimal() {
        return kapasitasMaksimal;
    }

    public double getBeratMuatanSaatIni() {
        return beratMuatanSaatIni;
    }

    public void tambahMuatan(double berat) {
        if (beratMuatanSaatIni + berat <= kapasitasMaksimal) {
            beratMuatanSaatIni += berat;
        } else {
            System.out.println("Muatan melebihi kapasitas maksimal!");
        }
    }

    public void turunkanMuatan(double berat) {
        if (berat <= beratMuatanSaatIni) {
            beratMuatanSaatIni -= berat;
        } else {
            System.out.println("Muatan yang diturunkan melebihi muatan saat ini!");
        }
    }
}
    

```

### Code TestLogistik.java
```bash
package Jobsheet3.tugas;

public class TestLogistik {
    public static void main(String[] args) {

        Kontainer kontainerAlfa = new Kontainer("REQ-998", "PT. Maju Bersama", 5000);

        System.out.println("Nama Pemilik Kontainer: " + kontainerAlfa.getNamaPemilik());
        System.out.println("Kapasitas Maksimal: " + kontainerAlfa.getKapasitasMaksimal() + " kg");
    
        System.out.println("\nMemasukkan muatan baru seberat 6.000 kg...");
        kontainerAlfa.tambahMuatan(6000);
        System.out.println("Berat muatan saat ini: " + kontainerAlfa.getBeratMuatanSaatIni() + " kg");

        System.out.println("\nMemasukkan muatan baru seberat 4.000 kg...");
        kontainerAlfa.tambahMuatan(4000);
        System.out.println("Berat muatan saat ini: " + kontainerAlfa.getBeratMuatanSaatIni() + " kg");

        System.out.println("\nMembongkar muat/menurunkan barang seberat 500- kg...");
        kontainerAlfa.turunkanMuatan(500);
        System.out.println("Berat muatan saat ini: " + kontainerAlfa.getBeratMuatanSaatIni() + " kg");

        System.out.println("\nMembongkar muat/menurunkan barang seberat 1.500 kg...");
        kontainerAlfa.turunkanMuatan(1500);
        System.out.println("Berat muatan saat ini: " + kontainerAlfa.getBeratMuatanSaatIni() + " kg");
    }
    
}

```

### Hasil
![alt text](<image/tugas 1.png>) 

Jawaban:
Method tambahMuatan() memastikan berat muatan tidak melebihi kapasitasMaksimal.
Method turunkanMuatan() memastikan berat yang diturunkan tidak lebih besar daripada beratMuatanSaatIni.

### 5. Modifikasi soal kargo logistik di atas agar nominal berat muatan yang dibongkar/diturunkan  dalam satu kali pemanggilan method turunkanMuatan() maksimal hanya boleh sebesar 50% dari  total  berat  muatan  saat  ini.  Langkah  ini  diterapkan  demi  alasan  keselamatan  kerja operasional  alat  berat  (crane).  Jika  operator  mencoba  menurunkan  muatan  melebihi  batas  50%  tersebut,  sistem  harus  memblokir  aksi  dan  memunculkan  peringatan:  "Maaf,  demi keselamatan,  pembongkaran  muatan  satu  kali  jalan  tidak  boleh  melebihi  50%  dari  muatan saat ini!". 
![alt text](<image/jalan tidak boleh melebihi 50%.png>)

```bash

    public void turunkanMuatan(double berat) {

        double batasMaksimal = beratMuatanSaatIni * 0.5;

        if (berat > batasMaksimal) {

            System.out.println(
                "Maaf, demi keselamatan, pembongkaran muatan "
                + "satu kali jalan tidak boleh melebihi 50% "
                + "dari muatan saat ini!"
            );

```

### 6. Modifikasi  kelas  Main  TestLogistik  agar  parameter  jumlah  berat  barang  yang  dimasukkan (tambahMuatan) maupun berat  barang yang dibongkar (turunkanMuatan)  dapat  menerima input  nilai  dinamis  dari  pengguna  secara  interaktif  melalui  terminal  menggunakan  utilitas java.util.Scanner. 

#### code TestLogistik.java
```bash
package Jobsheet3.tugas;

import java.util.Scanner;
public class TestLogistik {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        
        Kontainer kontainer1 = new Kontainer(
            "RESI001",
            "Reyhandhika",
            1000
        );

        System.out.println("=== SISTEM LOGISTIK KONTTAINER ===");

        System.out.println("Nomor Resi: "
                + kontainer1.getNomorResi());

        System.out.println("Nama Pemilik: "
                + kontainer1.getNamaPemilik());

        System.out.println("Kapasitas Maksimal: "
                + kontainer1.getKapasitasMaksimal() + " kg");


        System.out.print("\nMasukkan berat muatan: ");
        double tambah = input.nextDouble();

        kontainer1.tambahMuatan(tambah);

        System.out.println("Muatan saat ini: "
                + kontainer1.getBeratMuatanSaatIni() + " kg");


        System.out.print("\nMasukkan berat yang akan diturunkan: ");
        double turun = input.nextDouble();

        kontainer1.turunkanMuatan(turun);

        System.out.println("Muatan saat ini: "
                + kontainer1.getBeratMuatanSaatIni() + " kg");

        input.close();
    }
}
```
![alt text](<image/tugas 6.png>)

### 7. Sebuah  aplikasi  pemesanan  tiket  bioskop  memerlukan  kelas  Tiket  untuk  mengelola  data pemesanan secara aman. Kelas ini harus memiliki atribut private: judulFilm (String), hargaDasar (double), dan statusPembayaran (boolean). Ketentuan pengesetan nilai objek:● Konstruktor harus menerima parameter judulFilm dan hargaDasar. Nilai awal statusPembayaran selalu diset false (Belum Dibayar). ● Atribut hargaDasar tidak boleh bernilai negatif. Jika input yang dimasukkan kurang dari 0, otomatis set nilai default ke Rp 35.000. ● Sediakan  method  lakukanPembayaran()  untuk  mengubah  statusPembayaran  menjadi true. ● Nilai statusPembayaran hanya boleh dibaca (Read-Only) menggunakan getter, tidak boleh memiliki fungsi setter langsung dari luar kelas demi alasan keamanan transaksi. ● Uji kode Anda menggunakan kelas TestBioskop berikut: 

### Code TestBioskop.java
```bash
package Jobsheet3.tugas;

public class TestBioskop {
        public static void main(String[] args) {
        Tiket tiket1 = new Tiket("Avengers: Endgame", -50000);
        System.out.println("Film: " + tiket1.getJudulFilm());
        System.out.println("Harga Tiket: " + tiket1.getHargaDasar());
        System.out.println("Status Lunas? " + tiket1.isStatusPembayaran());

        System.out.println("\nMemproses pembayaran...");
        tiket1.lakukanPembayaran();
        System.out.println("Status Lunas Terbaru? " + tiket1.isStatusPembayaran());
    }
    
}
```
### Code Tiket.java
```bash
package Jobsheet3.tugas;

public class Tiket {
    private String judulFilm;
    private double hargaDasar;
    private boolean statusPembayaran;

    public Tiket(String judulFilm, double hargaDasar) {
        this.judulFilm = judulFilm;
        
        if (hargaDasar < 0) {
            this.hargaDasar = 35000;
        } else {
            this.hargaDasar = hargaDasar;
        }
        
        this.statusPembayaran = false;
    }

    public String getJudulFilm() {
        return judulFilm;
    }

    public double getHargaDasar() {
        return hargaDasar;
    }

    public boolean isStatusPembayaran() {
        return statusPembayaran;
    }

    public void lakukanPembayaran() {
        this.statusPembayaran = true;
    }
    
}
```
### Hasil
![alt text](<image/Tugas 7.png>)