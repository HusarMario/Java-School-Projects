package cards.packs;

/**
 * Abstraktná trieda pre predvoľené balíčky
 * 17. 4. 2022 - 18:05
 *
 * @author Mário Husár
 */
public abstract class PredefinedCardPack extends CardPack {

    /**
     * Vytvorenie preddefinovaného balíčka
     */
    public PredefinedCardPack() {
        super();
    }

    /**
     * Abstraktná metóda pre vloženie konkrétnych kariet do balíčka
     */
    public abstract void createPack();
}
