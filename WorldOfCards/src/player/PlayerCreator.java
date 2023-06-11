package player;

import characters.hero.Hero;
import characters.hero.Mage;
import characters.hero.Paladin;
import characters.hero.Warrior;


import java.util.ArrayList;

/**
 * Trieda vytvárania hráča a výberu jeho postavy
 * 17. 4. 2022 - 18:05
 *
 * @author user
 */
public class PlayerCreator {
    private final Player player;
    private final ArrayList<Hero> heroes;
    private int heroIndex;

    /**
     * Vytvorenie inštatncie triedy
     */
    public PlayerCreator() {
        this.player = new Player();
        this.heroes = new ArrayList<>();
        this.heroIndex = 0;
        this.addHeros();
    }

    /**
     * Getter hráča
     * @return hráč
     */
    public Player getPlayer() {
        return this.player;
    }

    /**
     * Nastavenie hrdinu hráčovi
     */
    public void setHero() {
        this.player.setHero(this.heroes.get(this.heroIndex));
    }

    /**
     * Posun výberom postáv smerom nadol
     * @return vráti postavu na danom indexe
     */
    public Hero prevHero() {
        if (--this.heroIndex == -1) {
            this.heroIndex = this.heroes.size() - 1;
        }
        return this.heroes.get(this.heroIndex);
    }

    /**
     * Presun výberom postáv smerom nahor
     * @return vráti postavu na danom indexe
     */
    public Hero nextHero() {
        if (++this.heroIndex == this.heroes.size()) {
            this.heroIndex = 0;
        }
        return this.heroes.get(this.heroIndex);
    }

    /**
     * Getter na hrdinu na danom indexe
     * @return vráti hrdinu
     */
    public Hero getHero() {
        return this.heroes.get(this.heroIndex);
    }

    /**
     * Pridanie hrdinov do výberu postáv
     */
    private void addHeros() {
        this.heroes.add(new Mage());
        this.heroes.add(new Paladin());
        this.heroes.add(new Warrior());
    }
}
