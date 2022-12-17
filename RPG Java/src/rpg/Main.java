package rpg;

public class Main {
    public static void main(String[] args) {
        System.out.println("Bienvenue dans cette nouvelle aventure !");
        System.out.println("Il était une fois, dans un royaume lointain, un groupe de héros qui se mettaient");
        System.out.println("en quête de vaincre le terrible dragon qui terrorisait les habitants du royaume.");
        System.out.println("Le groupe était composé d'un guerrier puissant, d'une magicienne talentueuse, d'un tireur de flèche ");
        System.out.println("très habile et d'un prêtre dévoué. Ils avaient entendu parler de la richesse inestimable que le dragon ");
        System.out.println("gardait jalousement dans son antre, et ils étaient déterminés à mettre fin à sa tyrannie une fois pour toutes.");
        System.out.println("Après de nombreuses semaines de voyage, ils arrivèrent enfin au pied de la montagne où le dragon avait élu domicile.");
        System.out.println("Les héros devait faire face aux vagues continuelle que le dragon envoyait sur eux avant de pouvoir le combattre ! ");

        Game mainGame = new Game();
        mainGame.start();
    }
}



