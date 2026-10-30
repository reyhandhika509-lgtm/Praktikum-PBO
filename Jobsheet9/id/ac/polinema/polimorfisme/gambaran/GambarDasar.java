package Jobsheet9.id.ac.polinema.polimorfisme.gambaran;

public class GambarDasar {
    interface Vagetarian {}
    static  class Animal {}
    static  class Deer extends Animal implements Vagetarian {}
    static  class Lion extends  Animal {}

    public static void main(String[] args) {
        Deer d = new Deer();
        Lion l = new  Lion();

        Animal a = d;
        Animal a2 = l;
        Vagetarian v = d;


        System.out.println("a menunjuk objek " + a.getClass().getSimpleName());
        System.out.println("a2 menunjuk objek " + a2.getClass().getSimpleName());
        System.out.println("v menunjuk objek " + v.getClass().getSimpleName());
    }
        
    
    
}
