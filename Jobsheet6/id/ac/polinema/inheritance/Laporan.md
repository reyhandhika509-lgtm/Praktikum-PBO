# laporan Praktikum Pemograman Berbasis Objek 2

<h4>Nama    : Reyhandhika Zikri Prijadi<h4>
<h4>Nim     : 254107020219<h4>
<h4>Kelas   : TI-2G<h4>

# Laporan Praktikum Pemrograman Berbasis Objek
## Jobsheet 06: Inheritance (Pewarisan)

**Mata Kuliah:** Praktikum Pemrograman Berbasis Objek   
**Pertemuan:** 6 (Minggu 6)  
**Topik:** Konsep Pewarisan (*Inheritance*), *Single* dan *Multilevel Inheritance*, Hak Akses Member (*private* vs *protected*), Kata Kunci `this` dan `super`, Urutan Konstruktor, dan *Method Overriding*.


## Percobaan 1: Single Inheritance dengan extends (ClassA dan ClassB)

### 1. Kode Program

#### `ClassA.java`
```java
public class ClassA {
    public int x;
    public int y;

    public void getNilai() {
        System.out.println("nilai x: " + x);
        System.out.println("nilai y: " + y);
    }
}
```

#### `ClassB.java` (Setelah Langkah 6 - Perbaikan dengan `extends ClassA`)
```java
public class ClassB extends ClassA {
    public int z;

    public void getNilaiZ() {
        System.out.println("nilai z: " + z);
    }

    public void getJumlah() {
        System.out.println("jumlah: " + (x + y + z));
    }
}
```

#### `MainPercobaan1.java`
```java
public class MainPercobaan1 {
    public static void main(String[] args) {
        ClassB hitung = new ClassB();
        hitung.x = 20;
        hitung.y = 30;
        hitung.z = 5;
        hitung.getNilai();
        hitung.getNilaiZ();
        hitung.getJumlah();
    }
}
```

### 2. Output Program

#### A. Saat Langkah 5 (Kompilasi Error sebelum penambahan `extends`):
```text
id\ac\polinema\inheritance\percobaan1\ClassB.java:11: error: cannot find symbol
        System.out.println("jumlah: " + (x + y + z));
                                         ^
  symbol:   variable x
  location: class ClassB
id\ac\polinema\inheritance\percobaan1\ClassB.java:11: error: cannot find symbol
        System.out.println("jumlah: " + (x + y + z));
                                             ^
  symbol:   variable y
  location: class ClassB
id\ac\polinema\inheritance\percobaan1\MainPercobaan1.java:6: error: cannot find symbol
        hitung.x = 20;
              ^
  symbol:   variable x
  location: variable hitung of type ClassB
id\ac\polinema\inheritance\percobaan1\MainPercobaan1.java:7: error: cannot find symbol
        hitung.y = 30;
              ^
  symbol:   variable y
  location: variable hitung of type ClassB
id\ac\polinema\inheritance\percobaan1\MainPercobaan1.java:9: error: cannot find symbol
        hitung.getNilai();
              ^
  symbol:   method getNilai()
  location: variable hitung of type ClassB
5 errors
```

#### B. Saat Langkah 7 (Setelah perbaikan `extends ClassA`):
```text
nilai x: 20
nilai y: 30
nilai z: 5
jumlah: 55
```

### 3. Pertanyaan Percobaan 1

1. **Mengapa kompilasi pada Langkah 5 gagal? Tuliskan pesan error pertama beserta file dan baris tempat error muncul.**  
   **Jawab:**  
   Kompilasi gagal karena `ClassB` belum dideklarasikan mewarisi `ClassA` (belum ada kata kunci `extends ClassA`). Akibatnya, `ClassB` tidak mengenali atribut `x` dan `y` di dalam method `getJumlah()`, dan class `MainPercobaan1` tidak dapat mengakses `hitung.x`, `hitung.y`, maupun `hitung.getNilai()` melalui objek `ClassB`.  
   *Pesan error pertama:*
   ```text
   id\ac\polinema\inheritance\percobaan1\ClassB.java:11: error: cannot find symbol
           System.out.println("jumlah: " + (x + y + z));
                                            ^
     symbol:   variable x
     location: class ClassB
   ```
   Error pertama muncul pada file `ClassB.java` baris ke-11.

2. **Baris kode mana yang diubah pada Langkah 6, dan apa artinya? Sebutkan class yang berperan sebagai superclass dan subclass.**  
   **Jawab:**  
   Baris kode yang diubah adalah deklarasi class pada file `ClassB.java`:
   ```java
   public class ClassB extends ClassA {
   ```
   *Arti:* Kata kunci `extends ClassA` mendefinisikan hubungan pewarisan (*inheritance*), yang berarti `ClassB` mewarisi seluruh atribut dan method publik/non-private milik `ClassA`.  
   - **Superclass:** `ClassA` (parent / base class)  
   - **Subclass:** `ClassB` (child / derived class)

3. **Setelah diperbaiki, sebutkan atribut dan method yang dapat dipakai oleh objek hitung. Kelompokkan mana yang dideklarasikan di ClassA dan mana yang dideklarasikan di ClassB.**  
   **Jawab:**  
   - **Dideklarasikan di `ClassA` (diwariskan ke `ClassB`):**  
     - Atribut: `x` (int), `y` (int)  
     - Method: `getNilai()` (void)  
   - **Dideklarasikan di `ClassB`:**  
     - Atribut: `z` (int)  
     - Method: `getNilaiZ()` (void), `getJumlah()` (void)

