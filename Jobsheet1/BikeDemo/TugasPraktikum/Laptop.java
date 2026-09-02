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

    

