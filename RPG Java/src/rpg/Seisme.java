package rpg;

import java.util.List;

public class Seisme extends Spell {
    int damage;

    public Seisme() {
        this.name = "Séisme";
        this.damage = 35;
        this.manaCost = 20;
        this.description = "Un sort qui va lancé un séisme sur l'adversaire";
    }
    public void cast(List<Enemy> enemies, Hero attacker) {
        Enemy enemy = enemies.get(0);
        enemy.defend(damage, attacker);
    }
}