4. **Pada MainPercobaan1, hitung.x = 20 ditulis pada objek ClassB, padahal atribut x tidak dideklarasikan di ClassB. Mengapa hal ini diperbolehkan?**  
   **Jawab:**  
   Hal ini diperbolehkan karena konsep pewarisan (*inheritance*). Ketika `ClassB` menjadi subclass dari `ClassA`, seluruh atribut non-private milik `ClassA` (dalam hal ini `public int x`) diwariskan menjadi bagian dari anggota objek `ClassB`. Karena modifier-nya adalah `public`, atribut tersebut dapat diakses langsung oleh objek `hitung`.

5. **Atribut x dan y pada ClassA dibuat public, sehingga dapat diubah langsung dari MainPercobaan1. Apa risiko dari desain seperti ini? (jawaban ini akan kita telusuri pada Percobaan 2)**  
   **Jawab:**  
   Desain tersebut melanggar prinsip dasar enkapsulasi (*data hiding*). Risikonya adalah:
   - Nilai variabel rentan diubah secara sembarangan atau diisi data tidak valid dari luar tanpa melalui mekanisme validasi/kontrol internal class.
   - Terjadi ketergantungan erat (*tight coupling*) antara class pengakses dan struktur internal `ClassA`. Jika tipe data atau nama variabel `ClassA` diganti, kode di seluruh class pemanggil akan rusak.

6. **Coba tambahkan class ClassD lalu ubah deklarasi menjadi `public class ClassB extends ClassA, ClassD`. Apa yang terjadi? Apa yang dapat Anda simpulkan tentang jumlah superclass langsung pada Java?**  
   **Jawab:**  
   - *Hasil kompilasi:* Menghasilkan error sintaks: `error: '{' expected`.  
   - *Kesimpulan:* Bahasa pemrograman Java **tidak mendukung multiple inheritance untuk class** (hanya mendukung *single inheritance*). Sebuah class di Java hanya diizinkan memiliki **satu superclass langsung**. Jika ingin menerapkan pewarisan banyak tipe perilaku, Java menyediakannya melalui mekanisme implementasi *interface* (`implements`).

---

## Percobaan 2: Hak Akses pada Pewarisan (private dan protected)

### 1. Kode Program (Perbaikan B - Final)

#### `ClassA.java`
```java
public class ClassA {
    private int x;
    private int y;

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void getNilai() {
        System.out.println("nilai x: " + x);
        System.out.println("nilai y: " + y);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
```

#### `ClassB.java`
```java
public class ClassB extends ClassA {
    private int z;

    public void setZ(int z) {
        this.z = z;
    }

    public void getNilaiZ() {
        System.out.println("nilai z: " + z);
    }

    public void getJumlah() {
        System.out.println("jumlah: " + (getX() + getY() + z));
    }
}
```

#### `MainPercobaan2.java`
```java
public class MainPercobaan2 {
    public static void main(String[] args) {
        ClassB hitung = new ClassB();
        hitung.setX(20);
        hitung.setY(30);
        hitung.setZ(5);
        hitung.getNilai();
        hitung.getNilaiZ();
        hitung.getJumlah();
    }
}
```

### 2. Output Program

#### A. Saat Langkah 5 (Error ketika x dan y berstatus `private` di ClassA dan diakses langsung di ClassB):
```text
id\ac\polinema\inheritance\percobaan2\ClassB.java:15: error: x has private access in ClassA
        System.out.println("jumlah: " + (x + y + z));
                                         ^
id\ac\polinema\inheritance\percobaan2\ClassB.java:15: error: y has private access in ClassA
        System.out.println("jumlah: " + (x + y + z));
                                             ^
2 errors
```

#### B. Output Sukses (Langkah 6 Perbaikan A maupun Langkah 7 Perbaikan B):
```text
nilai x: 20
nilai y: 30
nilai z: 5
jumlah: 55
```

### 3. Pertanyaan Percobaan 2

1. **Di file dan baris mana error pada Langkah 5 muncul, dan apa pesannya? Mengapa error tidak muncul di MainPercobaan2?**  
   **Jawab:**  
   - Error muncul di file `ClassB.java` pada baris ke-15.  
   - Pesan error:  
     `error: x has private access in ClassA`  
     `error: y has private access in ClassA`  
   - Error tidak muncul di `MainPercobaan2` karena `MainPercobaan2` tidak mengakses atribut `x` dan `y` secara langsung, melainkan melalui method berakses `public` (`setX()`, `setY()`, `setZ()`, `getNilai()`, dll). Pemanggilan method public sah menurut aturan hak akses.

2. **Jelaskan penyebab error tersebut dengan merujuk pada tabel kontrol pengaksesan (Langkah 1).**  
   **Jawab:**  
   Berdasarkan tabel kontrol pengaksesan, modifier `private` hanya mengizinkan pengaksesan data dari dalam **class yang sama** tempat atribut dideklarasikan. Member bertipe `private` tidak diwariskan ke subclass dan tidak dapat diakses langsung oleh subclass manapun, meskipun berada di dalam package yang sama. Oleh karena itu, usaha `ClassB` mengakses variabel `x` dan `y` secara langsung pada ekspresi `(x + y + z)` ditolak oleh compiler.

