package Jobsheet6.id.ac.polinema.inheritance.tugas2;

public class TelevisiModern extends Televisi{
    private String modeTampilan;
    private String dvd;

    public TelevisiModern(String merek, int jumlahChannel) {
        super(merek, jumlahChannel);
        this.dvd = "kosong";
    }

    public void gantiModusTampilan(String mode) {
        this.modeTampilan = mode;
    }

    public void masukkanDVD(String judul) {
        this.dvd = judul;
    }

    public void mainkanDVD() {
        System.out.println("Sedang memainkan DVD: " + dvd);
    }
}
