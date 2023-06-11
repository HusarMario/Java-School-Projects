package cards.cardTypes;

import cards.Card;
import characters.Character;

/**
 * Trieda prestavujúca typ karty
 * 17. 4. 2022 - 18:05
 *
 * @author Mário Husár
 */
public class Steady extends Card {

    /**
     * Vytvorenie inštancie konrétne uvedenej kraty
     */
    public Steady() {
        super("Steady", 0, "src/graphic/pictures/cards/Steady.png");
    }

    /**
     * Vytvorenie používania konkétne uvedenej karty
     * @param attacker - útočiaca postava
     * @param target - napadnutá postava
     */
    @Override
    public void use(Character attacker, Character target) {
        attacker.gainArmor(3);
    }
}