3. **Pada kode awal, MainPercobaan2 memanggil hitung.setX(20) dan tidak error, padahal x bersifat private. Mengapa pemanggilan ini diperbolehkan, dan di mana nilai x tersimpan?**  
   **Jawab:**  
   - Pemanggilan ini diperbolehkan karena method `setX(int x)` dideklarasikan dengan access modifier `public` di `ClassA`. Method tersebut berada di dalam lingkup class `ClassA`, sehingga memiliki hak legal untuk mengubah atribut private `this.x`. Objek `hitung` yang merupakan subclass mewarisi method public ini.  
   - Nilai `x` tersimpan di dalam ruang memori instance objek `hitung` di heap memory. Meskipun disembunyikan (*private*), setiap instance objek `ClassB` tetap mengalokasikan memori untuk seluruh variabel instans yang didefinisikan oleh hierarki kelasnya (termasuk variabel `x` dari `ClassA`).

4. **Bandingkan Perbaikan A (protected) dan Perbaikan B (private + getter) dari sisi encapsulation. Mana yang Anda pilih untuk program sungguhan? Jelaskan alasannya.**  
   **Jawab:**  
   - **Perbaikan A (`protected`):** Atribut terbuka bagi subclass dan seluruh class lain yang berada dalam satu package yang sama. Enkapsulasinya lebih lemah karena integritas data rentan diubah langsung oleh class lain sekampung package tanpa validasi.  
   - **Perbaikan B (`private` + getter/setter):** Atribut tertutup sepenuhnya dari dunia luar, termasuk dari subclass. Akses hanya dimungkinkan melalui method getter/setter.  
   - **Pilihan untuk program sungguhan:** **Perbaikan B (`private` + getter/setter)**.  
   - **Alasan:** Menjamin integritas data tertinggi (*strict encapsulation* & *information hiding*). Memungkinkan penambahan logika validasi bisnis di dalam setter, mempermudah pelacakan error (*debugging*), dan meminimalkan dampak perubahan struktur internal (*loose coupling*).

5. **Andaikan ClassA dan ClassB berada di package yang berbeda. Berdasarkan tabel, apakah ClassB tetap dapat mengakses atribut protected milik ClassA? Bagaimana jika atributnya default (tanpa modifier)?**  
   **Jawab:**  
   - **Jika atribut `protected`:** **Ya, tetap dapat diakses**, karena salah satu karakteristik utama modifier `protected` adalah memberikan hak akses kepada subclass di luar package (beda package) melalui jalur pewarisan (*inheritance*).  
   - **Jika atribut `default` (tanpa modifier):** **Tidak dapat diakses**. Modifier default hanya dapat diakses oleh class-class yang berada dalam package yang sama. Di luar package, subclass sekalipun tidak dapat mengakses member berstatus default.

---

## Percobaan 3: Kata Kunci this dan super (Bangun dan Tabung)

### 1. Kode Program

#### `Bangun.java`
```java
public class Bangun {
    protected double phi;
    protected int r;
}
```

#### `Tabung.java` (Langkah 6 / Eksperimen 2 Lengkap)
```java
public class Tabung extends Bangun {
    protected int t;
    protected int r = 5;

    public void setSuperPhi(double phi) {
        super.phi = phi;
    }

    public void setSuperR(int r) {
        super.r = r;
    }

    public void setT(int t) {
        this.t = t;
    }

    public void volume() {
        System.out.println("Volume Tabung adalah: "
                + (super.phi * super.r * super.r * this.t));
    }

    public void cekR() {
        System.out.println("r = " + r);
        System.out.println("this.r = " + this.r);
        System.out.println("super.r = " + super.r);
    }
}
```

#### `MainPercobaan3.java`
```java
public class MainPercobaan3 {
    public static void main(String[] args) {
        Tabung tabung = new Tabung();
        tabung.setSuperPhi(3.14);
        tabung.setSuperR(10);
        tabung.setT(3);
        tabung.volume();
        tabung.cekR();
    }
}
```

### 2. Output Program

```text
Volume Tabung adalah: 942.0
r = 5
this.r = 5
super.r = 10
```

### 3. Pertanyaan Percobaan 3

1. **Jelaskan fungsi super pada super.phi = phi; dan super.r = r; di method setSuperPhi() dan setSuperR() milik Tabung.**  
   **Jawab:**  
   Kata kunci `super` merujuk secara eksplisit kepada member milik **superclass** (`Bangun`). Pada `super.phi = phi;`, `super.phi` memastikan bahwa nilai yang dimasukkan dari parameter method diarahkan dan disimpan ke atribut `phi` yang dideklarasikan pada superclass `Bangun`, membedakannya dari konteks lokal subclass.

2. **Jelaskan fungsi super dan this pada ekspresi super.phi * super.r * super.r * this.t di method volume().**  
   **Jawab:**  
   - `super.phi` dan `super.r` mengambil nilai atribut `phi` (3.14) dan `r` (10) dari superclass `Bangun`.  
   - `this.t` merujuk secara spesifik ke atribut `t` (3) yang dimiliki oleh class saat ini (`Tabung`).

3. **Mengapa Tabung tidak mendeklarasikan atribut phi dan r, tetapi tetap dapat mengaksesnya? Apa yang terjadi bila pada Bangun keduanya diubah menjadi private?**  
   **Jawab:**  
   - `Tabung` dapat mengaksesnya karena `Tabung extends Bangun`, dan kedua atribut tersebut diberi access modifier `protected` di `Bangun` sehingga otomatis diwariskan kepada subclass.  
   - Jika diubah menjadi `private`, maka class `Tabung` tidak akan dapat mengakses atribut tersebut secara langsung dan akan memicu error kompilasi (*private access error*), kecuali jika `Bangun` menyediakan method getter/setter berakses `public` atau `protected`.

