package zadanie_5;

public class Rogue extends Character{
    public Rogue(String name) {
        super(name);
    }

    @Override
    public int attack() {
        if (random.nextDouble() < 0.2) {
            System.out.println(name + " нанес КРИТИЧЕСКИЙ удар!");
            return (15 + level) * 3;
        } else {
            return 15 + level;
        }
    }

    @Override
    public void defend(int damage) {
        if (dodge()) {
            System.out.println(name + " увернулся от атаки!");
        } else {
            health -= damage;
            System.out.println(name + " получил " + damage + " урона. Здоровье: " + health);
            if (health < 0) {
                health = 0;
            }
        }
    }
    public boolean dodge() {
        return random.nextDouble() < 0.5;
    }
}
