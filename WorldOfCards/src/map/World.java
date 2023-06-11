package map;

import java.util.ArrayList;
import java.util.Random;


/**
 * Trieda prestavujúca mapu lokácií
 * 17. 4. 2022 - 18:05
 *
 * @author Mário Husár
 */

public class World {
    private final ArrayList<Location> locations;

    /**
     * Vytvorenie mapy lokácií
     */
    public World() {
        this.locations = new ArrayList<>();
        this.loadPhases();
    }

    /**
     * Automatické otvorenie najbližších lokácie podľa konkrétnej lokácie
     * @param location - otvorená lokácia
     */
    public void openNextLocations(Location location) {
        location.enterLocation();

        if (location instanceof StartingLocation) {
            this.locations.get(1).showLoaction();
            this.locations.get(2).showLoaction();
            this.locations.get(3).showLoaction();
        } else {
            int index = 0;
            for (Location search : this.locations) {
                if (search.equals(location)) {
                    break;
                } else {
                    index++;
                }
            }
            if (index > 3) {
                this.locations.get(index - 3).showLoaction();
            }
            if (index < 55) {
                this.locations.get(index + 3).showLoaction();
            }
            if (index % 3 == 1) {
                this.locations.get(index + 1).showLoaction();
            } else if (index % 3 == 0) {
                this.locations.get(index - 1).showLoaction();
            } else {
                this.locations.get(index - 1).showLoaction();
                this.locations.get(index + 1).showLoaction();
            }
            if ((index == 55) || (index == 56) || (index == 57)) {
                this.locations.get(58).showLoaction();
            }

        }
    }

    /**
     * Vytvorenie lokácií vo svete
     */
    private void loadPhases() {
        Random random = new Random();

        for (int i = 0; i < 21; i++) {
            if (i == 0) {
                this.locations.add(new StartingLocation());
            } else if (i == 20) {
                this.locations.add(new FinalLocation());
            } else if (i == 1) {
                this.locations.add(new PotionMaker());
                this.locations.add(new BattleLocation());
                this.locations.add(new Observatory());
            } else {
                this.locations.add(this.randomizeLocation(random.nextInt(0,10)));
                this.locations.add(this.randomizeLocation(random.nextInt(0,10)));
                this.locations.add(this.randomizeLocation(random.nextInt(0,10)));
            }
        }

        this.locations.get(0).showLoaction();
    }

    /**
     * Pomocná trieda pre dosadenie náhodných lokácií
     * @param randValue - náhodne generovaná hodnota
     * @return vráti lokáciu podľa genrátora
     */
    private Location randomizeLocation(int randValue) {
        switch (randValue) {
            case 0, 1, 2, 3, 4, 5 -> {
                return new BattleLocation();
            }
            case 6 -> {
                return new PotionMaker();
            }
            case 7, 8 -> {
                return new FallenBridgeLocation();
            }
            case  9 -> {
                return new Observatory();
            }
        }
        return null;
    }

    /**
     * Getter pre arraylist lokácií
     * @return vráti totožný arraylist pre prácu s lokáciami
     */
    public ArrayList<Location> getLocations() {
        return new ArrayList<>(this.locations);
    }

    /**
     * Overenie navštívenie poslednej lokície
     * @return vráti true ak bola navštívená
     */
    public boolean finalLocation() {
        return  this.locations.get(this.locations.size() - 1).isVisited();
    }
}