4. **Pada Eksperimen 1, apakah output berubah ketika super.phi diganti this.phi? Jelaskan mengapa.**  
   **Jawab:**  
   - **Output tidak berubah** (tetap 942.0).  
   - **Alasan:** Class `Tabung` tidak mendeklarasikan ulang atribut bernama `phi` (tidak ada *variable shadowing* untuk `phi`). Ketika dievaluasi, Java mencari atribut `phi` pada class `Tabung`. Karena tidak ada di `Tabung`, Java mencarinya ke atas ke superclass `Bangun`. Sehingga, `this.phi` merujuk ke atribut yang sama persis dengan `super.phi`.

5. **Pada Eksperimen 2, mengapa r, this.r, dan super.r menghasilkan nilai yang berbeda? Pada kondisi apa awalan super. menjadi wajib dipakai?**  
   **Jawab:**  
   - **Penyebab:** Terjadi **shadowing / variable hiding**, di mana subclass `Tabung` mendeklarasikan atribut baru dengan nama yang sama persis: `protected int r = 5;`.  
     - `r` dan `this.r` merujuk ke atribut `r` milik `Tabung` yang bernilai `5`.  
     - `super.r` merujuk ke atribut `r` milik `Bangun` yang diisi nilai `10` lewat `setSuperR(10)`.  
   - **Kondisi awalan `super.` wajib dipakai:** Ketika terjadi penumpukan/shadowing nama atribut atau overriding method di subclass, dan kita secara khusus ingin mengakses versi asli milik superclass dari dalam subclass.

---

## Percobaan 4: Konstruktor dan Multilevel Inheritance (ClassA, ClassB, ClassC)

### 1. Kode Program

#### `ClassA.java`
```java
public class ClassA {
    ClassA() {
        System.out.println("konstruktor A dijalankan");
    }
}
```

#### `ClassB.java`
```java
public class ClassB extends ClassA {
    ClassB() {
        System.out.println("konstruktor B dijalankan");
    }
}
```

#### `ClassC.java` (Langkah 4 / Modifikasi 1)
```java
public class ClassC extends ClassB {
    ClassC() {
        super();
        System.out.println("konstruktor C dijalankan");
    }
}
```

#### `MainPercobaan4.java`
```java
public class MainPercobaan4 {
    public static void main(String[] args) {
        ClassC test = new ClassC();
    }
}
```

### 2. Output Program

#### A. Output Eksekusi Program (Langkah 3 dan Langkah 4):
```text
konstruktor A dijalankan
konstruktor B dijalankan
konstruktor C dijalankan
```

#### B. Error saat Langkah 5 (Modifikasi 2 - memindahkan `super()` ke baris kedua):
```text
id\ac\polinema\inheritance\percobaan4\ClassC.java:6: error: call to super must be first statement in constructor
        super();
             ^
1 error
```

### 3. Pertanyaan Percobaan 4

1. **Sebutkan class yang berperan sebagai superclass dan subclass pada percobaan ini beserta alasannya. Mengapa ClassB disebut berperan ganda?**  
   **Jawab:**  
   - `ClassA`: Superclass akar (*root*).  
   - `ClassB`: Subclass dari `ClassA`, sekaligus Superclass bagi `ClassC`.  
   - `ClassC`: Subclass dari `ClassB`.  
   - `ClassB` disebut **berperan ganda** karena dalam hierarki pewarisan bertingkat (*multilevel inheritance*), posisinya berada di tengah: ia mewarisi sifat dari kelas atasnya (`ClassA`) dan menurunkan sifat-sifat tersebut ke kelas bawahnya (`ClassC`).

2. **Program hanya membuat satu objek (new ClassC()), tetapi tiga baris tercetak. Jelaskan mengapa konstruktor ClassA dan ClassB ikut dijalankan.**  
   **Jawab:**  
   Dalam mekanisme pewarisan Java, konstruktor superclass **selalu dieksekusi terlebih dahulu sebelum konstruktor subclass**. Saat `new ClassC()` dipanggil, konstruktor `ClassC` memanggil `super()` (konstruktor `ClassB`). Konstruktor `ClassB` pun memanggil `super()` (konstruktor `ClassA`). Karena itu, seluruh konstruktor dalam rantai hierarki dijalankan secara berantai dari tingkat paling atas (`ClassA` -> `ClassB` -> `ClassC`).

3. **Pada Modifikasi 1, mengapa output tidak berbeda dari sebelumnya meskipun super(); ditambahkan secara eksplisit?**  
   **Jawab:**  
   Karena jika sebuah konstruktor subclass tidak menuliskan `super(...)` secara manual, compiler Java secara otomatis akan menambahkan instruksi `super();` tanpa argumen pada baris pertama. Oleh karena itu, penulisan `super();` secara eksplisit menghasilkan alur instruksi yang identik dengan perilaku default compiler.

4. **Pada Modifikasi 2 terjadi error. Aturan apa yang dilanggar, dan mengapa Java menetapkan aturan tersebut?**  
   **Jawab:**  
   - *Aturan yang dilanggar:* Pemanggilan konstruktor superclass (`super(...)` atau `super()`) **wajib menjadi pernyataan pertama (*first statement*)** di dalam tubuh konstruktor subclass.  
   - *Alasan aturan ditetapkan:* Untuk menjamin bahwa bagian superclass (dasar objek) telah selesai diinisialisasi secara sempurna sebelum subclass mulai mengeksekusi instruksi kodenya sendiri. Hal ini mencegah subclass mengakses atau memanipulasi *state* superclass yang belum siap (*uninitialized state*).

