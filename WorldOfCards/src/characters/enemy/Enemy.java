package characters.enemy;

import cards.Card;
import characters.Character;
import characters.hero.Hero;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * Abstraktná trieda predstavujúca nepriateľa
 * 17. 4. 2022 - 18:05
 *
 * @author Mário Husár
 */
public abstract class Enemy extends Character {
    private int phase;

    /**
     * Vytvorenie nového nepriateľa
     * @param health - počet životov
     * @param picturePath - cesta na obrázok
     */
    public Enemy(int health, String picturePath) {
        super(health, picturePath);
        this.phase = 1;
    }

    /**
     * Abstraktná metóda pre zabezpečenie ťahu postavy
     * @param hero - Hrdina, na ktorého je možné ťah využiť
     */
    public abstract void enemyTurn(Hero hero);

    /**
     * Použitie karty (Zabezpečná ukážka ťahu cez JFrame)
     * @param card - zahraná karta
     * @param target - cieľ zahranej karty
     */
    @Override
    public void useCard(Card card, Character target) {
        card.use(this, target);

        JFrame jFrame = new JFrame();
        ImageIcon imageIcon = new ImageIcon(card.getPicturePath());
        JLabel label = new JLabel(imageIcon);
        jFrame.add(label);
        jFrame.setVisible(true);
        jFrame.pack();
    }

    /**
     * Getter na fázu postavy podľa ktorej vykonáva ťahy
     * @return hodnota fázy
     */
    public int getPhase() {
        return this.phase;
    }

    /**
     * Setter na fázu postavy podľa ktorej vykonáva ťahy
     * @param phase hodnota fázy
     */
    public void setPhase(int phase) {
        this.phase = phase;
    }
}
