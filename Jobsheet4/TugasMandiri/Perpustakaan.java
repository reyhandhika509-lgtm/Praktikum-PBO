package Jobsheet4.TugasMandiri;

public class Perpustakaan {
    private String nama;

    // COMPOSITION
    // Rak dibuat langsung oleh Perpustakaan
    private Rak rak;

    // AGGREGATION
    // Buku diberikan dari luar
    private Buku buku;

    public Perpustakaan(String nama, Buku buku) {
        this.nama = nama;
        this.buku = buku;

        // Composition
        this.rak = new Rak("R01");
    }

    public void info() {
        System.out.println("=== PERPUSTAKAAN ===");
        System.out.println("Nama: " + nama);

        System.out.println("\nData Rak:");
        rak.info();

        System.out.println("\nData Buku:");
        buku.info();
    }
    
}
