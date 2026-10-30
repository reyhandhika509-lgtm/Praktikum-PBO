package jobsheet8;

public class PesananMotor extends Pesanan {
    public static final int TARIF_MINIMUM = 8000;

    public PesananMotor(String id, String namaPenumpang, double jarakKm) {
        super(id, namaPenumpang, jarakKm);
    }

    @Override
    public int hitungTarif() {
        int tarifDasar = super.hitungTarif();
        return Math.max(tarifDasar, TARIF_MINIMUM);
    }

    @Override
    public String info() {
        return super.info() + " [Motor]";
    }
}
    

