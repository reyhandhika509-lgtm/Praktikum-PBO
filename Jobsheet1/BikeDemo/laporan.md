# laporan Praktikum Pemograman Berbasis Objek 1

<h4>Nama    : Reyhandhika Zikri Prijadi<h4>
<h4>Nim     : 254107020219<h4>
<h4>Kelas   : TI-1G<h4>

## Code Bike.java
```bash
package Jobsheet1.BikeDemo;
public class Bike {
    private String brand;
    private int speed;
    private int gear = 1;
    // Gear 1: max 5 km/h, Gear 2: max 10 km/h, ... Gear 6: max 60 km/h
    private final int[] GEAR_SPEED_LIMITS = { 5, 10, 25, 30, 40, 60 };

    public void setBrand(String brandName) {
        brand = brandName;
    }

    public void gearChanges(int gearValue) {
        if (gearValue < 1 || gearValue > 6) {
            System.out.println("Invalid gear value. Gear must be between 1 and 6.");
        } else {
            gear = gearValue;
        }
    }
    public int speedAcceleration (int increment){
        speed += increment;
        if (speed > GEAR_SPEED_LIMITS[gear - 1]){
            speed = GEAR_SPEED_LIMITS[gear - 1];
        }
        return speed;
    }
    public int speedDeceleration(int decrement) {
        speed -= decrement;
        if (speed< 0){
            speed = 0;
        }
        return speed;
    }
    public void printInfo(){
        System.out.println("Brand : " + brand);
        System.out.println("Speed : " + speed);
        System.out.println("Gear : " + gear);
    }
}


```
## Code BikeDemo.java
```bash
package Jobsheet1.BikeDemo;
public class BikeDemo {
   
    public static void main(String[] args) {
        Bike mountainBike1 = new Bike();
        Bike mountainBike2 = new Bike();
        RoadBike roadBike1 = new RoadBike(); 

        mountainBike1.setBrand("Trek");
        mountainBike1.speedAcceleration(10);
        mountainBike1.gearChanges(2);
        mountainBike1.printInfo();

        mountainBike2.setBrand("Giant");
        mountainBike2.speedAcceleration(20);
        mountainBike2.gearChanges(3);
        mountainBike2.printInfo();

        roadBike1.setBrand("Specialized");
        roadBike1.setTireWidth(25);
        roadBike1.speedAcceleration(15);
        roadBike1.gearChanges(4);
        roadBike1.printInfo();
    }
}
    

```
## Code RoadBike.java
```bash
package Jobsheet1.BikeDemo;

public class RoadBike extends Bike {

    private int tireWidth;

    public void setTireWidth(int width){
        tireWidth = width;
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("Tire Width : " + tireWidth + " mm");
        System.out.println("Bike Type  : Road Bike");
    }
}

```
## Hasil
![alt text](Jobsheet1/BikeDemo/image/hasilPraktek.png)
## 5 Pertanyaan

### 1. Jelaskan perbedaan antara object dengan class!
Class adalah blueprint atau rancangan yang digunakan untuk membuat objek sedangkan objek adalah hasil nyatadari sebuah class yang  dibuat saat program jalan

### 2. Jelaskan alasan gear dan brand dapat menjadi atribut dari object Bike!
Atribut brand digunakan untuk menyimpan informasi mengenai merek sepeda, misalnya Polygon, United, atau Trek. Sedangkan gear digunakan untuk menyimpan informasi mengenai gigi yang digunakan atau dimiliki oleh sepeda.

### 3. Sebutkan salah satu kelebihan utama dari pemrograman berorientasi objek dibandingkan dengan pemrograman prosedural!
Dalam OOP terdapat konsep seperti inheritance (pewarisan) yang memungkinkan sebuah class mewarisi atribut dan method dari class lain. Dengan begitu, programmer tidak perlu menuliskan kembali kode yang sudah dibuat sebelumnya.

