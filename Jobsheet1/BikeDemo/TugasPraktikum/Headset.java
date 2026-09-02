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

