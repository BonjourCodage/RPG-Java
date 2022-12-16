package rpg;

import java.util.List;

public class DansLeMille extends Spell {
    int damage;

    public DansLeMille() {
        this.name = "DansLeMille";
        this.damage = 30;
        this.ArrowCost =5;
        this.description = "Tire une salve de flèche avec précision";
    }
    public void cast(List<Enemy> enemies, Hero attacker) {
        Enemy enemy = enemies.get(0);
        enemy.defend(damage, attacker);
    }
}