package Jobsheet7.id.ac.polinema.overloading.TugasMandiri.tugas1;

public class Segitiga {
    private int sudut;

    public int sisaSudut(int sudutA) {
        this.sudut = 180 - sudutA;
        return this.sudut;
    }

    public int sisaSudut(int sudutA, int sudutB) {
        this.sudut = 180 - (sudutA + sudutB);
        return this.sudut;
    }

    public int keliling(int sisiA, int sisiB, int sisiC) {
        return sisiA + sisiB + sisiC;
    }

    public double keliling(int sisiA, int sisiB) {
        double c = Math.sqrt(Math.pow(sisiA, 2) + Math.pow(sisiB, 2));
        return sisiA + sisiB + c;
    }

    public int getSudut() {
        return sudut;
    }
}
    

