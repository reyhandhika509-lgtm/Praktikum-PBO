package Jobsheet6.id.ac.polinema.inheritance.tugas3;

public class Angel extends  Character{
    protected int potion;

    public Angel(String name, int level, int health, int potion) {
        super(name, level, health);
        this.potion = potion;
    }

    public void cure(Character target) {
        if (potion > 0) {
            target.health = 100;
            potion--;
        }
    }
}
