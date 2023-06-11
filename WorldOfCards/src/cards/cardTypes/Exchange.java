package cards.cardTypes;

import cards.Card;
import characters.Character;

/**
 * Trieda prestavujúca typ karty
 * 17. 4. 2022 - 18:05
 *
 * @author Mário Husár
 */
public class Exchange extends Card {

    /**
     * Vytvorenie inštancie konrétne uvedenej kraty
     */
    public Exchange() {
        super("Exchange", 1, "src/graphic/pictures/cards/Exchange.png");
    }

    /**
     * Vytvorenie používania konkétne uvedenej karty
     * @param attacker - útočiaca postava
     * @param target - napadnutá postava
     */
    @Override
    public void use(Character attacker, Character target) {
        int amount = attacker.getArmor();
        attacker.refreshArmor();
        attacker.heal(amount);
    }
}
