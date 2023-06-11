package characters.hero;

import cards.packs.WarriorCardPack;

/**
 * Trieda predstavujúca typ hrdinu
 * 17. 4. 2022 - 18:05
 *
 * @author user
 */
public class Warrior extends Hero {

    /**
     * Vytvorenie novej inštancie konkrétneho hrdinu
     */
    public Warrior() {
        super(65,  new WarriorCardPack(), 3, "src/graphic/pictures/characters/Warrior.png");
    }


}
