package graphic.playground;

import cards.cardTypes.EnergyPotion;
import cards.cardTypes.HealPotion;
import graphic.DisplayNumber;
import graphic.Obrazok;
import graphic.controls.CardIcon;
import graphic.controls.Clickable;
import graphic.controls.Left;
import player.Player;

/**
 * Trieda prestavujúca typ hernej plochy
 * 17. 4. 2022 - 18:05
 *
 * @author Mário Husár
 */
public class MarketPlayground extends Playground implements IPlayerNeeded {
    private Player player;
    private DisplayNumber heroGold;

    /**
     * Vytvorenie inštancie konrétnej hernej plochy
     */
    public MarketPlayground() {
        super();
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

        if (clickable instanceof Left) {
            return clickable;
        }

        if (clickable instanceof CardIcon) {
            if (this.player.getGold() > 25) {
                switch (((CardIcon) clickable).getCard().getCardTitle()) {
                    case "HealPotion" -> this.player.getHero().getCardPack().addCard(new HealPotion());
                    case "EnergyPotion" -> this.player.getHero().getCardPack().addCard(new EnergyPotion());
                }
                this.player.spendGold(25);
                this.refresh();
            }
        }

        return null;
    }

    /**
     * Prednastavenie celého zobrazenia hernej plochy
     */
    @Override
    public void setUp() {
        this.addShowable(new Left(25, 725, 50));

        CardIcon healPotion = new CardIcon(200, 0, 550, 800, new HealPotion());
        healPotion.setCard(new HealPotion());
        this.addShowable(healPotion);

        CardIcon energyPotion = new CardIcon(800, 0, 550, 800, new EnergyPotion());
        energyPotion.setCard(new EnergyPotion());
        this.addShowable(energyPotion);
    }

    /**
     * Refreshnutie potrebných prvkov na hernej ploche
     */
    @Override
    public void refresh() {
        this.heroGold.hide();
        this.heroGold.changeNumber(this.player.getGold());
        this.heroGold.show();
    }

    /**
     * Doplennie hráča do hernej plochy
     * @param player - hráč
     */
    @Override
    public void attachPlayer(Player player) {
        this.player = player;

        Obrazok playerPicture = new Obrazok(this.player.getHero().getPicturePath());
        playerPicture.zmenPolohu(20, 20);
        playerPicture.zmenVelkost(150, 150);
        this.addShowable(playerPicture);

        Obrazok gold = new Obrazok("src/graphic/pictures/atributes/Coins.png");
        gold.zmenPolohu(20, 200);
        gold.zmenVelkost(30, 30);
        this.addShowable(gold);
        this.heroGold = new DisplayNumber(60, 210, 8 , 2);
        this.heroGold.changeNumber(this.player.getGold());
        this.addShowable(this.heroGold);
    }
}
