package Jobsheet3.MotorEncapsulation;

public class motorDemo {
    public static void main(String[] args) {
        motor motor = new motor();
        motor.printStatus();
        motor.tambahKecepatan(); 

        motor.nyalakanMesin();
        motor.printStatus();

        motor.tambahKecepatan();
        motor.printStatus();

        motor.tambahKecepatan();
        motor.printStatus();

        motor.tambahKecepatan();
        motor.printStatus();

        motor.matikanMesin();
        motor.printStatus();
    }
    
}
