package cards.packs;

import cards.cardTypes.EnergyPotion;
import cards.cardTypes.Fireball;
import cards.cardTypes.Relax;
import cards.cardTypes.Slash;

/**
 * Trieda predstavujúca konkrétny typ balíčka
 * 17. 4. 2022 - 18:05
 *
 * @author Mário Husár
 */
public class MageCardPack extends PredefinedCardPack {

    /**
     * Vytvorenie inštancie konkrétneho typu balíčka
     */
    public MageCardPack() {
        super();
        this.createPack();
    }

    /**
     * Pridanie presných predvoľených kariet
     */
    @Override
    public void createPack() {
        this.addCard(new Fireball());
        this.addCard(new Fireball());
        this.addCard(new Relax());
        this.addCard(new Slash());
        this.addCard(new Slash());
        this.addCard(new EnergyPotion());
    }
}
