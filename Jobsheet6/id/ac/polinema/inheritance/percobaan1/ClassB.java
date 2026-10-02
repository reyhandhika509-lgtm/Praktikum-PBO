package Jobsheet6.id.ac.polinema.inheritance.percobaan1;

public class ClassB extends ClassA {
    public int z;

    public void getNilaiZ(){
        System.out.println("Nilai z: " + z);
    }

    public void getJumlah(){
        System.out.println("Jumlah: " + (x + y+ z));
    }
}
