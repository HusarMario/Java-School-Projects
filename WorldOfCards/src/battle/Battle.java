package battle;

import cards.Card;
import cards.cardTypes.IPotion;
import cards.packs.CustomCardPack;
import characters.enemy.Enemy;
import player.Player;

import java.util.Random;

/**
 * Trieda v ktorej sa rozhoduje o logike súboja
 * 17. 4. 2022 - 18:05
 *
 * @author user
 */
public class Battle {
    private final Random random;

    private final Player player;
    private Enemy enemy;

    private CustomCardPack cardPack;
    private CustomCardPack hand;
    private CustomCardPack discarded;

    /**
     * Vytvorí novú triedu Battle
     * @param player - hráč do nej vstupuje automatikcy (jeden hráč celej hry)
     */
    public Battle(Player player) {
        this.random = new Random();

        this.player = player;
        this.enemy = null;

        this.resetHand();
    }

    /**
     * Trieda pripraví balíčky pre ich následné používanie
     */
    public void resetHand() {
        this.cardPack = new CustomCardPack(this.player.getHero().getCardPack());
        this.discarded = new CustomCardPack();
        this.hand = new CustomCardPack();

        for (int i = 0; i < 3; i++) {
            int draw = this.random.nextInt(0, this.cardPack.getSize());
            this.hand.addCard(this.cardPack.getCard(draw));
            this.cardPack.removeCard(draw);
        }
    }

    /**
     * Nastavanie súpera do bitky
     * @param enemy - vložený súper
     */
    public void setEnemy(Enemy enemy) {
        this.enemy = enemy;
    }

    /**
     * Metóda odstráni kartu z používaného balíčka do discard balíčka
     * @param card - konkrétna zahraná karta
     * @return true ak po vykonaní boj skončí úmrtím jednej z postáv
     */
    public boolean discard(Card card) {
        this.hand.removeCard(card);
        if (card instanceof IPotion) {
            this.player.getHero().getCardPack().removeCard(card);
        } else {
            this.discarded.addCard(card);
        }


        if (this.hand.getSize() < 3) {
            int draw = this.random.nextInt(0, this.cardPack.getSize());
            this.hand.addCard(this.cardPack.getCard(draw));
            this.cardPack.removeCard(draw);
        }

        if (this.cardPack.getSize() < 1) {
            this.cardPack = new CustomCardPack(this.discarded);
            this.discarded = new CustomCardPack();
        }

        if (this.enemy.getHealth() > 0) {
            this.enemyTurn();
            return this.player.getHero().getHealth() < 0;
        } else {
            this.player.addGold(this.random.nextInt(30, 50));
            this.player.getHero().addExperience(this.random.nextInt(15, 30));
            return true;
        }
    }

    /**
     * Metóda funguje na rovnako princípe ako discard, karta sa však aj vykoná a hráč kartu zahrá
     * @param card - konkrétna zahraná karta
     * @return true ak po jej vykonaní boj skončí úmrtím jedenj z postáv
     */
    public boolean playerTurn(Card card) {
        this.player.getHero().useCard(card, this.enemy);
        return this.discard(card);
    }

    /**
     * Spustenie ťahu nepriateľa
     */
    public void enemyTurn() {
        this.enemy.enemyTurn(this.player.getHero());
    }

    /**
     * Getter na získanie momentálnej hernej ruky
     * @return vracia balíček hand
     */
    public CustomCardPack getHand() {
        return this.hand;
    }

    /**
     * Výpočet či zahraná karta môže byť zahraná vzhľadom na hráčovú energiu
     * @param card - zahraná karta
     * @return vráti true ak má hráč dostatok energie
     */
    public boolean cardCost(Card card) {
        if (this.player.getHero().getEnergy() >= card.getCardPrice()) {
            this.player.getHero().lowerEnergy(card.getCardPrice());
            return true;
        }
        return false;
    }


}
