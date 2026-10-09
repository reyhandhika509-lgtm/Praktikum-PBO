package Jobsheet7.id.ac.polinema.overloading.percobaan05;

public class Staff extends Karyawan {
    private int jamLembur;
    private double tarifLembur;

    public Staff(String nip, String nama, String golongan,
                int jamLembur, double tarifLembur) {
        super(nip, nama, golongan);
        this.jamLembur = jamLembur;
        this.tarifLembur = tarifLembur;
    }

 // OVERLOADING: nama sama dengan getGaji() Karyawan, parameter berbeda
    public double getGaji(int jamLembur, double tarifLembur) {
        return super.getGaji() + jamLembur * tarifLembur;
    }

 // OVERRIDING: signature sama persis dengan getGaji() Karyawan
    @Override
    public double getGaji() {
        return getGaji(jamLembur, tarifLembur);
    }

    @Override
    public void lihatInfo() {
        super.lihatInfo();
        System.out.println("Jam lembur : " + jamLembur);
        System.out.printf("Tarif/jam : %.0f%n", tarifLembur);
    }
}