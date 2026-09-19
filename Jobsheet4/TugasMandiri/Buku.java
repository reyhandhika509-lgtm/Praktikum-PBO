package Jobsheet4.TugasMandiri;

public class Buku {
    private String judul;
    private String penulis;

    public Buku(String judul, String penulis) {
        this.judul = judul;
        this.penulis = penulis;
    }

    public String getJudul() {
        return judul;
    }

    public String getPenulis() {
        return penulis;
    }

    public void info() {
        System.out.println("Judul  : " + judul);
        System.out.println("Penulis: " + penulis);
    }
}
