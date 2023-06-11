package map;

import characters.enemy.Enemy;
import characters.enemy.Dummy;
import characters.enemy.Orc;
import characters.enemy.Wolf;

import java.util.ArrayList;
import java.util.Random;

/**
 * Trieda prestavujúca typ lokácie
 * 17. 4. 2022 - 18:05
 *
 * @author Mário Husár
 */
public class BattleLocation extends Location {
    private Enemy enemy;

    /**
     * Vytvorenie typu lokácie
     */
    public BattleLocation() {
        super("src/graphic/pictures/locations/Battle.png", "src/graphic/pictures/locations/BattleInfo.png");
        this.addEnemies();
    }

    /**
     * Vytvorenie typu lokácie z inej lokácie
     * @param locationPicturePath - cesta k obrázku lokácie
     * @param locationInfoPath - cesta k obrázku o infe lokácie
     * @param enemy - vložený nepriateľ do lokácie
     */
    public BattleLocation(String locationPicturePath, String locationInfoPath, Enemy enemy) {
        super(locationPicturePath, locationInfoPath);
        this.enemy = enemy;
    }

    /**
     * Getter na nepriateľa
     * @return vráti nepriateľa
     */
    public Enemy getEnemy() {
        return this.enemy;
    }

    /**
     * Generátor nepriateľov
     */
    private void addEnemies() {
        Random random = new Random();
        ArrayList<Enemy> possible = new ArrayList<>();
        possible.add(new Dummy());
        possible.add(new Orc());
        possible.add(new Wolf());
        this.enemy = possible.get(random.nextInt(0, possible.size()));
    }
}
