package Jobsheet7.id.ac.polinema.overloading.percobaan2;

public class Resolusi {
    public static void tampil(long x) {
        System.out.println("Tampil(long)    : " + x);
    }

    public static  void tampil(Integer x){
        System.out.println("tampil(Integer) : " + x);
    }
    public static  void tampil(Object x){
        System.out.println("tampil(Object)  : " + x);
    }
     public static  void tampil(int... x){
        System.out.println("tampil(int...)  : " + x.length + "elemen");
    }
}
