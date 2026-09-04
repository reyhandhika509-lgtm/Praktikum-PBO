package jobsheet2.id.ac.polinema;

public class Circle25 {
    double radius;
    Circle25(double radius){
        this.radius = radius;
    }

    double area(){
        return Math.PI * radius * radius;
    }
    double circumference(){
        return 2 * Math.PI *radius *radius;
    }
    
}
