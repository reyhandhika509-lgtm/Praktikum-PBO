package Jobsheet9.id.ac.polinema.polimorfisme.pegawai;

public class Eksperimen4 {
    public static void main(String[] args) {
        Employee e = new InternshipEmployee("Sunarto", 5);
        System.out.println("Sebelum casting");
        PermanentEmployee pe = (PermanentEmployee) e;
        System.out.println("Sesudah casting: " + pe.getSalary());
    }
}
