package jobsheet8;

public class Pesanan {
    private String id;
    private String namaPenumpang;
    private double jarakKm;
    private Driver driver;

    public Pesanan(String id, String namaPenumpang, double jarakKm) {
        this.id = id;
        this.namaPenumpang = namaPenumpang;
        this.jarakKm = jarakKm;
        this.driver = null;
    }

    public void tugaskan(Driver driver) {
        this.driver = driver;
    }

    public int hitungTarif() {
        if (driver == null) {
            return 0;
        }
        return (int) Math.round(jarakKm * driver.getTarifPerKm());
    }

    public int hitungTotal(Promo promo) {
        int tarif = hitungTarif();
        if (promo != null) {
            int potongan = (tarif * promo.getPersen()) / 100;
            return tarif - potongan;
        }
        return tarif;
    }

    public String getId() {
        return id;
    }

    public String getNamaPenumpang() {
        return namaPenumpang;
    }

    public double getJarakKm() {
        return jarakKm;
    }

    public String info() {
        return id + " " + namaPenumpang + " (" + jarakKm + " km)";
    }
}
