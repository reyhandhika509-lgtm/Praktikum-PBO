# Laporan Praktikum Pemrograman Berbasis Objek - Pertemuan 7
## Overloading dan Overriding

<h4>Nama    : Reyhandhika Zikri Prijadi</h4>
<h4>NIM     : 254107020219</h4>
<h4>Kelas   : TI-2G</h4>

---

## Percobaan 1: Overloading Method (Perkalian)

### Code Perkalian.java
```java
package id.ac.polinema.overloading.percobaan1;

public class Perkalian {
    public int kali(int a, int b) {
        return a * b;
    }

    public int kali(int a, int b, int c) {
        return a * b * c;
    }

    public double kali(double a, double b) {
        return a * b;
    }

    public void tampilkan(int nomor, String label) {
        System.out.println(nomor + ". " + label);
    }

    public void tampilkan(String label, int nomor) {
        System.out.println(label + " #" + nomor);
    }
}
```
### MainPercobaan1.java
```java
package id.ac.polinema.overloading.percobaan1;

public class MainPercobaan1 {
    public static void main(String[] args) {
        Perkalian p = new Perkalian();
        System.out.println("kali(25, 43) = " + p.kali(25, 43));
        System.out.println("kali(34, 23, 56) = " + p.kali(34, 23, 56));
        System.out.println("kali(25.5, 4.0) = " + p.kali(25.5, 4.0));

        p.tampilkan(1, "Perkalian");
        p.tampilkan("Perkalian", 1);
    }
}
```
### OUTPUT:
```bash
kali(25, 43) = 1075
kali(34, 23, 56) = 43792
kali(25.5, 4.0) = 102.0
1. perkalian
perkalian #1
```
## Pertanyaan Percobaan 1
### 1. Sebutkan method hasil overloading pada Perkalian dan pembeda tiap 
- pasangannya:kali(int, int) dan kali(int, int, int) $\rightarrow$  Jumlah parameter berbeda.

- kali(int, int) dan kali(double, double) $\rightarrow$ Tipe parameter berbeda.

- tampilkan(int, String) dan tampilkan(String, int) $\rightarrow$ Urutan tipe parameter berbeda.

### 2. Pada p.kali(25.5, 4.0), versi kali() mana yang dipanggil? Mengapa bukan versi int? 
- Versi kali(double, double) yang dipanggil karena tipe argumen yang diberikan adalah double (desimal). Compiler mencocokkan tipe data argumen secara tepat. 
### 3. Mengapa tampilkan(int, String) dan tampilkan(String, int) sah sebagai overloading, sedangkan dua method yang hanya beda tipe kembalian atau nama parameter tidak?
- Karena overloading diidentifikasi berdasarkan signature method (nama method + jumlah/tipe/urutan parameter). Tipe kembalian (return type) dan nama parameter bukan bagian dari signature yang digunakan compiler untuk membedakan method.

### 4. Pada eksperimen ketiga, mengapa kali(5, 2.5) menghasilkan 12.5 dan bukan error?
- Karena angka 5 (int) mengalami pelebaran tipe data (widening) secara otomatis menjadi double (5.0), sehingga cocok dengan method kali(double, double).

