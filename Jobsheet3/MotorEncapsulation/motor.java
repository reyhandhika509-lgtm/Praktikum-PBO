package Jobsheet3.MotorEncapsulation;

public class motor {
    private  int kecepatan = 0;
    private  boolean kontakOn = false;

    public void nyalakanMesin(){
        kontakOn = true;
    }
    public void matikanMesin(){
        kontakOn = false;
        kecepatan = 0;
    }
    public  void tambahKecepatan(){
        if (kontakOn == true){
            kecepatan += 5;
        } 
        else{
            System.out.println("Kecepatan tidak bisa bertambah karena Mesin OFF! \n");
        }
    }
    public void kurangiKecepatan(){
        if (kontakOn == true){
            kecepatan -= 5;
        } 
        else{
            System.out.println("Kecepatan Tidak Bisa berkurang karena Mesin OFF! \n");
        }
    }

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
