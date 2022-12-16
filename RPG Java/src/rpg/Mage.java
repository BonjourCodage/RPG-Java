package rpg;

import com.martin.utils.ConsoleParser;
import java.util.ArrayList;
import java.util.List;

public class Mage extends SpellCaster {
    List<Spell> learnedSpells = new ArrayList<>();

    @Override
    public void cast(List<Enemy> enemies, Hero attacker) {
    }
    public Mage(){
        this.setClassName("Mage");
        this.lifePoints = 13;
        this.baseAttack = 3;
        this.manaPoints = 50;

    }
    public void attack(List<Enemy> enemies){
        Spell selectedSpell = selectSpell();
        if (selectedSpell.manaCost <= manaPoints) {
            manaPoints -= selectedSpell.manaCost;
            selectedSpell.cast(enemies, this);
        }

    }
    private Spell selectSpell() {
        System.out.println("Tu as " + manaPoints + " mana ");
        ConsoleParser inputAsker = new ConsoleParser(System.in, System.out);

        List<String> spellStringList = new ArrayList<>();
        for (Spell spell : learnedSpells) {
            spellStringList.add(spell.name + " manaCost: " + spell.manaCost);
        }
        String[] spellStrings = new String[spellStringList.size()];
        spellStringList.toArray(spellStrings);

        int spellChoiceIndex = inputAsker.getStringsChoiceIndex("Quel sort veut tu utiliser contre l'ennemie", spellStrings);
        return learnedSpells.get(spellChoiceIndex);
    }

}