### 4. Apakah diperbolehkan melakukan pendefinisian dua buah atribut dalam satu baris kode seperti “public String nama, alamat;”?
Ya, diperbolehkan dalam Java, selama atribut yang didefinisikan mempunyai tipe data yang sama. 
### 5. Pada class RoadBike, jelaskan alasan atribut brand, speed, dan gear tidak lagi ditulis di dalam class terse
RoadBike mewarisi atribut dan method yang dimiliki oleh Bike. Oleh karena itu, brand, speed, dan gear tetap dapat digunakan oleh RoadBike meskipun atribut tersebut tidak dituliskan kembali di dalam class RoadBike. Konsep ini disebut inheritance atau pewarisan. Tujuan dari inheritance salah satunya adalah supaya kita tidak perlu menulis kode yang sama berulang kali. RoadBike cukup mewarisi sifat-sifat umum dari Bike, kemudian jika diperlukan dapat ditambahkan atribut atau method khusus yang hanya dimiliki oleh RoadBi

## 6. Tugas Praktikum
### 1. Lakukan langkah-langkah berikut supaya tugas praktikum yang dikerjakan tersistematis:

#### a. Foto 4 buah objek di sekitar kalian dengan 2 objek di antaranya merupakan objek yang mengandung konsep pewarisan (inheritance), contoh: kulkas, kursi, meja ruang tamu, meja belajar sehingga diketahui meja ruang tamu dan meja belajar mewarisi objek meja!

b. Lakukan pengamatan terhadap 4 objek tersebut untuk menentukan atribut dan methodnya!
c. Berdasarkan 4 buah objek tersebut, buat class nya dalam Bahasa pemrograman Java!
d. Perlu diperhatikan bahwa terdapat dua class hasil pewarisan sehingga perlu menambah satu
class baru sebagai class yang mewarisi dua class tersebut!
e. Tambahkan dua atribut untuk setiap class!
f. Tambahkan tiga method untuk setiap class termasuk method cetak informasi!
g. Tambahkan satu class Demo sebagai main!
h. Instansiasikan satu buah objek untuk setiap class!
i. Terapkan setiap method untuk setiap objek yang dibuat!
j. Contoh yang telah disebutkan pada poin 1.a tidak diperbolehkan dipakai dalam pengerjaan
tugas praktikum ini!

# Jawaban:

### Objek yang saya ambil: 

![alt text](Jobsheet1/BikeDemo/image/Earphone.png) 
### 1. Earphone
![alt text](Jobsheet1/BikeDemo/image/headset.png)
### 2. Headset
![alt text](Jobsheet1/BikeDemo/image/Laptop.jpeg)
### 3. Laptop
![alt text](Jobsheet1/BikeDemo/image/Mouse.jpeg)
### 4. Mouse
## Code PeriferalAudio.java
```bash

package Jobsheet1.BikeDemo.TugasPraktikum;

public class PeriferalAudio {
    private String brand;
    private String JenisKoneksi;
    private double harga;

    void setBrand(String brand){
        this.brand = brand;
    }
    
    void setKonektion(String koneksi){
        JenisKoneksi = koneksi;
    }
    
    void setHarga(double harga){
        this.harga= harga;
    }
    
    void print(){
        System.out.println("Brand: " + brand);
        System.out.println("Jenis Koneksi: " + JenisKoneksi);
        System.out.println("HArga: " + harga);
    }
}

```

## Code Headset.java
```bash
package Jobsheet1.BikeDemo.TugasPraktikum;

public class Headset extends PeriferalAudio{
    private double tinggiFoam, lebarFoam, total;
    private boolean speedCharge;

    void setUkuran(double tinggi, double lebar){
        tinggiFoam = tinggi;
        lebarFoam = lebar;
        total = tinggiFoam + lebarFoam;

    }
    void setCharge(boolean status){
        speedCharge = status;
    }
    void checkLuas(){
          if (total > 25) {
            System.out.println("Ukuran foam hedset besar");
        }else if (total > 10) {
            System.out.println("Ukuran foam hedset sedang");
        } else {
            System.out.println("Ukuran foam hedset kecil");
        }
    }

    String speedChargeStatus(){
        String status;
        if (speedCharge) {
            status = "Ada";
        }else{
            status = "Tidak ada";
        }
        return status;
    }
    
    @Override
    void print() {
        super.print();
        System.out.println("Luas Foam: " + total + " cm^2");
        System.out.println("Speed Charge: " + speedChargeStatus());
    }
}
```
## Code Earphone.java

