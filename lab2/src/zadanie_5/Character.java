package zadanie_5;

import java.util.Random;

public abstract class Character {
    protected String name;
    protected int health;
    protected int level;
    protected Random random;

    public Character(String name) {
        this.name = name;
        this.health = 100;
        this.level = 1;
        this.random = new Random(); // Инициализация Random
    }

    // Абстрактные методы
    public abstract int attack();

    public abstract void defend(int damage);

    // Общие методы
    public boolean isAlive() {
        return health > 0;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getLevel() {
        return level;
    }

    public void levelUp() {
        level++;
        System.out.println(name + " повысил уровень до " + level + "!");
    }
}
