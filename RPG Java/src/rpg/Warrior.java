package rpg;

import java.util.List;

public class Warrior extends Hero {
    @Override
    public void cast(List<Enemy> enemies, Hero attacker) {

    }
    public Warrior(){
        this.setClassName("Warrior");
        this.baseAttack = 5;
        this.lifePoints = 25;
        this.armor = 0;
    }
}