## Percobaan 2: Pemilihan Overload oleh Compiler (Resolusi)
### Code Resolusi.java
```java
package id.ac.polinema.overloading.percobaan2;

public class Resolusi {
    public static void tampil(long x) {
        System.out.println("tampil(long) : " + x);
    }

    public static void tampil(Integer x) {
        System.out.println("tampil(Integer) : " + x);
    }

    public static void tampil(Object x) {
        System.out.println("tampil(Object) : " + x);
    }

    public static void tampil(int... x) {
        System.out.println("tampil(int...) : " + x.length + " elemen");
    }
}
```
### Code MainPercobaan2.java
```java
package id.ac.polinema.overloading.percobaan2;

public class MainPercobaan2 {
    public static void main(String[] args) {
        Resolusi.tampil(5);
        Resolusi.tampil(5L);
        Resolusi.tampil(Integer.valueOf(7));
        Resolusi.tampil(3.5);
        Resolusi.tampil("Java");
        Resolusi.tampil();
        Resolusi.tampil(1, 2, 3);
    }
}
```
### Output:
```bash
Tampil(long)    : 5
Tampil(long)    : 5
tampil(Integer) : 7
tampil(Object)  : 3.5
tampil(Object)  : Java
tampil(int...)  : 0elemen
tampil(int...)  : 3elemen
```
## Pertanyaan Percobaan 2
### 1. Mengapa tampil(5) memilih tampil(long) dan bukan tampil(Integer)?
- Java memprioritaskan fase pemilihan overload: (1) Widening didahulukan sebelum (2) Boxing. Mengubah int ke long (widening) berada di Fase 1, sedangkan mengubah int ke Integer (boxing) berada di Fase 

### 2. Jelaskan perpindahan overload saat dikomentari berturut-turut:Ketika tampil(long) dikomentari, tampil(5) memilih tampil(Integer) (fase boxing).

- Ketika tampil(Integer) dikomentari, memilih tampil(Object) (boxing int ke Integer, lalu subtype ke Object).
Ketika tampil(Object) dikomentari, memilih tampil(int...) (fase varargs).

### 3. Mengapa tampilLong(5) gagal (dengan parameter Long), sedangkan tampil(5) dapat berakhir pada tampil(Object)?
- Java tidak mengizinkan gabungan widening dilanjutkan dengan boxing (misal int $\rightarrow$ long $\rightarrow$ Long). Namun Java mengizinkan boxing dilanjutkan widening (int $\rightarrow$ Integer $\rightarrow$ Object).

### 4. Tantangan Prediksi:
- Resolusi.tampil((short) 3) $\rightarrow$ Dipanggil tampil(long) karena short di-widening ke long.
- Resolusi.tampil('A') $\rightarrow$ Dipanggil tampil(long) karena char di-widening ke long (nilai ASCII 65).

## Percobaan 3: Overloading Konstruktor (Kucing)
### Code Kucing.java
```java
package id.ac.polinema.overloading.percobaan3;

public class Kucing {
    private String nama;
    private int umur;

    public Kucing(String nama) {
        this(nama, 1);
        System.out.println("Konstruktor 1 parameter selesai");
    }

    public Kucing(String nama, int umur) {
        this.nama = nama;
        this.umur = umur;
        System.out.println("Konstruktor 2 parameter selesai");
    }

    public void info() {
        System.out.println("Kucing " + nama + ", umur " + umur + " tahun");
    }
}
```
### MainPercobaan3.java
```java
package id.ac.polinema.overloading.percobaan3;

public class MainPercobaan3 {
    public static void main(String[] args) {
        Kucing a = new Kucing("Tom");
        a.info();

        System.out.println();

        Kucing b = new Kucing("Garfield", 5);
        b.info();
    }
}
```
### Output:
```bash
Konstruktor 2 parameter selesai
Konstruktor 1 parameter selesai
Kucing Tom, umur 1 tahun

Konstruktor 2 parameter selesai
Kucing Garfield, umur 5 tahun
```
### 1. Pertanyaan Percobaan 3Mengapa "Konstruktor 2 parameter selesai" tercetak lebih dulu daripada 1 parameter pada new Kucing("Tom")?
- Karena konstruktor 1 parameter langsung memanggil konstruktor 2 parameter via this(nama, 1) di baris pertama. Logika pada konstruktor 2 parameter diselesaikan terlebih dahulu sebelum eksekusi pada konstruktor 1 parameter dilanjutkan.

### 2. Apa keuntungan this(nama, 1)?
- Menghindari duplikasi kode (code reusability) untuk inisialisasi atribut.

