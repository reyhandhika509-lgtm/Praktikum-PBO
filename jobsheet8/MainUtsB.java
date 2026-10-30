package jobsheet8;

public class MainUtsB {

    public static void main(String[] args) {
        Driver budi = new Driver("Budi", 2500);
        Driver sari = new Driver("Sari", 4000);
        Promo hemat = new Promo("HEMAT20", 20);

        PesananMotor p1 = new PesananMotor("P-001", "Dina", 3.0);
        p1.tugaskan(budi);

        System.out.println(p1.info());
        System.out.println("Tarif P-001: " + p1.hitungTarif());
        System.out.println("P-001 dengan promo: " + p1.hitungTotal(hemat));

        p1.tugaskan(sari); // ganti driver
        System.out.println("P-001 ganti driver, dengan promo: " + p1.hitungTotal(hemat));

        PesananMobil p2 = new PesananMobil("P-002", "Raka", 10.5, 4);
        p2.tugaskan(sari);
        
        System.out.println(p2.info());
        System.out.println("P-002 tanpa promo: " + p2.hitungTotal(null));
    }
}

//Output:
// P-001 Dina (3.0 km) [Motor]
// Tarif P-001: 8000
// P-001 dengan promo: 6400
// P-001 ganti driver, dengan promo: 9600
// P-002 Raka (10.5 km) [Mobil, 4 kursi]
// P-002 tanpa promo: 45000

// Jawaban Tugas 3:
// Atribut dan method dari Pesanan dipakai ulang melalui inheritance (extends) 
// serta pemanggilan super.hitungTarif() untuk mengambil nilai tarif dasar. 
// Method yang di-override adalah hitungTarif() untuk menambahkan kondisi pemotongan 10% jika getJarakKm() <= 3. 
// Rumus tarif tidak disalin agar kita menghindari penulisan ulang (duplikasi) logika rumus tarif dasar yang sudah ada di kelas induk,
// kelas turunan baru ini otomatis mengikutinya Contohnya Atribut PesananBajaj.
    

