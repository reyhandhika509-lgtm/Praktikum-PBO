package Jobsheet7.id.ac.polinema.overloading.TugasMandiri.tugas2;

public class MainTugas2 {
    public static void main(String[] args) {
        Manusia manusia = new Manusia();
        Dosen dosen = new Dosen();
        Mahasiswa mhs = new Mahasiswa();

        System.out.println("== Manusia ==");
        manusia.bernafas();
        manusia.makan();

        System.out.println("\n== Dosen ==");
        dosen.bernafas();
        dosen.makan();
        dosen.lembur();

        System.out.println("\n== Mahasiswa ==");
        mhs.bernafas();
        mhs.makan();
        mhs.tidur();
    }
}
    

