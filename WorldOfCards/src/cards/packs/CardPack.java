package cards.packs;

import cards.Card;

import java.util.ArrayList;

/**
 * Abstraktná trieda prestavujúca balíček kariet
 * 17. 4. 2022 - 18:05
 *
 * @author Mário Husár
 */
public abstract class CardPack {
    private final ArrayList<Card> cards;
    private int cardIndex;
    private int size;

    /**
     * Vytvorenie balíčku triedy
     */
    public CardPack() {
        this.cards = new ArrayList<>();
        this.cardIndex = 0;
        this.size = 0;
    }

    /**
     * Pridanie karty do balíčka
     * @param card - pridaná karta
     */
    public void addCard(Card card) {
        this.cards.add(card);
        this.size++;
    }

    /**
     * Odstránenie karty z balíčka
     * @param card - odstránená karta
     */
    public void removeCard(Card card) {
        this.cards.remove(card);
        this.size--;
    }

    /**
     * Odstránenie karty z balíčka
     * @param index - index karty v balíčku
     */
    public void removeCard(int index) {
        this.cards.remove(index);
        this.size--;
        this.cardIndex = 0;
    }

    /**
     * Getter na kartu podľa prednastaveného indexu
     * @return vráti konkrétnu kartu
     */
    public Card getCard() {
        return this.cards.get(this.cardIndex);
    }

    /**
     * Getter na kartu poďla vlastného indexu
     * @param index - hodnota indexu
     * @return vráti konkrétnu kartu
     */
    public Card getCard(int index) {
        this.cardIndex = 0;
        return this.cards.get(index);
    }

    /**
     * Pohnutie indexu v balíčku smerom nadol
     * @return vráti kartu na konkrétnom indexe
     */
    public Card prevCard() {
        if (--this.cardIndex == -1) {
            this.cardIndex = this.cards.size() - 1;
        }
        return this.cards.get(this.cardIndex);
    }

    /**
     * Pohnutie indexu v balíčku smerom nahor
     * @return vráti kartu na konrétnom indexe
     */
    public Card nextCard() {
        if (++this.cardIndex == this.cards.size()) {
            this.cardIndex = 0;
        }
        return this.cards.get(this.cardIndex);
    }

    /**
     * Getter celého balíčka
     * @return vráti nový arraylist zhodný s balíčkom
     */
    public ArrayList<Card> getCards() {
        return new ArrayList<>(this.cards);
    }

    /**
     * Getter pre veľkosť balíčka
     * @return veľkosť balíčka
     */
    public int getSize() {
        return this.size;
    }
}
