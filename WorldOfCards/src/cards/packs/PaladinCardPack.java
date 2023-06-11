package cards.packs;

import cards.cardTypes.Exchange;
import cards.cardTypes.HealPotion;
import cards.cardTypes.Slash;
import cards.cardTypes.Steady;

/**
 * Trieda predstavujúca konkrétny typ balíčka
 * 17. 4. 2022 - 18:05
 *
 * @author Mário Husár
 */
public class PaladinCardPack extends PredefinedCardPack {

    /**
     * Vytvorenie inštancie konkrétneho typu balíčka
     */
    public PaladinCardPack() {
        super();
        this.createPack();
    }

    /**
     * Pridanie presných predvoľených kariet
     */
    @Override
    public void createPack() {
        this.addCard(new Slash());
        this.addCard(new Slash());
        this.addCard(new Steady());
        this.addCard(new Steady());
        this.addCard(new Exchange());
        this.addCard(new HealPotion());
    }


}
