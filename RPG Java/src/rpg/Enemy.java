package rpg;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Enemy {
    int lifePoints = 5;
    int attackDamage = 2;
    int armor;
    int xpGiven;
    List<Hero> involvedHeroes = new ArrayList<>();

    public void attack(List<Hero> heroesToAttack) {
        Random rand = new Random();
        Hero targetHero = heroesToAttack.get(rand.nextInt(heroesToAttack.size()));
        targetHero.defend(attackDamage);
    }

    public void defend(int attackDamage, Hero attacker) {
        if (attackDamage - armor < 0) {
            System.out.println("L'ennemie est trop fort, il a pas subit de dégat");
            return;
        }
        if (!involvedHeroes.contains(attacker)) {
            involvedHeroes.add(attacker);
        }
        lifePoints -= attackDamage - armor;
        System.out.println(" L'ennemie a subit " + (attackDamage - armor) + "dégats");
        TestDeath();
    }
    private void TestDeath() {
        if (lifePoints <= 0) {
            die();
        }
    }
    public void die() {
        giveExp(involvedHeroes);
    }
    private void giveExp(List<Hero> heroes) {
        for (Hero hero: heroes) {
            hero.addXP(xpGiven);
        }
    }
}