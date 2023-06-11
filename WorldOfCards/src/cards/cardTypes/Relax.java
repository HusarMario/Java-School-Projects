package cards.cardTypes;

import cards.Card;
import characters.Character;
import characters.hero.Hero;

/**
 * Trieda prestavujúca typ karty
 * 17. 4. 2022 - 18:05
 *
 * @author Mário Husár
 */
public class Relax extends Card {

    /**
     * Vytvorenie inštancie konrétne uvedenej kraty
     */
    public Relax() {
        super("Relax", 0, "src/graphic/pictures/cards/Relax.png");
    }

    /**
     * Vytvorenie používania konkétne uvedenej karty
     * @param attacker - útočiaca postava
     * @param target - napadnutá postava
     */
    @Override
    public void use(Character attacker, Character target) {
        ((Hero)attacker).refreshEnery();
    }
}
