package zadanie_5;

public class Warrior extends Character {
    public Warrior(String name) {
        super(name);
    }

    @Override
    public int attack() {
        return 15 + level * 2;
    }

    @Override
    public void defend(int damage) {
        health -= damage * 0.8;
        System.out.println(name + " получил " + (damage * 0.8) + " урона. Здоровье: " + health);
        if (health < 0) {
            health = 0;
        }
    }
}
