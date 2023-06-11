package characters.enemy;

import cards.cardTypes.Bite;
import characters.hero.Hero;

/**
 * 17. 4. 2022 - 18:05
 *
 * @author Mário Husár
 */
public class Wolf extends Enemy {

    /**
     * Vytvorenie inštancie konkrétného nepriateľa
     */
    public Wolf() {
        super(30, "src/graphic/pictures/characters/Wolf.png");
    }

    /**
     * Špecifikácia správania sa postavy
     * @param hero - Hrdina, na ktorého je možné ťah využiť
     */
    @Override
    public void enemyTurn(Hero hero) {
        this.useCard(new Bite(), hero);
    }
}
