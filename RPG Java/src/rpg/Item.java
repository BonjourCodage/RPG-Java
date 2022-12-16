package rpg;

import java.util.List;
import java.util.Random;

public class Item extends Hero {
    private Random r;
    private Object name;
    private final Object[] normal_drops = {new Potion("Herbe Medicinale"), new Food("Entrecôte"), new Food("Soupe à l'oignon"), new Food("Eau bénite")};

    @Override
    public void cast(List<Enemy> enemies, Hero attacker) {

    }
}
