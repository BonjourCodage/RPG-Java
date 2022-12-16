package rpg;

public class Weapon extends Item {
    private final String name;
    private int level;
    private int damage;

    public Weapon(String name, int level) {
        this.name = name;
        this.level = level;
        this.setAttributes();
    }
    private void setAttributes() {
        this.damage = this.level + 2;
    }

}