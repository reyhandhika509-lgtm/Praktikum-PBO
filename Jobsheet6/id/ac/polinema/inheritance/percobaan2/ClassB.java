package Jobsheet6.id.ac.polinema.inheritance.percobaan2;

public class ClassB extends ClassA {
    private int z;

    public void setZ(int z){
        this.z = z;
    }
    public void getNilaiZ(){
        System.out.println("Nilai z: " + z);
    }
    public void getJumlah(){
        System.out.println("Jumlah: " + (getX() + getY() + z));
    }
}
