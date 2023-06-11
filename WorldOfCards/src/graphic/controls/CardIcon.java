package graphic.controls;

import cards.Card;

/**
 * Trieda predstavujuca klikatelny obrazok kariet
 * 17. 4. 2022 - 18:05
 *
 * @author Mário Husár
 */
public class CardIcon extends Clickable {
    private Card card;

    /**
     * Vytvorenie novej ikony
     * @param x - suradnica x
     * @param y - suradnica y
     * @param width - šírka
     * @param height - výška
     * @param card - karta pod ikonu
     */
    public CardIcon(int x, int y, int width, int height, Card card) {
        super(x, y, width, height, card.getPicturePath());
    }

    /**
     * Getter príslušnej karty
     * @return vráti kartu
     */
    public Card getCard() {
        return this.card;
    }

    /**
     * Setter karty
     * @param card - dosadená karta
     */
    public void setCard(Card card) {
        this.card = card;
    }
}
