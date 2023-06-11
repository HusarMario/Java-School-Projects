package graphic.playground;

import graphic.DisplayNumber;
import graphic.Obrazok;
import graphic.controls.Clickable;
import graphic.controls.MapIcon;
import graphic.controls.Enter;
import map.Location;
import map.World;
import player.Player;

import java.util.ArrayList;

/**
 * Trieda prestavujúca typ hernej plochy
 * 17. 4. 2022 - 18:05
 *
 * @author Mário Husár
 */
public class WorldPlayground extends Playground implements IPlayerNeeded {
    private World world;
    private ObservatoryPlayground observatoryPlayground;

    private Player player;
    private DisplayNumber heroHealth;
    private DisplayNumber heroEnergy;
    private DisplayNumber heroGold;

    private ArrayList<MapIcon> mapIcons;
    private Location enter;
    private Obrazok locationInfo;


    /**
     * Vytvorenie inštancie konrétnej hernej plochy
     */
    public WorldPlayground() {
        super();
    }

    /**
     * Metóda spúšťa hracie pole observatórium z hracieho pola
     */
    public void observer() {
        if (this.observatoryPlayground == null) {
            this.hidePlayground();
            this.observatoryPlayground =  new ObservatoryPlayground(this.world);
            this.observatoryPlayground.showPlayground();
        } else {
            this.observatoryPlayground.hidePlayground();
            this.observatoryPlayground = null;
            this.showPlayground();
        }

    }

    /**
     * Metóda pre ovládanie s konkrétnou hernou plochou
     * @param x - súradnica x
     * @param y - súradnica y
     * @return vráti klikateľný objekt pre ďalšiu prácu s ním
     */
    @Override
    public Clickable findClickable(int x, int y) {
        Clickable clickable =  super.findClickable(x, y);
        if (clickable == null) {
            return null;
        }

        if (clickable instanceof MapIcon) {
            if ((((MapIcon) clickable).getLocation().isShown()) && (!((MapIcon)clickable).getLocation().isVisited())) {
                this.enter = ((MapIcon) clickable).getLocation();
                this.locationInfo.zmenObrazok(this.enter.getLocationInfoPath());
                this.locationInfo.show();
            }
        }

        if (clickable instanceof Enter) {
            if (this.enter != null) {
                this.world.openNextLocations(this.enter);

                return clickable;
            }
        }

        return null;
    }

    /**
     * Refreshnutie potrebných prvkov na hernej ploche
     */
    public void refresh() {
        this.locationInfo.zmenObrazok("src/graphic/pictures/locations/BlankInfo.png");
        this.locationInfo.show();
        this.enter = null;

        for (MapIcon mapIcon : this.mapIcons) {
            mapIcon.refresh();
        }
        this.heroHealth.hide();
        this.heroHealth.changeNumber(this.player.getHero().getHealth());
        this.heroHealth.show();
        this.heroEnergy.hide();
        this.heroEnergy.changeNumber(this.player.getHero().getEnergy());
        this.heroEnergy.show();
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

        Obrazok health = new Obrazok("src/graphic/pictures/atributes/Health.png");
        health.zmenPolohu(20, 200);
        health.zmenVelkost(30, 30);
        this.addShowable(health);
        this.heroHealth = new DisplayNumber(60, 210, 8, 2);
        this.heroHealth.changeNumber(this.player.getHero().getHealth());
        this.addShowable(this.heroHealth);

        Obrazok energy = new Obrazok("src/graphic/pictures/atributes/Energy.png");
        energy.zmenPolohu(20, 250);
        energy.zmenVelkost(30, 30);
        this.addShowable(energy);
        this.heroEnergy = new DisplayNumber(60, 260, 8 , 2);
        this.heroEnergy.changeNumber(this.player.getHero().getEnergyLimit());
        this.addShowable(this.heroEnergy);

        Obrazok gold = new Obrazok("src/graphic/pictures/atributes/Coins.png");
        gold.zmenPolohu(20, 300);
        gold.zmenVelkost(30, 30);
        this.addShowable(gold);
        this.heroGold = new DisplayNumber(60, 310, 8 , 2);
        this.heroGold.changeNumber(this.player.getGold());
        this.addShowable(this.heroGold);
    }

    /**
     * Prednastavenie celého zobrazenia hernej plochy
     */
    @Override
    public void setUp() {
        this.world = new World();
        this.observatoryPlayground = null;

        this.enter = null;
        this.locationInfo = new Obrazok("src/graphic/pictures/locations/BlankInfo.png");
        this.locationInfo.zmenPolohu(600,20);
        this.locationInfo.zmenVelkost(800, 400);
        this.addShowable(this.locationInfo);

        this.addShowable(new Enter(850, 420, 300, 50));


        this.mapIcons = new ArrayList<>();
        int col = 0;
        int row = 1;
        for (Location location : this.world.getLocations()) {
            if ((this.world.getLocations().get(0).equals(location)) || (this.world.getLocations().get(this.world.getLocations().size() - 1).equals(location))) {
                this.mapIcons.add(new MapIcon(65 + (col * 65), 600, 50, location));
                col++;
            } else {
                switch (row) {
                    case 1 -> {
                        this.mapIcons.add(new MapIcon(65 + col * 65, 500, 50, location));
                        row++;
                    }
                    case 2 -> {
                        this.mapIcons.add(new MapIcon(65 + col * 65, 600, 50, location));
                        row++;
                    }
                    case 3 -> {
                        this.mapIcons.add(new MapIcon(65 + col * 65, 700, 50, location));
                        row = 1;
                        col++;
                    }
                }
            }
        }

        for (MapIcon mapIcon : this.mapIcons) {
            this.addShowable(mapIcon);
        }
    }

    /**
     * Vytvorenie observatoria v hernej ploche
     * @return vracia observatorium
     */
    public ObservatoryPlayground getObservatoryPlayground() {
        return this.observatoryPlayground;
    }

    /**
     * Getter pre momentálnu miestnosť
     */
    public Location getEnter() {
        return this.enter;
    }

    /**
     * Boolen pre overenie nachádzania s v konečnej miestnosti
     * @return vracia true ak je hra v konečnej miestnosti
     */
    public boolean finalLocation() {
        return this.world.finalLocation();
    }
}
