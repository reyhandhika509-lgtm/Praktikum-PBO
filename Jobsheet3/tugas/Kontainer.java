package Jobsheet3.tugas;

public class Kontainer {
    private String nomorResi;
    private String namaPemilik;
    private double kapasitasMaksimal;
    private double beratMuatanSaatIni = 0;

    public Kontainer(String nomorResi, String namaPemilik, double kapasitasMaksimal) {
        this.nomorResi = nomorResi;
        this.namaPemilik = namaPemilik;
        this.kapasitasMaksimal = kapasitasMaksimal;
        this.beratMuatanSaatIni = 0;
    }

    public String getNomorResi() {
        return nomorResi;
    }

    public String getNamaPemilik() {
        return namaPemilik;
    }

    public double getKapasitasMaksimal() {
        return kapasitasMaksimal;
    }

    public double getBeratMuatanSaatIni() {
        return beratMuatanSaatIni;
    }

    public void tambahMuatan(double berat) {
        if (beratMuatanSaatIni + berat <= kapasitasMaksimal) {
            beratMuatanSaatIni += berat;
            System.out.println("Muatan melebihi kapasitas maksimal!");
            } else {
        }
    }

    public void turunkanMuatan(double berat) {
        if (berat <= beratMuatanSaatIni) {
            beratMuatanSaatIni -= berat;
             double batasMaksimal = beratMuatanSaatIni * 0.5;

        if (berat > batasMaksimal) {

            System.out.println(
                "Maaf, demi keselamatan, pembongkaran muatan "
                + "satu kali jalan tidak boleh melebihi 50% "
                + "dari muatan saat ini!"
            );

        } else if (berat <= beratMuatanSaatIni) {

            beratMuatanSaatIni -= berat;
            System.out.println("Muatan berhasil diturunkan.");

        } else {

            System.out.println(
                "Berat yang diturunkan melebihi muatan saat ini!"
            );
        }
        } else {
            System.out.println("Muatan yang diturunkan melebihi muatan saat ini!");
        }
    }
}
    