### 3. Penambahan konstruktor tanpa parameter public Kucing():
- Urutan eksekusi: Konstruktor 2 parameter $\rightarrow$ Konstruktor 1 parameter $\rightarrow$ Konstruktor 0 parameter.

### Output new Kucing():
```bash
PlaintextKonstruktor 2 parameter selesai
Konstruktor 1 parameter selesai
Konstruktor 0 parameter selesai
```

## Percobaan 4: Dasar Overriding (Ikan dan Piranha)
### Code Ikan.java
```java
package id.ac.polinema.overriding.percobaan4;

public class Ikan {
    public void swim() {
        System.out.println("Ikan bisa berenang");
    }

    public Ikan beranak() {
        return new Ikan();
    }
}
```
### Code Piranha.java
```java
package id.ac.polinema.overriding.percobaan4;

public class Piranha extends Ikan {
    @Override
    public void swim() {
        super.swim();
        System.out.println("Piranha bisa makan daging");
    }

    @Override
    public Piranha beranak() {
        return new Piranha();
    }
}
```
### Code MainPercobaan4.java
```java
package id.ac.polinema.overriding.percobaan4;

public class MainPercobaan4 {
    public static void main(String[] args) {
        Ikan a = new Ikan();
        Piranha c = new Piranha();

        a.swim();
        c.swim();

        Piranha anak = c.beranak();
        System.out.println("Tipe objek anak: " + anak.getClass().getSimpleName());
    }
}
```
### Output:
```bash
Ikan bisa berenang
Ikan bisa berenang
Piranha bisa makan daging
Tipe objek anak: Piranha
```

## Pertanyaan Percobaan 4
### 1. Peran super.swim():
- super.swim() berfungsi untuk memanggil method swim() dari superclass (Ikan). Jika baris tersebut dihapus, hanya cetakan "Piranha bisa makan daging" yang akan tampil.

### 2. Manfaat Covariant Return pada beranak():
- Mengizinkan overriding method mengembalikan tipe spesifik subclass (Piranha) alih-alih superclass (Ikan). Kode Piranha anak = c.beranak(); valid tanpa perlu melakukan casting tipe data.

### 3. Aturan Overriding yang dilanggar pada eksperimen:
- Memperketat hak akses (access modifier tidak boleh lebih sempit).
- Meng-override method berpembatas final.
- Mengubah parameter saat menggunakan @Override (harus persis).
- Melempar checked exception baru yang tidak dideklarasikan di superclass.

### 4. Jika @Override dihapus pada swim(int jarak):
- Kode dianggap sebagai overloading baru, bukan overriding.

### 5. Jika swim() di Ikan bernilai private:
- Kompilasi gagal pada @Override di Piranha karena method private tidak diwariskan sehingga tidak dapat di-override.

