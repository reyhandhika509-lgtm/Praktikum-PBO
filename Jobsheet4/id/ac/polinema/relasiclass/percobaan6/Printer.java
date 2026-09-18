package Jobsheet4.id.ac.polinema.relasiclass.percobaan6;

public class Printer {
    private String merek;

    public Printer(String merek){
        this.merek = merek;
    }

    public void cetak(String namaFile){
        System.out.println("[" + merek + "] Mencetak " + namaFile + "...");
        System.out.println("[" + merek + "] Selesai.");
    }
}
