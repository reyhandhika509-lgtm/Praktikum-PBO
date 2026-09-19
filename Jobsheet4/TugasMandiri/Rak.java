package Jobsheet4.TugasMandiri;

public class Rak {
    private String kodeRak;

    public Rak(String kodeRak) {
        this.kodeRak = kodeRak;
    }

    public String getKodeRak() {
        return kodeRak;
    }

    public void info() {
        System.out.println("Rak: " + kodeRak);
    }
}
