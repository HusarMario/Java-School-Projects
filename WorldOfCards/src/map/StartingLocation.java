package map;

import characters.enemy.Dummy;

/**
 * Trieda prestavujúca typ lokácie
 * 17. 4. 2022 - 18:05
 *
 * @author Mário Husár
 */
public class StartingLocation extends BattleLocation {

    /**
     * Vytvorenie typu lokácie
     */
    public StartingLocation() {
        super("src/graphic/pictures/locations/TrainingPractice.png", "src/graphic/pictures/locations/TrainingPracticeInfo.png", new Dummy());
    }
}
