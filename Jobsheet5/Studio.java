package Jobsheet5;
// Nama Reyhandhika Zikri Prijadi
// Kelas 2G
// Nim 254107020219
public class Studio {
    private String judul;
    private int tarif;

    public Studio(){
    }
    public void SetJudulFilm(String judul){
        this.judul = judul;
    }
    public String getjudul(){
        return  judul;
    }
    public  void setTarif(int tarif){
        this.tarif = tarif;
    }
    public int getTarif(){
        return  tarif;
    }
    public int HitungTarifTiket(int jam){
        return  tarif * jam;
    }
    
}
