package rpg;

import java.util.List;

public class TirDeFlèche extends Spell {
    int damage;

    public TirDeFlèche() {
        this.name = "TirDeFlèche";
        this.damage = 10;
        this.ArrowCost =2;
        this.description = "Tire une flèche sur l'adversaire";
    }
    public void cast(List<Enemy> enemies, Hero attacker) {
        Enemy enemy = enemies.get(0);
        enemy.defend(damage, attacker);
    }
}