5. **Tuliskan urutan proses (bernomor) yang terjadi ketika new ClassC() dieksekusi, dimulai dari pemanggilan konstruktor ClassC hingga seluruh output tercetak.**  
   **Jawab:**  
   1. Alokasi memori heap untuk objek baru instance `ClassC`.  
   2. Konstruktor `ClassC()` dipanggil.  
   3. Pada baris pertama `ClassC()`, terjadi pemanggilan `super()` menuju konstruktor `ClassB()`.  
   4. Pada baris pertama `ClassB()`, terjadi pemanggilan `super()` menuju konstruktor `ClassA()`.  
   5. Pada baris pertama `ClassA()`, terjadi pemanggilan implisit ke konstruktor `java.lang.Object()`.  
   6. Konstruktor `Object` selesai diinisialisasi.  
   7. Tubuh konstruktor `ClassA()` dieksekusi: baris `System.out.println("konstruktor A dijalankan");` mencetak output pertama.  
   8. Eksekusi kembali ke konstruktor `ClassB()`: baris `System.out.println("konstruktor B dijalankan");` mencetak output kedua.  
   9. Eksekusi kembali ke konstruktor `ClassC()`: baris `System.out.println("konstruktor C dijalankan");` mencetak output ketiga.  
   10. Inisialisasi objek selesai dan alamat referensi objek `ClassC` disimpan ke variabel `test`.

---

## Percobaan 5: Konstruktor Berparameter dan Overriding (Komputer, Desktop, Laptop)

### 1. Kode Program

#### `Komputer.java`
```java
public class Komputer {
    protected String merk;
    protected int kapasitasMemory;
    protected int kecepatanCPU;

    public Komputer(String merk, int memory, int cpu) {
        this.merk = merk;
        this.kapasitasMemory = memory;
        this.kecepatanCPU = cpu;
    }

    public void showInfo() {
        System.out.println("Merk            : " + merk);
        System.out.println("Kapasitas Memory: " + kapasitasMemory + " MB");
        System.out.println("Kecepatan CPU   : " + kecepatanCPU + " MHz");
    }

    public void nyalakanKomputer() {
        System.out.println("Komputer " + merk + " dinyalakan");
    }
}
```

#### `Desktop.java`
```java
public class Desktop extends Komputer {
    protected String printer;

    public Desktop(String merk, int memory, int cpu, String printer) {
        super(merk, memory, cpu);
        this.printer = printer;
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("Printer         : " + printer);
    }
}
```

#### `Laptop.java`
```java
public class Laptop extends Komputer {
    protected int resolusiLayar;

    public Laptop(String merk, int memory, int cpu, int resolusi) {
        super(merk, memory, cpu);
        this.resolusiLayar = resolusi;
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("Resolusi Layar  : " + resolusiLayar + "p");
    }
}
```

#### `Workstation.java` (Jawaban Tantangan Soal Nomor 5)
```java
public class Workstation extends Desktop {
    protected String gpu;

    public Workstation(String merk, int memory, int cpu, String printer, String gpu) {
        super(merk, memory, cpu, printer);
        this.gpu = gpu;
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("GPU             : " + gpu);
    }
}
```

#### `MainPercobaan5.java`
```java
public class MainPercobaan5 {
    public static void main(String[] args) {
        Desktop desk = new Desktop("Dell", 2048, 3500, "Canon");
        Laptop lap = new Laptop("Asus", 4096, 2500, 720);

        desk.showInfo();
        System.out.println();
        lap.showInfo();
        System.out.println();
        desk.nyalakanKomputer();
    }
}
```

### 2. Output Program

```text
Merk            : Dell
Kapasitas Memory: 2048 MB
Kecepatan CPU   : 3500 MHz
Printer         : Canon

Merk            : Asus
Kapasitas Memory: 4096 MB
Kecepatan CPU   : 2500 MHz
Resolusi Layar  : 720p

Komputer Dell dinyalakan
```

### 3. Pertanyaan Percobaan 5

1. **Jelaskan fungsi super(merk, memory, cpu) pada konstruktor Desktop. Atribut apa saja yang diisi oleh baris tersebut, dan atribut apa yang diisi oleh baris berikutnya?**  
   **Jawab:**  
   - *Fungsi:* Memanggil konstruktor milik superclass (`Komputer`) untuk meneruskan argumen inisialisasi pada atribut warisan.  
   - *Atribut yang diisi oleh `super(...)`:*  
     1. `merk` diisi dengan nilai `merk`  
     2. `kapasitasMemory` diisi dengan nilai `memory`  
     3. `kecepatanCPU` diisi dengan nilai `cpu`  
   - *Atribut yang diisi baris berikutnya (`this.printer = printer;`):* Atribut spesifik `printer` milik subclass `Desktop`.