## Percobaan 5: Overloading dan Percobaan 5: Overloading dan Overriding Bersama (Karyawan, Staff, Manager)
### ode Karyawan.java
```java
package id.ac.polinema.overriding.percobaan5;

public class Karyawan {
    protected String nip;
    protected String nama;
    protected String golongan;
    protected double gajiPokok;

    public Karyawan(String nip, String nama, String golongan) {
        this.nip = nip;
        this.nama = nama;
        this.golongan = golongan;
        this.gajiPokok = hitungGajiPokok(golongan);
    }

    private static double hitungGajiPokok(String golongan) {
        return switch (golongan) {
            case "1" -> 5000000;
            case "2" -> 3000000;
            case "3" -> 2000000;
            case "4" -> 1000000;
            case "5" -> 750000;
            default -> throw new IllegalArgumentException("Golongan tidak dikenal: " + golongan);
        };
    }

    public String getNama() {
        return nama;
    }

    public double getGaji() {
        return gajiPokok;
    }

    public void lihatInfo() {
        System.out.println("NIP        : " + nip);
        System.out.println("Nama       : " + nama);
        System.out.println("Golongan   : " + golongan);
        System.out.printf("Gaji       : %.0f%n", getGaji());
    }
}
```
### Code Staff.java
```java
package id.ac.polinema.overriding.percobaan5;

public class Staff extends Karyawan {
    private int jamLembur;
    private double tarifLembur;

    public Staff(String nip, String nama, String golongan, int jamLembur, double tarifLembur) {
        super(nip, nama, golongan);
        this.jamLembur = jamLembur;
        this.tarifLembur = tarifLembur;
    }

    // OVERLOADING: parameter berbeda
    public double getGaji(int jamLembur, double tarifLembur) {
        return super.getGaji() + jamLembur * tarifLembur;
    }

    // OVERRIDING: signature sama persis
    @Override
    public double getGaji() {
        return getGaji(jamLembur, tarifLembur);
    }

    @Override
    public void lihatInfo() {
        super.lihatInfo();
        System.out.println("Jam lembur : " + jamLembur);
        System.out.printf("Tarif/jam  : %.0f%n", tarifLembur);
    }
}
```
### Code Manager.java
```java
package id.ac.polinema.overriding.percobaan5;

public class Manager extends Karyawan {
    private double tunjangan;
    private String bagian;
    private Staff[] bawahan;

    public Manager(String nip, String nama, String golongan, double tunjangan, String bagian, Staff[] bawahan) {
        super(nip, nama, golongan);
        this.tunjangan = tunjangan;
        this.bagian = bagian;
        this.bawahan = bawahan;
    }

    @Override
    public double getGaji() {
        return super.getGaji() + tunjangan;
    }

    public void viewStaff() {
        System.out.println("--------------------");
        for (Staff s : bawahan) {
            s.lihatInfo();
            System.out.println("--------------------");
        }
    }

    @Override
    public void lihatInfo() {
        System.out.println("Manager    : " + bagian);
        super.lihatInfo();
        System.out.printf("Tunjangan  : %.0f%n", tunjangan);
        viewStaff();
    }
}
```
### Code MainPercobaan5.java
```java
package id.ac.polinema.overriding.percobaan5;

public class MainPercobaan5 {
    public static void main(String[] args) {
        Staff usman = new Staff("0003", "Usman", "2", 10, 10000);
        Staff anugrah = new Staff("0005", "Anugrah", "2", 10, 55000);
        Manager tedjo = new Manager("101", "Tedjo", "1", 5000000, "Administrasi", new Staff[] {usman, anugrah});

        tedjo.lihatInfo();

        System.out.println();
        System.out.println("Simulasi lembur Usman 20 jam @ 15000 = " + (long) usman.getGaji(20, 15000));
    }
}
```
### Output:
```bash
Manager : Administrasi
NIP : 101
Nama : Tedjo
Golongan : 1
Gaji : 10000000
Tunjangan : 5000000
----------------------------
NIP : 0003
Nama : Usman
Golongan : 2
Gaji : 3100000
Jam lembur : 10
Tarif/jam : 10000
----------------------------
NIP : 0005
Nama : Anugrah
Golongan : 2
Gaji : 3550000
Jam lembur : 10
Tarif/jam : 55000
----------------------------

Simulasi lembur Usman 20 jam @ 15000 = 3300000

```
## Pertanyaan Percobaan 5
### 1. Method Overloading dan Overriding:

- Overloading: Staff.getGaji(int, double) (berbeda parameter dibanding Karyawan.getGaji()).

- Overriding: Staff.getGaji(), Manager.getGaji(), Staff.lihatInfo(), dan Manager.lihatInfo() (signature persis dengan superclass).

### 2. Sebab pemanggilan super.getGaji():

- getGaji(int, double) memerlukan gaji pokok dari superclass Karyawan. Jika diubah menjadi return getGaji() + ..., akan terjadi rekursi tak berhingga (Infinite Recursion / StackOverflowError).

### 3. Akibat jika getGaji() di Staff hanya return jamLembur * tarifLembur;:

- Gaji pokok Staff tidak dihitung (hanya uang lembur). Gaji Manager tidak ikut berubah karena Manager memanggil super.getGaji() dari class Karyawan.

