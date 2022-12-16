package rpg;

import java.util.List;

public class Healing extends Spell {
    int heal;
    public Healing() {
        this.name = "healing";
        this.heal = 10;
        this.manaCost = 20;
        this.description = "A simple spell that does heal one ally";
    }
    public void cast(List<Hero> Healer) {
        lifepoints = lifePoints + heal;
    }

    @Override
    public void cast(List<Enemy> enemies, Hero attacker) {

    }
}
