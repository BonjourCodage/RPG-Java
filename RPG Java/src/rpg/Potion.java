package rpg;

public class Potion extends Item {

    private final String name;
    private int level;
    private int heal_value;

    public Potion(String name) {
        this.name = name;
        this.level = level;
        this.setAttributes();
    }

    private void setAttributes() {
        this.heal_value = this.level * 2;
    }
}

