package Jobsheet4.TugasMandiri;

public class Main {
    public static void main(String[] args) {
        
    
    // Membuat Buku dari luar Perpustakaan
        Buku buku = new Buku(
                "Pemrograman Java",
                "Budi Santoso"
        );

        // Buku diberikan ke Perpustakaan
        Perpustakaan perpustakaan =
                new Perpustakaan("Perpustakaan Kampus", buku);

        perpustakaan.info();    

        // Membuat Anggota
        Anggota anggota = new Anggota("Rey");

        // Dependency: Buku digunakan sebagai parameter
        anggota.pinjamBuku(buku);
    }
    
}
