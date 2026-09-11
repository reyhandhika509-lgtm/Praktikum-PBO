package Jobsheet3.MotorEncapsulation;

public class motorDemo {
    public static void main(String[] args) {
        motor motor = new motor();
        motor.printStatus();
        motor.kecepatan = 50;
        motor.printStatus();
    }
    
}
