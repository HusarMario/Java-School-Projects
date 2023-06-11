package cards.packs;

import cards.cardTypes.HealPotion;
import cards.cardTypes.Relax;
import cards.cardTypes.Slash;
import cards.cardTypes.Steady;
import cards.cardTypes.StrongSlash;

/**
 * Trieda predstavujúca konkrétny typ balíčka
 * 17. 4. 2022 - 18:05
 *
 * @author Mário Husár
 */
public class WarriorCardPack extends PredefinedCardPack {

    /**
     * Vytvorenie inštancie konkrétneho typu balíčka
     */
    public WarriorCardPack() {
        super();
        this.createPack();
    }

    /**
     * Pridanie presných predvoľených kariet
     */
    @Override
    public void createPack() {
        this.addCard(new StrongSlash());
        this.addCard(new Steady());
        this.addCard(new Slash());
        this.addCard(new Slash());
        this.addCard(new Relax());
        this.addCard(new HealPotion());
    }

}
