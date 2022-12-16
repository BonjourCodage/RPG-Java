package rpg;

import java.util.List;

public class Foudre extends Spell {
    int damage;

    public Foudre() {
        this.name = "Foudre";
        this.damage = 25;
        this.manaCost = 13;
        this.description = "Un sort qui va lancé de la foudre sur l'adversaire";
    }
    public void cast(List<Enemy> enemies, Hero attacker) {
        Enemy enemy = enemies.get(0);
        enemy.defend(damage, attacker);
    }
}