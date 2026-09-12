package Jobsheet3.tugas;

import java.util.Scanner;
public class TestLogistik {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        
        Kontainer kontainer1 = new Kontainer(
            "RESI001",
            "Reyhandhika",
            1000
        );

        System.out.println("=== SISTEM LOGISTIK KONTTAINER ===");

        System.out.println("Nomor Resi: "
                + kontainer1.getNomorResi());

        System.out.println("Nama Pemilik: "
                + kontainer1.getNamaPemilik());

        System.out.println("Kapasitas Maksimal: "
                + kontainer1.getKapasitasMaksimal() + " kg");


        System.out.print("\nMasukkan berat muatan: ");
        double tambah = input.nextDouble();

        kontainer1.tambahMuatan(tambah);

        System.out.println("Muatan saat ini: "
                + kontainer1.getBeratMuatanSaatIni() + " kg");


        System.out.print("\nMasukkan berat yang akan diturunkan: ");
        double turun = input.nextDouble();

        kontainer1.turunkanMuatan(turun);

        System.out.println("Muatan saat ini: "
                + kontainer1.getBeratMuatanSaatIni() + " kg");

        input.close();
    }
}

//         Kontainer kontainerAlfa = new Kontainer("REQ-998", "PT. Maju Bersama", 5000);

//         System.out.println("Nama Pemilik Kontainer: " + kontainerAlfa.getNamaPemilik());
//         System.out.println("Kapasitas Maksimal: " + kontainerAlfa.getKapasitasMaksimal() + " kg");
    
//         System.out.println("\nMemasukkan muatan baru seberat 6.000 kg...");
//         kontainerAlfa.tambahMuatan(6000);
//         System.out.println("Berat muatan saat ini: " + kontainerAlfa.getBeratMuatanSaatIni() + " kg");

//         System.out.println("\nMemasukkan muatan baru seberat 4.000 kg...");
//         kontainerAlfa.tambahMuatan(4000);
//         System.out.println("Berat muatan saat ini: " + kontainerAlfa.getBeratMuatanSaatIni() + " kg");

//         System.out.println("\nMembongkar muat/menurunkan barang seberat 500- kg...");
//         kontainerAlfa.turunkanMuatan(500);
//         System.out.println("Berat muatan saat ini: " + kontainerAlfa.getBeratMuatanSaatIni() + " kg");

//         System.out.println("\nMembongkar muat/menurunkan barang seberat 1.500 kg...");
//         kontainerAlfa.turunkanMuatan(1500);
//         System.out.println("Berat muatan saat ini: " + kontainerAlfa.getBeratMuatanSaatIni() + " kg");
//     }
    
// }
