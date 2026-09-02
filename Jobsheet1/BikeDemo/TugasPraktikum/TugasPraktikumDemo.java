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
    