### 4. Hubungan Manager dengan Staff dan Karyawan:

- Hubungan Manager - Karyawan: IS-A (Pewarisan/Inheritance via extends).

- Hubungan Manager - Staff: HAS-A (Agregasi via atribut private Staff[] bawahan).


## Tugas 1: Overloading pada Class Segitiga
### Code Segitiga.java
```Java
package id.ac.polinema.overloading.tugas1;

public class Segitiga {
    private int sudut;

    public int sisaSudut(int sudutA) {
        this.sudut = 180 - sudutA;
        return this.sudut;
    }

    public int sisaSudut(int sudutA, int sudutB) {
        this.sudut = 180 - (sudutA + sudutB);
        return this.sudut;
    }

    public int keliling(int sisiA, int sisiB, int sisiC) {
        return sisiA + sisiB + sisiC;
    }

    public double keliling(int sisiA, int sisiB) {
        double c = Math.sqrt(Math.pow(sisiA, 2) + Math.pow(sisiB, 2));
        return sisiA + sisiB + c;
    }

    public int getSudut() {
        return sudut;
    }
}
```
### Code MainTugas1.java
```Java
package id.ac.polinema.overloading.tugas1;

public class MainTugas1 {
    public static void main(String[] args) {
        Segitiga t = new Segitiga();
        System.out.println("Jumlah dua sudut lain : " + t.sisaSudut(60));
        System.out.println("Sudut ketiga           : " + t.sisaSudut(60, 50));
        System.out.println("Keliling 3, 4, 5       : " + t.keliling(3, 4, 5));
        System.out.println("Keliling siku 3, 4     : " + t.keliling(3, 4));
        System.out.println("Keliling siku 5, 12    : " + t.keliling(5, 12));
    }
}

```
### Output:
```bash
Jumlah dua sudut lain : 120
Sudut ketiga           : 70
Keliling 3, 4, 5       : 12
Keliling siku 3, 4     : 12.0
Keliling siku 5, 12    : 30.0
```
## Pertanyaan Analisis Tugas 1:  
(a) Apakah beda tipe kembalian yang membuat keliling sah di-overload?

- Bukan. Pembeda utamanya adalah jumlah parameter (3 parameter vs 2  parameter).

(b) Jika dipanggil t.keliling(3, 4.0):  
- Terjadi error kompilasi karena tidak ada method keliling yang menerima kombinasi parameter (int, double).

## Tugas 2: Overriding pada Manusia, Dosen, dan Mahasiswa
### Code Manusia.java
```Java
package id.ac.polinema.overriding.tugas2;

public class Manusia {
    public void bernafas() {
        System.out.println("Manusia bernafas dengan paru-paru");
    }

    public void makan() {
        System.out.println("Manusia makan nasi");
    }
}
```
### Code Dosen.java
```Java
package id.ac.polinema.overriding.tugas2;

public class Dosen extends Manusia {
    @Override
    public void makan() {
        super.makan();
        System.out.println("Dosen makan di kantin fakultas");
    }

    public void lembur() {
        System.out.println("Dosen lembur menilai ujian");
    }
}
```
### Code Mahasiswa.java
```Java
package id.ac.polinema.overriding.tugas2;

public class Mahasiswa extends Manusia {
    @Override
    public void makan() {
        System.out.println("Mahasiswa makan di kantin kampus");
    }

    public void tidur() {
        System.out.println("Mahasiswa tidur di perpustakaan");
    }
}
```
### Code MainTugas2.java
```Java
package id.ac.polinema.overriding.tugas2;

public class MainTugas2 {
    public static void main(String[] args) {
        Manusia manusia = new Manusia();
        Dosen dosen = new Dosen();
        Mahasiswa mhs = new Mahasiswa();

        System.out.println("== Manusia ==");
        manusia.bernafas();
        manusia.makan();

        System.out.println("\n== Dosen ==");
        dosen.bernafas();
        dosen.makan();
        dosen.lembur();

        System.out.println("\n== Mahasiswa ==");
        mhs.bernafas();
        mhs.makan();
        mhs.tidur();
    }
}
```
### Output: 
```bash
== Manusia ==
Manusia bernafas dengan paru-paru
Manusia makan nasi

== Dosen ==
Manusia bernafas dengan paru-paru
Manusia makan nasi
Dosen makan di kantin fakultas
Dosen lembur menilai ujian

== Mahasiswa ==
Manusia bernafas dengan paru-paru
Mahasiswa makan di kantin kampus
Mahasiswa tidur di perpustakaan
```
### Pertanyaan Analisis Tugas 2:
(a) Mengapa bernafas() pada Mahasiswa mencetak teks milik Manusia sedangkan makan() tidak?

