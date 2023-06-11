package characters.enemy;

import cards.cardTypes.Steady;
import cards.cardTypes.StrongSlash;
import characters.hero.Hero;

/**
 * 17. 4. 2022 - 18:05
 *
 * @author Mário Husár
 */
public class Tank extends Enemy {

    /**
     * Vytvorenie inštancie konkrétného nepriateľa
     */
    public Tank() {
        super(100, "src/graphic/pictures/characters/Tank.png");
    }

    /**
     * Špecifikácia správania sa postavy
     * @param hero - Hrdina, na ktorého je možné ťah využiť
     */
    @Override
    public void enemyTurn(Hero hero) {
        this.useCard(new Steady(), hero);
        if (this.getPhase() == 3) {
            this.useCard(new StrongSlash(), hero);
            this.setPhase(1);
        } else {
            this.setPhase(this.getPhase() + 1);
        }
    }
}
