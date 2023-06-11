package map;

import characters.enemy.Tank;

/**
 * Trieda prestavujúca typ lokácie
 * 17. 4. 2022 - 18:05
 *
 * @author Mário Husár
 */
public class FinalLocation extends BattleLocation {

    /**
     * Vytvorenie typu lokácie
     */
    public FinalLocation() {
        super("src/graphic/pictures/locations/Castle.png", "src/graphic/pictures/locations/CastleInfo.png", new Tank());
    }



}
