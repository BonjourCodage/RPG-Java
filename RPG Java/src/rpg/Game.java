package rpg;

import com.martin.utils.ConsoleParser;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Game {
    List<Hero> heroes = new ArrayList<>();
    int playerTurn;
    int partySize;
    final ConsoleParser inputAsker = new ConsoleParser(System.in, System.out);
    final String[] heroClasses = new String[]{"Warrior", "Mage", "Hunter", "Healer"};
    boolean gameRunning = false;

    public void start() {

        initGame();
        gameLoop();
    }

    private void gameLoop() {

        int baseEnemies = 0;
        Random rand = new Random();

        while (gameRunning) {

            baseEnemies++;

            // create enemies
            List<Enemy> enemiesPool = new ArrayList<>();
            for (int i = 0; i < baseEnemies + rand.nextInt(3); i++) {
                enemiesPool.add(new Enemy());
            }
            launchBattle(enemiesPool);
        }
    }

    private void launchBattle(List<Enemy> enemies) {
        List<Enemy> remainingEnemies = new ArrayList<>(enemies);

        while (!remainingEnemies.isEmpty() && !heroes.isEmpty()) {
            System.out.println("C'est au tour du " + heroes.get(playerTurn).name + ". HP=" + heroes.get(playerTurn).lifePoints);
            System.out.println(remainingEnemies);

            String[] actionChoices = new String[]{"Attaqué", "Item" , "Passé son tour"};
            int choiceIndex = inputAsker.getStringsChoiceIndex("Que veux tu faire dans ce tour ?", actionChoices);
            switch (actionChoices[choiceIndex]) {
                case "Attaqué":
                    heroes.get(playerTurn).attack(remainingEnemies);
                    break;
                case "Item":
                    heroes.get(playerTurn).useitem();
                    // Je n'ai pas réussi à implémenté les items dans le jeux
                    break;
                case "Passé son tour":
                    break;
                default:
                    break;
            }

            deathReaper(remainingEnemies);

            if (playerTurn == heroes.size() - 1) {
                enemiesTurn(remainingEnemies);
                playerTurn = 0;
            } else {
                playerTurn++;
            }

            testHeroesDeath(heroes);
        }
        System.out.println("Tous les ennemies ont été tué");

    }
    private void deathReaper(List<Enemy> enemies) {
        Iterator<Enemy> i = enemies.iterator();
        while (i.hasNext()) {
            Enemy enemy = i.next();
            if (enemy.lifePoints <= 0) {
                enemy.die();
                i.remove();
            }
        }
    }

    private void testHeroesDeath(List<Hero> heroes) {
        heroes.removeIf(hero -> hero.lifePoints <= 0);
        if (heroes.isEmpty()) {
            gameRunning = false;
        }

    }
    private void enemiesTurn(List<Enemy> remainingEnemies) {
        for (Enemy enemy : remainingEnemies) {
            enemy.attack(heroes);
        }
    }

    private void initGame() {
        choosePartySize();
        createHeroes();
        gameRunning = true;
    }

    private void createHeroes() {

        for (int heroID = 0; heroID < partySize; heroID++) {

            int classChoiceIndex = inputAsker.getStringsChoiceIndex("Joueur " + heroID + " chosit ta classe: ", heroClasses);
            switch (heroClasses[classChoiceIndex]) {
                case "Warrior" -> heroes.add(new Warrior());
                case "Mage" -> {
                    Mage mage = new Mage();
                    mage.learnedSpells.add(new BouleDeFeu());
                    mage.learnedSpells.add(new Foudre());
                    mage.learnedSpells.add(new Seisme());
                    heroes.add(mage);
                }
                case "Hunter" -> {
                    Hunter hunter = new Hunter();
                    hunter.learnedSpells.add(new TirDeFlèche());
                    hunter.learnedSpells.add(new DansLeMille());
                    heroes.add(hunter);
                }
                case "Healer" -> {
                    Healer healer = new Healer();
                    healer.learnedSpells.add(new Healing());
                    // le sort de heal ne fonctionne pas, je n'ai pas réussi à implémenté une mecanique de heal
                    healer.learnedSpells.add(new Foudre());
                    heroes.add(healer);
                }

                default -> throw new RuntimeException("Cette classe n'existe pas");
            }
            }
        }

    private void choosePartySize() {

        // Choose party size
        do {
            System.out.println("La taille du groupe de Héros va de 1 à 4 !");
            partySize = inputAsker.promptInt("Le nombre de Héros que tu souhaites avoir dans ta partie ?:", 0);
        } while (partySize > 4 || partySize < 1);

    }
}

