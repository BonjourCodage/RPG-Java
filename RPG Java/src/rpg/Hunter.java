package rpg;

import com.martin.utils.ConsoleParser;
import java.util.ArrayList;
import java.util.List;

public class Hunter extends SpellCaster {
    List<Spell> learnedSpells = new ArrayList<>();

    @Override
    public void cast(List<Enemy> enemies, Hero attacker) {

    }
    public Hunter(){
        this.setClassName("Hunter");
        this.lifePoints = 15;
        this.baseAttack = 1;
        this.ArrowCounts = 15;
    }
    public void attack(List<Enemy> enemies){
        Spell selectedSpell = selectSpell();
        if (selectedSpell.ArrowCost <= ArrowCounts) {
            ArrowCounts -= selectedSpell.ArrowCost;
            selectedSpell.cast(enemies, this);
        }

    }
    private Spell selectSpell() {
        System.out.println("Tu as " + ArrowCounts + " mana ");
        ConsoleParser inputAsker = new ConsoleParser(System.in, System.out);

        List<String> spellStringList = new ArrayList<>();
        for (Spell spell : learnedSpells) {
            spellStringList.add(spell.name + " ArrowCost: " + spell.ArrowCost);
        }
        String[] spellStrings = new String[spellStringList.size()];
        spellStringList.toArray(spellStrings);

        int spellChoiceIndex = inputAsker.getStringsChoiceIndex(" Utilisé son arc en tirant une flèche sur son adversaire", spellStrings);
        return learnedSpells.get(spellChoiceIndex);
    }

}

