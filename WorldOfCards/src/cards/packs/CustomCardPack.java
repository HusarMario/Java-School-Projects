package cards.packs;

import cards.Card;

/**
 * Trieda predstavujúca nepredvolený balíček kariet
 * 17. 4. 2022 - 18:05
 *
 * @author Mário Husár
 */
public class CustomCardPack extends CardPack {

    /**
     * Vytvorenie inštancie prázdného balíčka
     */
    public CustomCardPack() {
        super();
    }

    /**
     * Vytvorenie inštancie skopírovaného balíčka
     * @param cardPack balíček podľa ktorého vytvoríme nový balíček
     */
    public CustomCardPack(CardPack cardPack) {
        super();
        for (Card card : cardPack.getCards()) {
            this.addCard(card);
        }
    }


}
