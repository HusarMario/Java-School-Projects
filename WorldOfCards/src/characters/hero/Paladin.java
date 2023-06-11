package characters.hero;

import cards.packs.PaladinCardPack;

/**
 * Trieda predstavujúca typ hrdinu
 * 17. 4. 2022 - 18:05
 *
 * @author user
 */
public class Paladin extends Hero {

    /**
     * Vytvorenie novej inštancie konkrétneho hrdinu
     */
    public Paladin() {
        super(80, new PaladinCardPack(), 2,  "src/graphic/pictures/characters/Paladin.png");
    }


}
