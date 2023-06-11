package cards.cardTypes;

import cards.Card;
import characters.Character;

/**
 * Trieda prestavujúca typ karty
 * 17. 4. 2022 - 18:05
 *
 * @author Mário Husár
 */
public class StrongSlash extends Card {

    /**
     * Vytvorenie inštancie konrétne uvedenej kraty
     */
    public StrongSlash() {
        super("StrongSlash", 1, "src/graphic/pictures/cards/StrongSlash.png");
    }

    /**
     * Vytvorenie používania konkétne uvedenej karty
     * @param attacker - útočiaca postava
     * @param target - napadnutá postava
     */
    @Override
    public void use(Character attacker, Character target) {
        target.lowerHealth(25);
    }
}
