package Jobsheet6.id.ac.polinema.inheritance.percobaan2;

public class ClassA {
    protected  int x;
    protected  int y;

    public void setX(int x){
        this.x = x;
    }
    
    public void setY(int y){
        this.y = y;
    }

    public void getNilai(){
        System.out.println("Nilai x:" + x);
        System.out.println("Nilai y: " + y);
    }
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }
}
