package Jobsheet5;
// Nama Reyhandhika Zikri Prijadi
// Kelas 2G
// Nim 254107020219
public class Operator {
    private  String nama;
    private int biayaLayanan;

    public Operator(){

    }
    public void setNama(String nama){
        this.nama = nama;
    }
    public String getNama(){
        return nama;
    }
    public void SetBiayaLayanan(int biayaLayanan){
        this.biayaLayanan = biayaLayanan;
    }
    public int getBiayalayanan(){
        return biayaLayanan;

    }
      
    public int HitungTarifTiket(int hari){
        return biayaLayanan*hari;
    }
    
}
