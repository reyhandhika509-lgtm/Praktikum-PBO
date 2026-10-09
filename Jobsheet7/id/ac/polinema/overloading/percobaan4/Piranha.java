package Jobsheet7.id.ac.polinema.overloading.percobaan4;

public class Piranha extends Ikan {
    @Override
    public void swim() {
    super.swim();
    System.out.println("Piranha bisa makan daging");
    }

    @Override
    public Piranha beranak() {
    return new Piranha();
     }
}
