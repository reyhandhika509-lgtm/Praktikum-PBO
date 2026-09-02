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

