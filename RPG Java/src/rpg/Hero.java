package rpg;

import com.martin.utils.ConsoleParser;
import java.util.List;

public abstract class Hero {
    int lifePoints;
    int armor;
    int baseAttack;
    int XP;
    int level;
    String name;
    String className;

    public abstract void cast(List<Enemy> enemies, Hero attacker);

    {

    }

    public void addXP(int amount) {
        this.XP += amount;
        checkLevelUp();
    }

    private void checkLevelUp() {

    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Hero() {
        ConsoleParser inputAsker = new ConsoleParser(System.in, System.out);
        name = "Héros";
    }

    public void attack(List<Enemy> enemies) {
        Enemy enemy = enemies.get(0);
        // TODO: choose which enemy to attack:
        System.out.println("Vous attaquez: " + enemy);
        enemy.defend(baseAttack, this);
    }

    public void defend(int attackDamage) {
        if (attackDamage - armor < 0) {
            System.out.println("Le héros" + " a trop d'armure, il n'a pas pris de dégats");
            return;
        }
        lifePoints -= attackDamage - armor;
        System.out.println("Le héros " + " subit " + (attackDamage - armor) + " de dégats");
    }
    public void useitem(){

    }
}



