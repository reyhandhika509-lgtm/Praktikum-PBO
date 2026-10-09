package Jobsheet7.id.ac.polinema.overloading.percobaan1;

public class MainPercobaan1 {
    public static void main(String[] args) {
        perkalian p = new perkalian();
        System.out.println("kali(25, 43) = " + p.kali(25, 43));
        System.out.println("kali(34, 23, 56) = " + p.kali(34, 23, 56));
        System.out.println("kali(25.5, 4.0) = " + p.kali(25.5, 4.0));

        p.tampilkan(1, "perkalian");
        p.tampilkan("perkalian", 1);
    }
    
}
