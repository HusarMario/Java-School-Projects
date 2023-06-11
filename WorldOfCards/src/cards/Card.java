package cards;

import characters.Character;

/**
 * Abstraktná trieda predstavujúca herné karty
 * 17. 4. 2022 - 18:05
 *
 * @author Mário Husár
 */
public abstract class Card {
    private final String cardTitle;
    private final int cardPrice;
    private final String picturePath; //550 800

    /**
     * Vytvorenie novej inštancie karty
     * @param cardTitle - názov karty
     * @param cardPrice - cena zhrania karty
     * @param picturePath - odkaz na cestu k obrázku karty
     */
    public Card(String cardTitle, int cardPrice, String picturePath) {
        this.picturePath = picturePath;

        this.cardTitle = cardTitle;
        this.cardPrice = cardPrice;
    }

    /**
     * Abstraktná metóda prestavujúca používanie kariet
     * @param attacker - útočiaca postava
     * @param target - napadnutá postava
     */
    public abstract void use(Character attacker, Character target);

    /**
     * Getter pre cestu k obrázku
     * @return String cesty k obrázku
     */
    public String getPicturePath() {
        return this.picturePath;
    }

    /**
     * Getter pre cenu karty
     * @return integer ceny karty
     */
    public int getCardPrice() {
        return this.cardPrice;
    }

    /**
     * Getter pre názov karty
     * @return String názvu karty
     */
    public String getCardTitle() {
        return this.cardTitle;
    }
}