2. **Pada Eksperimen 1, mengapa error muncul di sini, padahal pada Percobaan 4 super() juga tidak ditulis tetapi program tetap berjalan?**  
   **Jawab:**  
   - Pada Percobaan 4, superclass memiliki konstruktor default tanpa parameter (disediakan compiler secara gratis), sehingga saat `super()` tidak ditulis, compiler otomatis menyisipkan `super();` tanpa argumen dan berhasil menemukan konstruktor yang cocok.  
   - Pada Percobaan 5, superclass `Komputer` **hanya mendefinisikan satu konstruktor berparameter 3 argumen** dan tidak memiliki konstruktor default tanpa parameter. Jika `super(...)` dihapus, compiler menyisipkan panggilan `super();` tanpa argumen yang tidak ada di `Komputer`, menghasilkan error: `constructor Komputer in class Komputer cannot be applied to given types; required: String,int,int; found: no arguments`.

3. **Method showInfo() ditulis di Komputer sekaligus di Desktop. Apa istilah untuk kondisi ini? Apa yang tercetak bila baris super.showInfo(); pada Desktop dihapus?**  
   **Jawab:**  
   - *Istilah:* **Method Overriding** (penimpaan method superclass oleh subclass dengan nama, parameter, dan return type yang identik).  
   - *Jika `super.showInfo();` dihapus:* Baris informasi dari superclass tidak akan dipanggil, sehingga yang tercetak pada `desk.showInfo()` hanyalah:  
     ```text
     Printer         : Canon
     ```

4. **Pada Eksperimen 2, jelaskan perbedaan hasil kompilasi dengan dan tanpa @Override. Apa manfaat menuliskan @Override?**  
   **Jawab:**  
   - **Dengan `@Override`:** Saat nama method salah ketik (misal `showinfo()`), compiler langsung menolak kompilasi dan memunculkan error: `method does not override or implement a method from a supertype`.  
   - **Tanpa `@Override`:** Kompilasi berhasil (*lolos*), namun compiler menganggap `showinfo()` sebagai method baru. Saat pemanggilan `desk.showInfo()`, yang berjalan justru method lama milik superclass, dan method subclass tidak pernah terpanggil (*silent bug*).  
   - **Manfaat menulis `@Override`:** Memberikan jaminan keamanan saat tahap kompilasi (*compile-time safety check*) untuk memastikan bahwa method yang kita buat benar-benar menimpa method superclass yang valid.

5. **Tantangan. Buat class Workstation sebagai turunan Desktop dengan atribut gpu (String). Class ini harus menimpa showInfo() sehingga menampilkan seluruh informasi Desktop ditambah baris GPU. Ketika new Workstation(...) dibuat, konstruktor class apa saja yang terpanggil, dan dalam urutan apa?**  
   **Jawab:**  
   - Kode class `Workstation` telah diimplementasikan (lihat kode di atas).  
   - **Urutan konstruktor yang terpanggil:**  
     1. Konstruktor `Komputer(String, int, int)`  
     2. Konstruktor `Desktop(String, int, int, String)`  
     3. Konstruktor `Workstation(String, int, int, String, String)`

---

## Tugas 1: Pegawai, Dosen, dan DaftarGaji

### 1. Diagram Kelas & Kebutuhan
- `Dosen` mewarisi `Pegawai` (`extends Pegawai`).
- `DaftarGaji` memiliki kumpulan `Pegawai` dalam array (relasi Agregasi).
- Gaji Pegawai pokok tetap: Rp1.500.000.
- Gaji Dosen: Gaji pokok Pegawai + (`jumlahSKS` × `TARIF_SKS` [100.000]).
- Method `getGaji()` pada Dosen menggunakan `@Override` dan memanfaatkan `super.getGaji()`.

### 2. Kode Program

#### `Pegawai.java`
```java
public class Pegawai {
    protected String nip;
    protected String nama;
    protected String alamat;

    public Pegawai(String nip, String nama, String alamat) {
        this.nip = nip;
        this.nama = nama;
        this.alamat = alamat;
    }

    public String getNama() {
        return nama;
    }

    public int getGaji() {
        return 1500000;
    }
}
```

#### `Dosen.java`
```java
public class Dosen extends Pegawai {
    protected int jumlahSKS;
    protected static final int TARIF_SKS = 100000;

    public Dosen(String nip, String nama, String alamat) {
        super(nip, nama, alamat);
    }

    public void setSKS(int jumlahSKS) {
        this.jumlahSKS = jumlahSKS;
    }

    @Override
    public int getGaji() {
        return super.getGaji() + (this.jumlahSKS * TARIF_SKS);
    }
}
```

#### `DaftarGaji.java`
```java
public class DaftarGaji {
    private Pegawai[] listPegawai;
    private int jumlah;

    public DaftarGaji(int kapasitas) {
        this.listPegawai = new Pegawai[kapasitas];
        this.jumlah = 0;
    }

    public void addPegawai(Pegawai p) {
        if (jumlah < listPegawai.length) {
            listPegawai[jumlah] = p;
            jumlah++;
        } else {
            System.out.println("Daftar gaji sudah penuh!");
        }
    }

    public void printSemuaGaji() {
        for (int i = 0; i < jumlah; i++) {
            System.out.println(listPegawai[i].getNama() + " : " + listPegawai[i].getGaji());
        }
    }
}
```

#### `MainTugas1.java`
```java
public class MainTugas1 {
    public static void main(String[] args) {
        Pegawai p1 = new Pegawai("P001", "Budi", "Malang");
        Dosen d1 = new Dosen("D001", "Siti", "Surabaya");
        d1.setSKS(12);

        DaftarGaji daftar = new DaftarGaji(10);
        daftar.addPegawai(p1);
        daftar.addPegawai(d1);

        daftar.printSemuaGaji();
    }
}
```

