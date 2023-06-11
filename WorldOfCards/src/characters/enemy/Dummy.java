package characters.enemy;

import cards.cardTypes.WoodenSlash;
import characters.hero.Hero;

/**
 * Trieda predstavujúca typ nepriateľa
 * 17. 4. 2022 - 18:05
 *
 * @author Mário Husár
 */
public class Dummy extends Enemy {

    /**
     * Vytvorenie inštancie konkrétného nepriateľa
     */
    public Dummy() {
        super(30, "src/graphic/pictures/characters/Dummy.png");
    }

    /**
     * Špecifikácia správania sa postavy
     * @param hero - Hrdina, na ktorého je možné ťah využiť
     */
    public void enemyTurn(Hero hero) {
        this.useCard(new WoodenSlash(), hero);
    }
}
