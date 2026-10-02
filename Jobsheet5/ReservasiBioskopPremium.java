package Jobsheet5;
// Nama Reyhandhika Zikri Prijadi
// Kelas 2G
// Nim 254107020219
public class ReservasiBioskopPremium {
    public static void main(String[] args) {
        Studio m = new Studio();
        m.SetJudulFilm("Spongbob");
        m.setTarif(40000);

        Operator o =new Operator();
        o.setNama("Saiful");
        o.SetBiayaLayanan(2000000);

        Reservasi r = new Reservasi();
        r.setNama("Anwar");
        r.setStudio(m);
        r.setOperator(o);
        r.setJam(2);
        
        System.out.println("Nama Pemesan: " + r.getNama());
        System.out.println("Nama Film : " + m.getjudul());
        System.out.println("Nama Operator : " +o.getNama());
        System.out.println("Biaya Total Tiket = " +r.hitungBiayaTotal());
    }
    
}
