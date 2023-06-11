package player;

import characters.hero.Hero;

/**
 * Trieda predstavujúca hráča
 * 17. 4. 2022 - 18:05
 *
 * @author Mário Husár
 */
public class Player {
    private Hero hero;
    private int gold;

    /**
     * Vytvorenie nového hráča
     */
    public Player() {
        this.gold = 0;
    }

    /**
     * Dosadenie hrdinu hráčovi
     * @param hero - hrdina
     */
    public void setHero(Hero hero) {
        this.hero = hero;
    }

    /**
     * Getter hrdinu hráča
     * @return vráti hrdinu
     */
    public Hero getHero() {
        return this.hero;
    }

    /**
     * Getter zlata hráča
     * @return hodnotu zlata
     */
    public int getGold() {
        return this.gold;
    }

    /**
     * Pridanie zlata hráčovi
     * @param amount množstvo zlata
     */
    public void addGold(int amount) {
        this.gold += amount;
    }

    /**
     * Odobratie zlata hráčovi
     * @param amount množstvo zlata
     */
    public void spendGold(int amount) {
        this.gold -= amount;
    }
}