### 3. Output Program
```text
Budi : 1500000
Siti : 2700000
```

### 4. Pertanyaan Analisis Tugas 1

(a) **Array Pegawai[] dapat menampung objek Dosen. Mengapa hal itu diperbolehkan?**  
**Jawab:**  
Hal tersebut diperbolehkan karena prinsip dasar **Polimorfisme** dan hubungan **is-a (Inheritance)**. Karena class `Dosen` diturunkan dari class `Pegawai` (`public class Dosen extends Pegawai`), maka setiap instance dari `Dosen` secara konseptual dan tipe data adalah seorang `Pegawai`. Di Java, variabel bertipe superclass (termasuk elemen array `Pegawai[]`) dapat menampung referensi objek dari kelas turunannya (*upcasting*).

(b) **Ketika printSemuaGaji() memanggil getGaji() pada objek Dosen, versi method milik class mana yang dijalankan?**  
**Jawab:**  
Versi method milik class **`Dosen`** yang dijalankan. Hal ini terjadi karena Java menerapkan mekanisme **Dynamic Method Dispatch** (*runtime polymorphism* / *late binding*). Meskipun tipe referensi array adalah `Pegawai`, JVM memeriksa objek riil yang berada di memori heap saat program berjalan. Karena objek kedua adalah instance dari `Dosen`, maka method `getGaji()` yang telah di-*override* pada class `Dosen` yang dieksekusi (menghasilkan perhitungan 1.500.000 + 12 × 100.000 = 2.700.000).

---

## Tugas 2: Televisi dan TelevisiModern

### 1. Diagram Kelas & Kebutuhan
- `TelevisiModern` mewarisi `Televisi` (`extends Televisi`).
- Atribut `channelAktif` berstatus `private` di class `Televisi`. Nilai awal adalah 1.
- `pindahChannel(int channel)` hanya mengubah `channelAktif` apabila nilainya berada dalam rentang `1` sampai `jumlahChannel`.
- `mainkanDVD()` mencetak `Sedang memainkan DVD: ` diikuti judul DVD (default judul awal adalah `kosong`).
- Konstruktor `TelevisiModern` memanggil konstruktor superclass dengan `super(merek, jumlahChannel)`.

### 2. Kode Program

#### `Televisi.java`
```java
public class Televisi {
    public String merek;
    public int jumlahChannel;
    private int channelAktif;

    public Televisi(String merek, int jumlahChannel) {
        this.merek = merek;
        this.jumlahChannel = jumlahChannel;
        this.channelAktif = 1;
    }

    public void pindahChannel(int channel) {
        if (channel >= 1 && channel <= jumlahChannel) {
            this.channelAktif = channel;
        }
    }

    public int getChannelAktif() {
        return channelAktif;
    }
}
```

#### `TelevisiModern.java`
```java
public class TelevisiModern extends Televisi {
    private String modusTampilan;
    private String dvd;

    public TelevisiModern(String merek, int jumlahChannel) {
        super(merek, jumlahChannel);
        this.dvd = "kosong";
    }

    public void gantiModusTampilan(String mode) {
        this.modusTampilan = mode;
    }

    public void masukkanDVD(String judul) {
        this.dvd = judul;
    }

    public void mainkanDVD() {
        System.out.println("Sedang memainkan DVD: " + dvd);
    }
}
```

#### `MainTugas2.java`
```java
public class MainTugas2 {
    public static void main(String[] args) {
        TelevisiModern tv = new TelevisiModern("Samsung", 100);
        System.out.println("Channel aktif: " + tv.getChannelAktif());
        tv.pindahChannel(20);
        System.out.println("Channel aktif sekarang: "
                + tv.getChannelAktif());
        tv.gantiModusTampilan("HDMI");
        tv.mainkanDVD();
        tv.masukkanDVD("The Matrix");
        tv.mainkanDVD();

        // Uji tambahan
        tv.pindahChannel(150);
        System.out.println("Channel aktif setelah pindahChannel(150): " + tv.getChannelAktif());
    }
}
```

### 3. Output Program
```text
Channel aktif: 1
Channel aktif sekarang: 20
Sedang memainkan DVD: kosong
Sedang memainkan DVD: The Matrix
Channel aktif setelah pindahChannel(150): 20
```

### 4. Jawaban Uji Tambahan Tugas 2
- **Pertanyaan:** Panggil `tv.pindahChannel(150)` lalu cetak channel aktif. Tuliskan hasilnya dan jelaskan mengapa `channelAktif` tidak dapat diubah langsung dari `MainTugas2`.  
- **Jawab:**  
  - *Hasil output:* Nilai channel aktif tetap `20` (tidak berubah ke `150`).  
  - *Penjelasan:*  
    1. Method `pindahChannel(int channel)` memiliki proteksi logika `if (channel >= 1 && channel <= jumlahChannel)`. Karena total channel adalah 100, nilai input 150 berada di luar rentang valid (1 - 100), sehingga pembaruan channel diabaikan.  
    2. Atribut `channelAktif` dideklarasikan dengan access modifier `private` di class `Televisi`. Penerapan enkapsulasi ini melarang akses baca/tulis langsung dari luar class (baik dari class `MainTugas2` maupun dari subclass `TelevisiModern`). Seluruh modifikasi wajib melalui method `pindahChannel()` yang memiliki validasi batas, sehingga objek terbebas dari inkonsistensi atau data yang tidak valid.

---

