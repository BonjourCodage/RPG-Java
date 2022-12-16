package rpg;

import com.martin.utils.ConsoleParser;
import java.util.ArrayList;
import java.util.List;
public class Healer extends SpellCaster {

    List<Spell> learnedSpells = new ArrayList<>();

    @Override
    public void cast(List<Enemy> enemies, Hero attacker) {

    }
    public Healer(){
        this.setClassName("Healer");
        this.lifePoints = 18;
        this.baseAttack = 2;
        this.manaPoints = 70;
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

        int spellChoiceIndex = inputAsker.getStringsChoiceIndex("Quel sort veut tu utiliser pour tes allié", spellStrings);
        return learnedSpells.get(spellChoiceIndex);
    }

}