```bash
package Jobsheet1.BikeDemo.TugasPraktikum;

public class Earphone extends PeriferalAudio {
    private boolean ANC;

    void ANCstatus(boolean ActiveNoiseCancellation){
        ANC = ActiveNoiseCancellation;
    }

    String cancellation(){
        String status;
        if (ANC) {
            status = "Ada";
        }else{
            status = "Tidak ada";
        }
        return status;
    }

    void menyalakan(){
        System.out.println("ANC " + ANC + " sedang dinyalakan");
    }

    void mematikan(){
        System.out.println("ANC " + ANC + " sedang dimatikan");
    }

    @Override
    void print() {
        super.print();
        System.out.println("ANC: " + cancellation());
    }
}
```    
## Code Laptop.java
```bash
package Jobsheet1.BikeDemo.TugasPraktikum;

public class Laptop {
    private String brand;
    private String cpu;
    private int ram;

    Laptop(String brand, String cpu, int ram){
        this.brand = brand;
        this.cpu = cpu;
        this.ram = ram;
    }

    void menyalakan(){
        System.out.println("Laptop " + brand + " sedang dinyalakan");
    }

    void mematikan(){
        System.out.println("Laptop " + brand + " sedang dimatikan");
    }

    int menghitungRam(int jumlahRam){
        return ram * jumlahRam;
    }

    void print(){
        System.out.println("Brand: " + brand);
        System.out.println("CPU: " + cpu);
        System.out.println("Total RAM: " + ram);
    }
}

``` 
## Code Mouse.java
```bash
package Jobsheet1.BikeDemo.TugasPraktikum;

public class Mouse {
    private String brand;
    private String sensor;
    private double baterai;
    private float berat;

    Mouse(String brand, String sensor, double baterai, float berat){
        this.brand = brand;
        this.sensor = sensor;
        this.baterai = baterai;
        this.berat = berat;
    }

    double batteryCheck(double arus){
        return baterai/arus;
    }

    void menyalakan(){
        System.out.println("Mouse " + brand + " sedang dinyalakan");
    }

    void mematikan(){
        System.out.println("Mouse " + brand + " sedang dimatikan");
    }

    void clickMe(){
        System.out.println("Anda mengeklik mouse " + brand);
    }

    void print(){
        System.out.println("Brand: " + brand);
        System.out.println("Sensor: " + sensor);
        System.out.println("Berat: " + berat + " gram");
    }
}
```
## Code TugasPraktikumDemo.java
```bash
package Jobsheet1.BikeDemo.TugasPraktikum;

public class TugasPraktikumDemo {

     public static void main(String[] args) {
        Laptop laptop = new Laptop("Aspire Lite 14", "i5-1334u", 8);

        Mouse mouse = new Mouse("VXE R1 SE+", "PAW3395 SE", 520, 48);

        Earphone earphone = new Earphone();

        Headset headphone = new Headset();

        earphone.setBrand("Space Travel");
        earphone.setHarga(271000);
        earphone.setKonektion("Wireless");
        earphone.ANCstatus(true);
        earphone.mematikan();
        earphone.menyalakan();
        earphone.print();

        System.out.println("");

        headphone.setBrand("JBL Club One");
        headphone.setHarga(6999000);
        headphone.setKonektion("Wireless");
        headphone.setUkuran(4.6, 6);
        headphone.setCharge(true);
        headphone.checkLuas();
        headphone.print();

        System.out.println("");

        laptop.mematikan();
        laptop.menyalakan();
        System.out.println("Total Ram: " + laptop.menghitungRam(2));
        laptop.print();

        System.out.println("");

        mouse.mematikan();
        mouse.menyalakan();
        mouse.clickMe();
        System.out.println("Waktu Penggunaan: " + mouse.batteryCheck(7.43));
        mouse.print();
    }
}
    
```

## Hasil
![alt text](Jobsheet1/BikeDemo/image/HasilTugasPraktek.png)