package Jobsheet5;
// Nama Reyhandhika Zikri Prijadi
// Kelas 2G
// Nim 254107020219
public class Reservasi {
    private String nama;
    private Studio studio;
    private  Operator operator;
    private int jam;

    public Reservasi(){
    }
    public void setNama(String nama){
        this.nama = nama;
    }
    public String getNama(){
        return nama;
    }
    public void setStudio(Studio studio){
        this.studio = studio;
    }
    public Studio getStudio(){
        return studio;
    }
    public void setOperator(Operator operator){
        this.operator = operator;
    }
    public Operator getOperator(){
        return operator;
    }
    public void setJam(int jam){
        this.jam = jam;
    }
    public int getHari(){
        return jam;
    }
    public int hitungBiayaTotal(){
        return studio.HitungTarifTiket(jam) ;
    }
}