- Mahasiswa mewarisi bernafas() dari Manusia tanpa meng-override-nya, sedangkan makan() di-override sehingga mengeksekusi implementasi baru milik Mahasiswa.

(b) Peran super.makan() pada Dosen vs Mahasiswa:

- Dosen memanggil super.makan(), sehingga menjalankan dulu pencetakan milik superclass (Manusia makan nasi), lalu mencetak teks miliknya. Mahasiswa tidak memanggil super.makan(), sehingga sepenuhnya mengganti perilaku superclass.

## Tugas 3: Jawab Singkat1. 
### 1. Perbandingan Overloading dan Overriding
- Lokasi Terjadi
    - Overloading: Terjadi dalam satu kelas yang sama (atau bisa juga pada subclass).   
    - Overriding: Terjadi antara superclass dan subclass (dalam hierarki pewarisan).   

- Signature (Parameter)

    - Overloading: Harus berbeda, baik dari segi jumlah, tipe data, maupun urutan parameternya.   
    
    - Overriding: Harus sama persis, baik jumlah, tipe data, maupun urutan parameternya.   
- Tipe Kembalian (Return Type)
    - Overloading: Boleh sama atau berbeda, karena tipe kembalian bukan merupakan pembeda overloading.   
    - Overriding: Harus sama, atau berupa subclass-nya (covariant return).
    
- Access Modifier
    - Overloading: Boleh bebas (tidak ada batasan hak akses).   
    - Overriding: Harus sama atau lebih luas/longgar (less restrictive) dibanding method di superclass.  
    
- Peran Annotation @Override
    - Overloading: Tidak dapat digunakan (akan menyebabkan error jika dipasang).   
    - Overriding: Digunakan untuk menandai secara eksplisit serta memvalidasi ke compiler bahwa method tersebut meng-override method milik superclass.  
### 2. Pemilihan Overloading vs Overriding & Contoh
- Overloading: Dipilih saat ingin menyediakan beberapa variasi cara pemanggilan suatu fungsi/method berdasarkan masukan parameter yang berbeda dalam satu kelas.  
    - Contoh: Method keliling() pada class Segitiga, di mana terdapat keliling(int, int, int) untuk segitiga sembarang dan keliling(int, int) untuk segitiga siku-siku.  

- Overriding: Dipilih saat subclass perlu mengubah atau memberikan perilaku/implementasi yang lebih spesifik atas method yang diwarisi dari superclass.   
    - Contoh: Method getGaji() pada class Staff yang meng-override getGaji() milik Karyawan untuk menambahkan perhitungan uang lembur.  

### 3. Alasan Method static, private, dan final Tidak Dapat Di-override
- static: Terikat pada tingkat kelas (class-level / static binding) dan diproses saat kompilasi, bukan terikat pada instance objek (dynamic polymorphism).

- private: Tidak dapat diakses atau tidak diwariskan ke subclass, sehingga subclass tidak bisa meng-override method yang tidak diketahuinya.   

- final: Secara eksplisit dideklarasikan untuk melarang pendefinisian ulang atau perubahan implementasi oleh subclass