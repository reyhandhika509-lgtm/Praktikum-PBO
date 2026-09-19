package Jobsheet4.TugasMandiri;

public class Anggota {
     private String nama;

    public Anggota(String nama) {
        this.nama = nama;
    }
    // DEPENDENCY
    // Buku hanya digunakan sebagai parameter method
    // dan tidak disimpan sebagai atribut
    public void pinjamBuku(Buku buku) {
        System.out.println("\n=== PEMINJAMAN ===");
        System.out.println(nama + " meminjam buku:");
        System.out.println("Judul: " + buku.getJudul());
    }
}
