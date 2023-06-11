package cards.cardTypes;

import cards.Card;
import characters.Character;

/**
 * Trieda prestavujúca typ karty
 * 17. 4. 2022 - 18:05
 *
 * @author Mário Husár
 */
public class WoodenSlash extends Card {

    /**
     * Vytvorenie inštancie konrétne uvedenej kraty
     */
    public WoodenSlash() {
        super("WoodenSlash", 0, "src/graphic/pictures/cards/WoodenSlash.png");
    }

    /**
     * Vytvorenie používania konkétne uvedenej karty
     * @param attacker - útočiaca postava
     * @param target - napadnutá postava
     */
    @Override
    public void use(Character attacker, Character target) {
        target.lowerHealth(1);
    }
}
