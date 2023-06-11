package graphic.playground;

import graphic.DisplayNumber;
import graphic.Obrazok;
import graphic.controls.Clickable;
import graphic.controls.Left;
import graphic.controls.Right;
import graphic.controls.Enter;
import player.PlayerCreator;

/**
 * Trieda prestavujúca typ hernej plochy
 * 17. 4. 2022 - 18:05
 *
 * @author Mário Husár
 */
public class PlayerCreatorPlayground extends Playground {

    private PlayerCreator playerCreator;

    private Obrazok heroAvatar;
    private DisplayNumber heroHealth;
    private DisplayNumber heroEnergy;

    /**
     * Vytvorenie inštancie konrétnej hernej plochy
     */
    public PlayerCreatorPlayground() {
        super();
    }

    /**
     * Getter na triedu vytvárania postáv
     * @return inštanciu
     */
    public PlayerCreator getPlayerCreator() {
        return this.playerCreator;
    }

    /**
     * Metóda pre ovládanie s konkrétnou hernou plochou
     * @param x - súradnica x
     * @param y - súradnica y
     * @return vráti klikateľný objekt pre ďalšiu prácu s ním
     */
    @Override
    public Clickable findClickable(int x, int y) {
        Clickable clickable = super.findClickable(x, y);
        if (clickable == null) {
            return null;
        }

        if (clickable instanceof Left) {
            this.heroAvatar.zmenObrazok(this.playerCreator.prevHero().getPicturePath());
            this.heroHealth.changeNumber(this.playerCreator.getHero().getHealth());
            this.heroEnergy.changeNumber(this.playerCreator.getHero().getEnergy());
            this.heroAvatar.show();
            this.heroHealth.show();
            this.heroEnergy.show();
        }

        if (clickable instanceof Right) {
            this.heroAvatar.zmenObrazok(this.playerCreator.nextHero().getPicturePath());
            this.heroHealth.changeNumber(this.playerCreator.getHero().getHealth());
            this.heroEnergy.changeNumber(this.playerCreator.getHero().getEnergy());
            this.heroAvatar.show();
            this.heroEnergy.show();
            this.heroHealth.show();
        }

        if (clickable instanceof Enter) {
            this.playerCreator.setHero();
            return clickable;
        }

        return null;
    }

    /**
     * Prednastavenie celého zobrazenia hernej plochy
     */
    @Override
    public void setUp() {
        this.playerCreator = new PlayerCreator();

        this.heroAvatar = new Obrazok(this.playerCreator.getHero().getPicturePath());
        this.heroAvatar.zmenPolohu(500, 150);
        this.heroAvatar.zmenVelkost(500, 500);
        this.addShowable(this.heroAvatar);

        Obrazok health = new Obrazok("src/graphic/pictures/atributes/Health.png");
        health.zmenPolohu(600, 100);
        health.zmenVelkost(30, 30);
        this.addShowable(health);
        this.heroHealth = new DisplayNumber(640, 110, 8, 2);
        this.heroHealth.changeNumber(this.playerCreator.getHero().getHealth());
        this.addShowable(this.heroHealth);

        Obrazok energy = new Obrazok("src/graphic/pictures/atributes/Energy.png");
        energy.zmenPolohu(800, 100);
        energy.zmenVelkost(30, 30);
        this.addShowable(energy);
        this.heroEnergy = new DisplayNumber(840, 110, 8 , 2);
        this.heroEnergy.changeNumber(this.playerCreator.getHero().getEnergy());
        this.addShowable(this.heroEnergy);


        this.addShowable(new Left(375, 475, 50));
        this.addShowable(new Right(1075, 475, 50));
        this.addShowable(new Enter(600, 700, 300, 50));
    }

    /**
     * Refreshnutie potrebných prvkov na hernej ploche
     */
    @Override
    public void refresh() {

    }
}
