package Jobsheet6.id.ac.polinema.inheritance.percobaan5;

public class Laptop extends Komputer {

    protected  int resolusiLayar;

    public Laptop(String merk, int Memory, int cpu, int resolusi){
        super(merk, Memory, cpu);
        this.resolusiLayar = resolusi;
    }
    @Override 
    public void showInfo(){
        super.showInfo();
        System.out.println("Resolusi layar : " + resolusiLayar + "p");
    }
}
