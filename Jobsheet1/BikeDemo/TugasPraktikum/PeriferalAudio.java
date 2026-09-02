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
