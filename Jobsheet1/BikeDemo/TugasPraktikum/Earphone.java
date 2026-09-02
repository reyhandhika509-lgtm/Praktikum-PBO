package Jobsheet1.BikeDemo.TugasPraktikum;

public class Earphone extends PeriferalAudio {
    private boolean ANC;

    void ANCstatus(boolean ActiveNoiseCancellation){
        ANC = ActiveNoiseCancellation;
    }

    String cancellation(){
        String status;
        if (ANC) {
            status = "Ada";
        }else{
            status = "Tidak ada";
        }
        return status;
    }

    void menyalakan(){
        System.out.println("ANC " + ANC + " sedang dinyalakan");
    }

    void mematikan(){
        System.out.println("ANC " + ANC + " sedang dimatikan");
    }

    @Override
    void print() {
        super.print();
        System.out.println("ANC: " + cancellation());
    }
}
    

