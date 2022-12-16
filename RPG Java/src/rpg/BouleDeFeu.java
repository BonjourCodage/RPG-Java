package rpg;

import java.util.List;

public class BouleDeFeu extends Spell {
    int damage;

    public BouleDeFeu() {
        this.name = "BouleDeFeu";
        this.damage = 10;
        this.manaCost = 5;
        this.description = "Un sort qui va lancé une boule de feu sur l'adversaire";
    }
    public void cast(List<Enemy> enemies, Hero attacker) {
        Enemy enemy = enemies.get(0);
        enemy.defend(damage, attacker);
    }
}