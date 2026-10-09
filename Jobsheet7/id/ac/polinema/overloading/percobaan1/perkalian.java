package Jobsheet7.id.ac.polinema.overloading.percobaan1;

public class perkalian {
    public int kali(int a, int b){
        return a*b;
    }
    public int kali(int a, int b, int c){
        return a * b * c;
    }
     public double kali(double a, double b){
        return a * b;
    }
    public void tampilkan(int nomor, String label) {
        System.out.println(nomor + ". " + label);
    }
    public void tampilkan(String label, int nomor) {
        System.out.println(label + " #" + nomor);
    }
}
