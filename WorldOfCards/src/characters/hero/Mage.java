package characters.hero;

import cards.packs.MageCardPack;

/**
 * Trieda predstavujúca typ hrdinu
 * 17. 4. 2022 - 18:05
 *
 * @author user
 */
public class Mage extends Hero {

    /**
     * Vytvorenie novej inštancie konkrétneho hrdinu
     */
    public Mage() {
        super(50, new MageCardPack(), 4, "src/graphic/pictures/characters/Mage.png");
    }


}
