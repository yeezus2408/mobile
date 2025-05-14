package zadanie_5;

public class Mage extends Character{
    public Mage(String name) {
        super(name);
    }

    @Override
    public int attack() {
        return 10 + level * 3;
    }

    @Override
    public void defend(int damage) {
        health -= damage;
        System.out.println(name + " получил " + damage + " урона. Здоровье: " + health);
        if (health < 0) {
            health = 0;
        }
        heal(5);
    }

    public void heal(int amount) {
        health += amount;
        System.out.println(name + " вылечился на " + amount + " HP. Здоровье: " + health);
    }
}
