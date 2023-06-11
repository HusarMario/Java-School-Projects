package characters.enemy;

import cards.cardTypes.Rage;
import cards.cardTypes.Slash;
import cards.cardTypes.StrongSlash;
import characters.hero.Hero;

/**
 * 17. 4. 2022 - 18:05
 *
 * @author Mário Husár
 */
public class Orc extends Enemy {

    /**
     * Vytvorenie inštancie konkrétného nepriateľa
     */
    public Orc() {
        super(25, "src/graphic/pictures/characters/Orc.png");
    }

    /**
     * Špecifikácia správania sa postavy
     * @param hero - Hrdina, na ktorého je možné ťah využiť
     */
    @Override
    public void enemyTurn(Hero hero) {
        switch (this.getPhase()) {
            case 1 -> {
                this.useCard(new Slash(), hero);
                this.setPhase(2);
            }
            case 2 -> {
                this.useCard(new Rage(), hero);
                this.setPhase(3);
            }
            case 3 -> {
                this.useCard(new StrongSlash(), hero);
                this.setPhase(1);
            }
        }

    }
}
