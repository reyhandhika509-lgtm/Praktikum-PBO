package Jobsheet3.MotorEncapsulation;

public class motor {
    public int kecepatan = 0;
    public boolean kontakOn = false;

    public void printStatus(){
        if (kontakOn == true){
            System.out.println("Kontak On");
        } 
        else{
            System.out.println("Kontak OFF");
        }
        System.out.println("Kecepatan " + kecepatan+"\n");
    }
    
}