## Tugas 3 (Opsional, Pengayaan): Karakter Game

### 1. Deskripsi Hierarki & Perilaku
- `Character` (superclass): atribut `name`, `level`, `health`. Method `attack(target)` mengurangi health target sebesar 10, dan `showStatus()` menampilkan status karakter.
- `Angel` (subclass): atribut `potion`. Method `cure(target)` mengembalikan health target menjadi 100 dan mengurangi `potion` sebanyak 1.
- `Human` (subclass): atribut `strength`. Method `specialAttack(target)` mengurangi health target sebesar 10 + `strength`.
- `Wizard` (subclass): atribut `spell`. Method `magic(target)` mengurangi health target sebesar 50 dan mengurangi `spell` sebanyak 1.

### 2. Kode Program

#### `Character.java`
```java
public class Character {
    protected String name;
    protected int level;
    protected int health;

    public Character(String name, int level, int health) {
        this.name = name;
        this.level = level;
        this.health = health;
    }

    public void attack(Character target) {
        target.health -= 10;
    }

    public void showStatus() {
        System.out.println("Name: " + name + " | Level: " + level + " | Health: " + health);
    }
}
```

#### `Angel.java`
```java
public class Angel extends Character {
    protected int potion;

    public Angel(String name, int level, int health, int potion) {
        super(name, level, health);
        this.potion = potion;
    }

    public void cure(Character target) {
        target.health = 100;
        this.potion--;
    }
}
```

#### `Human.java`
```java
public class Human extends Character {
    protected int strength;

    public Human(String name, int level, int health, int strength) {
        super(name, level, health);
        this.strength = strength;
    }

    public void specialAttack(Character target) {
        target.health -= (10 + this.strength);
    }
}
```

#### `Wizard.java`
```java
public class Wizard extends Character {
    protected int spell;

    public Wizard(String name, int level, int health, int spell) {
        super(name, level, health);
        this.spell = spell;
    }

    public void magic(Character target) {
        target.health -= 50;
        this.spell--;
    }
}
```

#### `MainTugas3.java`
```java
public class MainTugas3 {
    public static void main(String[] args) {
        Angel esther = new Angel("Esther", 10, 100, 5);
        Human jackal = new Human("Jackal", 13, 100, 7);
        Wizard quistis = new Wizard("Quistis", 20, 100, 3);

        System.out.println("Begin game...");
        esther.showStatus();
        jackal.showStatus();
        quistis.showStatus();

        System.out.println("Jackal special attack to quistis, "
                + "quistis cast magic to jackal,");
        System.out.println("esther cure jackal, quistis attack esther...");
        jackal.specialAttack(quistis);
        quistis.magic(jackal);
        esther.cure(jackal);
        quistis.attack(esther);

        esther.showStatus();
        jackal.showStatus();
        quistis.showStatus();
    }
}
```

### 3. Output Program
```text
Begin game...
Name: Esther | Level: 10 | Health: 100
Name: Jackal | Level: 13 | Health: 100
Name: Quistis | Level: 20 | Health: 100
Jackal special attack to quistis, quistis cast magic to jackal,
esther cure jackal, quistis attack esther...
Name: Esther | Level: 10 | Health: 90
Name: Jackal | Level: 13 | Health: 100
Name: Quistis | Level: 20 | Health: 83
```

---

## Tugas 4: Jawab Singkat

1. **Jelaskan dengan bahasa Anda sendiri perbedaan hubungan is-a (inheritance) dan has-a (aggregation/composition), lalu beri satu contoh masing-masing dari jobsheet ini.**  
   **Jawab:**  
   - **Hubungan *is-a* (*Inheritance* / Pewarisan):** Menggambarkan hubungan taksonomi atau klasifikasi di mana suatu subclass merupakan bentuk khusus dari superclass. Subclass otomatis mewarisi sifat dan perilaku umum superclass dan dapat menambahkan sifat khususnya sendiri.  
     *Contoh pada jobsheet ini:* `Dosen` adalah seorang `Pegawai` (`class Dosen extends Pegawai`), dan `Laptop` adalah sebuah `Komputer` (`class Laptop extends Komputer`).  
   - **Hubungan *has-a* (*Aggregation/Composition* / Kepemilikan):** Menggambarkan relasi di mana suatu class memiliki atau menggunakan objek dari class lain sebagai atribut/komponen penyusunnya tanpa mewarisi class tersebut.  
     *Contoh pada jobsheet ini:* `DaftarGaji` memiliki kumpulan objek `Pegawai` (`private Pegawai[] listPegawai;` di class `DaftarGaji`).

2. **Ringkas aturan pewarisan untuk tiga hal berikut dalam 3–5 kalimat: member private, member protected, dan konstruktor.**  
   **Jawab:**  
   Member bertipe `private` pada superclass tidak diwariskan ke subclass dan tidak dapat diakses langsung oleh subclass, sehingga memerlukan method getter/setter berakses publik atau protected. Sebaliknya, member bertipe `protected` diwariskan secara penuh dan dapat diakses langsung oleh subclass meskipun subclass tersebut berada pada package yang berbeda. Sementara itu, konstruktor tidak pernah diwariskan kepada subclass, namun konstruktor superclass wajib selalu dipanggil (baik secara otomatis oleh compiler maupun secara eksplisit menggunakan `super(...)` pada baris pertama tubuh konstruktor subclass) guna menginisialisasi keadaan dasar superclass sebelum objek subclass selesai dibangun.